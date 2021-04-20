package com.example.algorithm.array;

import java.util.Arrays;
import java.util.Vector;

/**
 * @author lixiang
 * @date 2021/4/18 11:25
 */
public class MergeSection {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2) -> o1[0] - o2[0]);
        Vector<int[]> intVector = new Vector<>();
        int[] ints = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=ints[1]){
                ints[1]=Math.max(intervals[i][1],ints[1]);
            }else{
                intVector.add(ints);
                ints = intervals[i];
            }
        }
        intVector.add(ints);
        return intVector.toArray(new int[intVector.size()][2]);

    }

    public static void main(String[] args) {
        int[][] ints = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result=merge(ints);
        System.out.println();
    }
}
