package com.example.algorithm.doublePoint;

/**
 * @author lixiang
 * @date 2021/4/15 22:15
 */
public class RemoveDuplicateElement {

    public static int removeDuplicates(int[] nums) {
        if (nums==null || nums.length ==0){
            return 0;
        }
        int left = 0;
        for (int right = 1;right<nums.length;right++){
            if (nums[right]!=nums[left]){
                nums[++left]=nums[right];
            }
        }
        return ++left;
    }
    public static void main(String[] args) {
        int []nums = {0,0,1,1,1,2,2,3,3,4};
        int count =removeDuplicates(nums);
    }
}
