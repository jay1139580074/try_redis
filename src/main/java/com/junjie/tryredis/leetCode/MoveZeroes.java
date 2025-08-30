package com.junjie.tryredis.leetCode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/*
* 输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
* temp = nums[i]
* nums[i] = muns[i+1]
* nums[i+1] = temp
*               i slow
* 1 0 0 3 12    3 1
*
* */
@Slf4j
public class MoveZeroes {
//0 1 0 3 12
    public static void moveZeroes(int[] nums) {
        int j = 0;//只有有非0，才加一位，记录多少个非0，使用++顺序防止
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                System.out.println("******  i="+ i + " , j=" + j);
                swap(nums, i, j++);
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println("--------------");
        System.out.println(Arrays.toString(nums));
    }
    }

