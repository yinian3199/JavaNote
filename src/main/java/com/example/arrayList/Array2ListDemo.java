package com.example.arrayList;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lixiang
 * @date 2021/3/28 12:54
 */
public class Array2ListDemo {
    public static void main(String[] args) {

        //Guava
        List<String> list1 = ImmutableList.of("e1","e2","e3");
        List<String> list2 = Lists.newArrayList("e1","e2","e3");
        list2.add("e4");
        String []array1 = new String[]{"e11","e12","e13"};
        List<String> list3 = ImmutableList.copyOf(array1);
        List<String> list4 = Lists.newArrayList(array1);
        list4.add("e14");

        List<String> list5 = new ArrayList<>(Arrays.asList(array1));
        list5.add("e14");

        //Stream
        List<String> list = Arrays.stream(array1).collect(Collectors.toList());
        list.add("e14");
        int []array2= {1,2,3,4};
        List list6 = Arrays.stream(array2).boxed().collect(Collectors.toList());
        list6.add(5);
        Integer []array3 = {1,2,3};
        List list7 = Arrays.stream(array3).collect(Collectors.toList());
        list7.add(4);

        //list to Array
        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> stringList = Arrays.asList(s);
        Collections.reverse(stringList);
        String []s2 = new String[stringList.size()];
        s2 = stringList.toArray(new String[0]);


        List<String> list8 = new ArrayList<>();
        list8.add("1");
        list8.add("2");
        //反例
/*        for (String item: list8){
            if ("2".equals(item)){
                list8.remove(item);
            }
        }*/
        //正例
        Iterator<String> iterator = list8.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            if ("2".equals(item)){
                iterator.remove();
            }
        }

        System.out.println();
    }
}
