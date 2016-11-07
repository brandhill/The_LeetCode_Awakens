public class Solution {

    public int search(int[] nums, int target) {

        for (int i = 0; i < nums.length; ++i) {

        }

    }

    int binarySearch(int[] nums, int target) {
        int index = begin + (end - begin) / 2;

        if (target == nums[index]) {
            System.out.println("got target!!!");
            return index;
        } else if (target > nums[index]) {
            System.out.println("searching " + (begin + (end - begin)/2 + 1) + " to " + end);
            return binarySearch(nums, begin + (end - begin)/2 + 1, end, target);
        } else {
            System.out.println("searching " + begin + " to " + (begin + (end - begin)/2 - 1));
            return binarySearch(nums, begin, begin + (end - begin)/2 - 1, target);
        }
    }
}
