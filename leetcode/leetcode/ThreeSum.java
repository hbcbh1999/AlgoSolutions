/*
Given an array S of n integers, are there elements a, b, c in S such that 
a + b + c = 0? Find all unique triplets in the array which gives the sum of 
zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; ++i) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int threeSum = nums[i] + nums[low] + nums[high];
                if (threeSum == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    result.add(list);
                    break;
                } else if (threeSum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }

}