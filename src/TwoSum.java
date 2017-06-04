/**
 * From www.leetcode.com
 *
 * Two sum
 * Given an array of integers, return indicies of the two numbers such that they add up to a specific target
 * You may assume that each input would have exactly one solution and you may not use the same element twice
 *
 * Created by Christie on 6/3/2017.
 */
public class TwoSum {

    private static int[] twoSum(int[] nums, int target){
        int[] result = new int[]{};
        int index1 = 0;
        int index2 = 1;
        while (index1 < nums.length && index2 < nums.length){
            if (nums[index1] + nums[index2] == target){
                result = new int[]{index1, index2};
                break;
            } else {
                if (index2 == nums.length - 1 && index1 < nums.length){
                    index1 += 1;
                    index2 = index1 + 1;
                } else {
                    index2 += 1;
                }
            }
        }
        return result;
    }
    public static void main (String[] args){
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 26;

        int[] result = twoSum(arr, target);
        System.out.print("Array: [");
        for (int i=0; i <arr.length; i++){
            if (i == arr.length-1){
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }

        }
        System.out.println("]");
        System.out.println("Target: " + target + " \nResult at: [" + result[0] + "," + result[1] + "]");

    }
}
