package com.example.algorithm.array;

/**
 * @author lixiang
 * @date 2021/4/18 10:54
 */
public class FindMidIndex {
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum-nums[0]==0){
            return 0;
        }
        int leftsum=0;
        for(int k=1;k<nums.length;k++){
            leftsum+=nums[k-1];
            if(leftsum==sum-nums[k]-leftsum){
                return k;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,-1,1};
        System.out.println(pivotIndex(nums));
    }
}
