package com.example.algorithm.array.doubleDimensional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiang
 * @date 2021/4/19 23:06
 */
public class DiagonallyTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length==0){
            return new int[]{};
        }
        List list = new ArrayList();
        for (int i =0;i<mat.length+mat[0].length-1;i++){
            if (i%2==0){
                for (int j=Math.min(mat.length,i);j<Math.min(mat[0].length,i);j++){
                    list.add(mat[i][j]);
                }
            }else {

            }
        }

        int[] result =new int[mat.length*mat[0].length];

        return result;
    }
}
