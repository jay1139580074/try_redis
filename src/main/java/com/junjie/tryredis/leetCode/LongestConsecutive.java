package com.junjie.tryredis.leetCode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
* 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
示例 1：
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：
输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
示例 3：
输入：nums = [1,0,1,2]
输出：3

提示：
0 <= nums.length <= 105
-109 <= nums[i] <= 109
* */
@Slf4j
public class LongestConsecutive {

    public static void main(String[] args) {
        int test1[] = {100,4,200,1,3,2};
        int test2[] = {0,3,7,2,5,8,4,6,0,1};
        int test3[] = {1,0,1,2};

        System.out.println(findLongestConsecutive1(test1));
        System.out.println(findLongestConsecutive1(test2));
        System.out.println(findLongestConsecutive1(test3));
    }

    public static int findLongestConsecutive1(int[] nums) {
        //find start    n-1 not in collection, its start num
        //use ++, collect
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return set.stream()
                .filter(num -> !set.contains(num - 1)) // only start from sequence heads
                .mapToInt(start -> {
                    log.info("start: {}", start);
                    int length = 1;
                    int current = start;
                    while (set.contains(current + 1)) {
                        current++;
                        length++;
                    }
                    log.info("length: {}", length);
                    return length;
                })
                .max()
                .orElse(0);
    }

    public static int findLongestConsecutive(int[] nums) {
       var set  = Arrays.stream(nums).boxed().collect(Collectors.toSet());
       return set.stream()
               .filter(e1 -> !set.contains(e1-1))
               .mapToInt(start -> {
                   log.info("start: {}", start);
                   int length = 1;
                   int current = start;
                   while(set.contains(current+1)){
                       current++;
                       length++;
                   }
                   return length;})
               .max()
               .orElse(0);

    }
}
