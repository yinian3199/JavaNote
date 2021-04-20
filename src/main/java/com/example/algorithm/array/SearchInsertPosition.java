package com.example.algorithm.array;

/**
 * @author lixiang
 * @date 2021/4/18 14:11
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right =nums.length-1;
        while(left<=right){
            int half = (left+right)/2;
            if(nums[half]==target){
                return half;
            }else if(nums[half]>target){
                right = half - 1;
            }else{
                left = half + 1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},5));
    }
}
