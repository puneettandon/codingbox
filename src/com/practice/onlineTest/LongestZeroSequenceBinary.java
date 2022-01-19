package com.practice.onlineTest;

public class LongestZeroSequenceBinary {

    public static void main(String[] args) {

        int number = 7;

        int res = findLongestZeroSequenceBinary(number);
        System.out.println("Result: "+res);
    }

    private static int findLongestZeroSequenceBinary(int num) {

        int maxm = -1;

        // to temporary store the consecutive 0's
        int cnt = 0;

        while (num != 0) {
            if ((num & 1) == 0 ) {
                cnt++;
                num >>= 1;
                maxm = Math.max(maxm, cnt);
            }
            else {

                maxm = Math.max(maxm, cnt);
                cnt = 0;
                num >>= 1;
            }
        }
        return maxm;

    }
}
