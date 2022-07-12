package com.solid.tekcreek.ocp;

import com.sun.jdi.Value;

import java.util.Arrays;

public class OpenClosedEx1 {

    // Open Closed Principle - Objects or entities should be open for extension but closed for modification
    public static void main(String[] args) {

        int arr[] = {1,5,4,2,3};
        ArrayUtil.sort(arr);

        System.out.println("Values in the array are ");
        Arrays.stream(arr).forEach(e -> System.out.println(e));

        ArrayUtil2.sort(arr,new DescComparator());
        Arrays.stream(arr).forEach(e -> System.out.println(e));
    }
}
// Problem
class ArrayUtil{

    public static  void sort(int[] a){
        for(int i = 0;i < a.length;i++){
            for(int j = i + 1;j<a.length;j++){
                if(a[i]>a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

}

// If somebody comes and say sort in descending order
// Possible solutions - 1 . introduce new argument in sort method  which says sorting order - asc or desc  and apply logic accordingly in the method
// 2 . create new method for descending order  like sortDesc(arr)
//  This way will keep adding methods and cases not a good idea

// Solution
// now don't need to modify ArrayUtil2
//
interface  ValueComparator{
    int compare(int value1,int value2);
}

class ArrayUtil2{

    public static final void sort(int a[], ValueComparator comparator){
        for(int i = 0;i < a.length;i++){
            for(int j = i + 1;j<a.length;j++){
                if(comparator.compare(a[i],a[j]) > 0){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}

class AscComparator implements  ValueComparator{

    @Override
    public int compare(int value1, int value2) {
        return value1 - value2;
    }
}

class DescComparator implements  ValueComparator{

    @Override
    public int compare(int value1, int value2) {
        return value2 - value1;
    }
}

