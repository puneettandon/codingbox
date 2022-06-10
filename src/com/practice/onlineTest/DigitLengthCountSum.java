package com.practice.onlineTest;
//

// 1-9 ---------- 1 * 9
// 10 - 99 ------------ 2 *  90 = 99 -9
// 100 - 999 ..........   3 * 900 = 999-99
public class DigitLengthCountSum {

    public static void main(String[] args) {

        int n = 103;
        int q = n;
        int digitCount = 0;
        while(q > 0){
            q = q/10;
            digitCount++;
        }
       // get power
        int d = 0;
        // calculate power
        int start = 1;
        int num = 10;
        int digitCountSum = 0;
        int prevStore = 0;
        int currentStore = 0;
        int totalDigit = 0;
        while(start <= digitCount){
            int res = getPower(num,start);
            if(start == digitCount){
                res = getPower(num,start-1);
               int finalDigit = n%(res);
               totalDigit = finalDigit + 1;
               digitCountSum = digitCountSum + totalDigit * start;
            }else {
                prevStore = currentStore;
                currentStore = res - 1 - prevStore;
                digitCountSum = digitCountSum + currentStore * start;
            }
            start++;
        }

        System.out.println("Digit Count Sum : "+digitCountSum);
      //  getPower(10,0);

    }

    private static int getPower(int num, int digitCount) {
        int res = 1;
        int q = num;
        while(digitCount > 0){
            res = res * num;
            digitCount--;
        }
        return res;
    }
}
