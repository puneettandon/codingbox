package com.practice.dsa.array;

public class PeakElementArray {

    public static void main(String[] args) {

        int arr[] = new int[]{10, 20, 15, 2, 23, 90, 67};
        int n = arr.length;

        int index = findPeakNaive(arr,n); // T. C. --  O(n)
        System.out.println("Index of peak point is: "+index + " val : "+arr[index]);

        int index2 = findPeakDivideAndConquer(arr,n);
        System.out.println("Index of peak point using divide and conquer is: "+index2+ " val : "+arr[index2]);
     }

    private static int findPeakNaive(int[] arr, int n) {
        if(n == 1){
            return 0;
        }
        // corner case
        if(arr[0]> arr[1]){
            return 0;
        }
        //  corner case
        if(arr[n-1] >= arr[n-2])
            return n-1;

        // Check for every other element
        for(int i= 1;i<n-1;i++){
            if(arr[i]>=arr[i-1] && arr[i]>=arr[i+1])
                return i;
        }
        return 0;
    }

    private static int findPeakDivideAndConquer(int[] arr, int n) {
        return  findPeakDivideAndConquerUtil(arr,0,n-1,n);
    }

    private static int findPeakDivideAndConquerUtil(int[] arr, int low, int high, int n) {

        int mid = low + (high - low) / 2;

        if ((mid == 0 || arr[mid - 1] <= arr[mid])
                && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
            return mid;

        else if (mid > 0 && arr[mid - 1] > arr[mid])
            return findPeakDivideAndConquerUtil(arr, low, (mid - 1), n);

        else
            return findPeakDivideAndConquerUtil(arr, (mid + 1), high, n);
    }
}
