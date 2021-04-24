package com.example.algorithm.array.doubleDimensional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiang
 * @date 2021/4/19 23:06
 * 使用list转数组，占用内存更少，执行时间较长
 * 直接使用数组，执行时间较少，占用内存较多
 */
public class DiagonallyTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat.length==0){
            return new int[]{};
        }
//        List<Integer> list = new ArrayList();
        int row = mat.length;
        int col = mat[0].length;
        int sum = row+col-1;
        int []result = new int[row*col];
        int index= 0;
        for (int i=0; i<sum; i++){
            if (i%2==0){
                for (int j = Math.min(i,row-1); (j>=0)&&(i-j<=col-1); j--){
//                    list.add(mat[j][i-j]);
                    result[index++]=mat[j][i-j];
                }
            }else {
                for (int j =Math.min(i,col-1); (j>=0)&&(i-j)<=row-1; j--){
//                    list.add(mat[i-j][j]);
                    result[index++]=mat[i-j][j];
                }
            }
        }
//        int[] result = list.stream().mapToInt(Integer::valueOf).toArray();
        return result;
    }

    public static void main(String[] args) {
//        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int [][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] result = findDiagonalOrder(mat);
        for (int i: result){
            System.out.println(i);
        }
    }
}
