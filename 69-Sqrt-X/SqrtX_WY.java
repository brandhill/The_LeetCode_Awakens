/**

# questions
what if x is not equal to sqrt of n, says x = 2, or 3, what is the expecting return value?

# Thoughts
my first guess this problem can be solved by bit-wise operations.
From the math equation, there should be some bit-wise operations to do it.
But I can't figure this out in this short time.
Starting from most significant bit and perform some operations. than 

So here is my second solution: map this problem to a searh problem.
find N in given range 1~x which n*n == x

the given range 1~x can be seen as a sorted array.
we can perfrom an binary search on that array to find N

# review
邊界條件沒有想清楚，try-and-error浪費太多時間
用 recursive 去做binary search CODE 不乾淨

 */
public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        
        int left = 1;
        int right = x;
        while(left <= right) {
            int mid = (left + right) / 2;
            int d = x / mid;
            if(d == mid) return mid;
            else if(d < mid) {
                right = mid - 1;
            } else if(d > mid) {
                left = mid  + 1;
            }
        }
        
        return right;
    }
}
