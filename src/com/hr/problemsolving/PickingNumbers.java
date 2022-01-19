package com.hr.problemsolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(6);
        numbers.add(5);
        numbers.add(3);
        numbers.add(3);
        numbers.add(1);

        System.out.println(pickingNumbers(numbers));

    }

    public static int pickingNumbers(List<Integer> numbers) {
        int count = 0;
        int maxCount = 0;
        for(int i = 0;i< numbers.size();i++){
            count = 0;
            List<Integer> testNumbers = new ArrayList<>(numbers);
            for(int j = 0;j< numbers.size();j++) {
                int val = testNumbers.get(j);
                int subVal = numbers.get(i);
                testNumbers.set(j, (val - subVal));
                if(testNumbers.get(j) >= -1 && testNumbers.get(j) <= 0)
                    count++;
            }
            if(count > maxCount)
                maxCount = count;
        }
        return maxCount;
    }
}
