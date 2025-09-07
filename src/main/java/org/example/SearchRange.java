package org.example;

import java.util.Arrays;

public class SearchRange {
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    /* Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
*/
    public static int[] searchRange(int[] nums, int target) {
        int firstInd = findFirst(nums, target);
        int lastInd = findlast(nums, target);
        return new int []{firstInd,lastInd};
    }
    private static int findFirst(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1, ans = -1;
        while (start <= end){
            int mid = start + ((end - start) / 2);
            if (target == nums[mid]){
                ans = mid;
                end = mid - 1;
            }
            else if (target < nums[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        } return ans;
    }
    private static int findlast (int[] nums, int target){
        int start = 0;
        int end = nums.length - 1, ans = -1;
        while (start <= end){
            int mid = start + ((end - start) / 2);
            if (target == nums[mid]){
                ans = mid;
                start  = mid + 1;
            }
            else if (target < nums[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        } return ans;
    }
    public static void main(String[] args) {
        int [] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
}
