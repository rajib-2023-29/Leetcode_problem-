package org.example;

import java.util.Scanner;
// https://leetcode.com/problems/missing-number/description/
/* Given an array nums containing n distinct numbers in the range [0, n],
 return the only number in the range that is missing from the array.
Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation:
n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
2 is the missing number in the range since it does not appear in nums.
Example 2:
Input: nums = [0,1]
Output: 2
Explanation:
n = 2 since there are 2 numbers, so all numbers are in the range [0,2].
2 is the missing number in the range since it does not appear in nums.
Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation:
n = 9 since there are 9 numbers, so all numbers are in the range [0,9].
8 is the missing number in the range since it does not appear in nums. */

class MissingNumber {
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        System.out.println("Enter the size of the array : ");
        int size = in.nextInt();
        int [] arr = new int [size];
        System.out.println("Enter the elements of the array : ");
        for(int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("The missing element is : ");
        System.out.println(missingNumber(arr));
    }
        public static int missingNumber(int[] nums) {
            int i = 0;
            while (i < nums.length){
                int correctIndex = nums[i];
                if (nums[i] < nums.length && nums[i] != nums[correctIndex]){
                    swap(nums, i, correctIndex);
                }else{
                    i++;
                }
            }
            for (int j = 0; j < nums.length; j++){
                if (nums[j]  != j){
                    return j;
                }
            } // If no mismatch found, missing number is the last one
            return nums.length;
        }
       static void swap(int[] nums, int s, int e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
        }
    }