package com.example.algorithm.array.doubleDimensional;

import java.util.*;

/**
 * @author lixiang
 * @date 2021/4/19 22:06
 */
public class ZeroMatrix {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i=0;i<matrix.length;i++){
            for (int j = 0; j <matrix[0].length ; j++) {
                if (matrix[i][j] ==0){
                    column[j]=true;
                    row[i]=true;
                }
            }
        }
        for (int r =0; r<matrix.length; r++){
            for (int l = 0; l <matrix[0].length ; l++) {
                if (row[r] || column[l]){
                    matrix[r][l]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Set<Integer> line= new HashSet<>();
        line.add(11);
        line.add(11);
        line.add(10);
        System.out.println(line);
    }
}
