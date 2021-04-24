package com.example.algorithm.array.characterString;

public class LongestPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String result = strs[0];
        for (int i=0;i<result.length();i++){
            char temp = result.charAt(i);
            for (int j=1;j< strs.length;j++){
                if ((strs[j].length()-1)<i || temp !=strs[j].charAt(i)){
                    return strs[j].substring(0,i);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(null));
    }
}
