package com.example.algorithm.array.doubleDimensional;

/**
 * @author lixiang
 * @date 2021/4/18 22:21
 */
public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len==1){
            return;
        }
        int[][] newMatrix =new int[len][len];
        for (int i=0;i<len;i++){
            for (int j = 0; j < len; j++) {
                newMatrix[i][j]=matrix[len-1-j][i];
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <len ; j++) {
                matrix[i][j]=newMatrix[i][j];
            }
        }
    }

    public static void main(String[] args) {
        ;
    }
}
