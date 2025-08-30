package com.junjie.tryredis.leetCode;

import java.util.Arrays;

public class Bubble {

    public static int[] bubbleSort(int[] arr) {
        boolean swapped;
        var length = arr.length;
        for (int i = 0; i < length; i++) {// i only used for control the number of compare
            swapped = false;
            swapped = CAS(arr, length, i, swapped);
            if(!swapped) break;;
        }
        return arr;
    }
    /*
     * 3 9 5 7 4
     * 3 5 7 4 9
     *
     * */
    private static boolean CAS(int[] arr, int length, int i, boolean swapped) {
        for(int j = 0; j < length -1 - i; j++){//i = 0 , j=0, j<4
            if(arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
                swapped = true;
            }
        }
        System.out.println(Arrays.toString(arr));
        return swapped;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        Arrays.stream(bubbleSort(arr)).forEach(System.out::println);
    }
}
