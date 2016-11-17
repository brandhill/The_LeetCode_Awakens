public class Solution {
    public static void main(String[] args) {
        int preRun = Integer.valueOf(args[0]);
        int input = Integer.valueOf(args[1]);
        int runs = Integer.valueOf(args[2]);
        test(new FakeSqrt(), preRun, input, runs);
        test(new BitSqrt(), preRun, input, runs);
        test(new NewtonSqrt(), preRun, input, runs);
        test(new NewtonWithOneMsbSqrt(), preRun, input, runs);
        test(new BinarySearchSqrt(), preRun, input, runs);
    }

    private static void log (String s) {
        System.out.println(s);
    }
    private static void test(SqrtCaculator c, int preRun, int input, int runs) {
        long start = 0;
        start = System.nanoTime();
        for (int i = preRun ;i < runs; i++) {
            if(i == 0) start = System.nanoTime();
            c.mySqrt(input);
            //int ret = c.mySqrt(input);
            //if(i == 0) log("ret:"+ret);
        }
        long time = System.nanoTime() - start;
        System.out.printf(c.getClass().getSimpleName()+" an average of %,d ns, total: %.3f, runs:%d %n", time/runs, (double)time/1000000, runs);
    }

    private interface SqrtCaculator {
        public int mySqrt(int x);
    }

    /*
     *  Use binary search to get root square
     *  time complexity O(ln(n)), where n <= 2^M, M is the numbers of bit of int.
     *
     *  So you can say the complexity is O(1) in this sense.
     *  Slowest method
     */

    private static class BinarySearchSqrt implements SqrtCaculator {
        public int mySqrt(int x) {
            int h = x;
            int l = 1;
            while (h > l) {
                int mid = (h+l)/2;
                int s = x/mid;
                if (s > mid) {
                    l = mid+1;
                } else if (s < mid){
                    h = mid-1;
                } else {
                    return mid;
                }
            }
            return h*h <= x ? h : h -1;
        }
    }

    /*
     * Greedy Algorithm to get result bit by bit, time complexity O(ln(n)), where n <= 2^M,
     * M is the numbers of bit of int. So you can say the complexity is O(1) in this sense.
     *
     * The time cost is relative to the bit number of input, not the value of input
     * This method has best average time complexity if the input distribution is not left skew too much
     * (In my compute, it is worse than binary sqrt if n <= 2^12, but not much.It may be worse between 2^12 ~ 2^22
     * depending on the bit number of input, better between 2^22 ~ 2^31-1).
     *
     */
    private static class BitSqrt implements SqrtCaculator {
        public int mySqrt(int x) {
            int ret = 0;
            for (int mask = 1 << 15; mask != 0; mask >>= 1) {
                int next = ret | mask; //set bit
                if (next <= x / next) ret = next;
            }
            return ret;
        }
    }

    /*
     *  Use newton's method to get the root. The efficiency highly depends on the initial value x0
     *  If we have x0 approximates sqrt(x) to k significant bits, then
     *  time complexity O(ln(ln(n))), where n <= 2^M, M is the numbers of bit of int.
     *  However, if we don't know how to find a good x0, its' performance is only better than binary search
     *  by some coeficient.
     */
    private static class NewtonSqrt implements SqrtCaculator {
        public int mySqrt(int x) {
            int root = 1+(x>>1);
            int mag = 0;
            while (root > mag) {
                mag = x/root;
                root = (root+mag) >> 1;

            }
            return root;
        }
    }

    /*
     *  Use newton's method with a x0 which has at least 1 sig. bit.
     *  The first sig bit is get by binary search
     *  time complexity O(ln(ln(n))), where n <= 2^M, M is the numbers of bit of int.
     */
    private static class NewtonWithOneMsbSqrt implements SqrtCaculator {
        public int mySqrt(int x) {
            int h = 31;
            int l = 0;
            int root = 0;
            int m = 0;
            int halfX = (x>>1);
            while (h >= l) {
                m = (h+l)/2;
                root = 1<<m;
                if (root > x) {
                    h = m -1;
                } else if (root < x) {
                    if (root > (halfX)) break;
                    l = m + 1;
                } else {
                    break;
                }
            }
            root = 1<<((m>>1)+1);
            int mag = 0;
            while (root > mag) {
                mag = x/root;
                root = (root+mag) >> 1;
            }
            return root;
        }
    }

    /*
     *  Empty class to profiling basic cost
     */
    private static class FakeSqrt implements SqrtCaculator {
        public int mySqrt(int x) {
            return 0;
        }
    }
}

