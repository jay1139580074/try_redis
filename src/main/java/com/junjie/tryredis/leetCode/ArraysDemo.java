package com.junjie.tryredis.leetCode;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/*
* 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
你可以按任意顺序返回答案。
*
*
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
* */
public class ArraysDemo {

    public static void main(String[] args) {

        int test1[] = {2,7,11,15};
        int target1 = 9;
        int test2[] = {3,2,4};
        int target2 = 6;
        int test3[] = {3,3};
        int target3 = 6;

        System.out.println(sum(test1, target1));
        System.out.println(sum(test2, target2));
        System.out.println(sum(test3, target3));
    }

    public static int[] sum(int[] nums, int target){
        var map = new HashMap<Integer, Integer>();
        for(int i = 0; i< nums.length; i++) {
            int e1 = nums[i];
            if(map.containsKey(target-e1)){
                return new int[]{map.get(target-e1), i};
            }
            map.put(e1, i);
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        var map  = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int e1 = nums[i];
            if(map.containsKey(target - e1)){
                return new int[]{map.get(target - e1), i};
            }
            map.put(e1, i);
        }
        CountDownLatch countDownLatch = new CountDownLatch(3);
        countDownLatch.countDown();

        return null;

    }
}
