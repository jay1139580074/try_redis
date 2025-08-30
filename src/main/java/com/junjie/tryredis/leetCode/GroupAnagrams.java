package com.junjie.tryredis.leetCode;

import java.util.*;

/*
* 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

解释：
在 strs 中没有字符串可以通过重新排列来形成 "bat"。
字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。

提示：
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] 仅包含小写字母
* */
public class GroupAnagrams {

    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagramsT(strs);

        System.out.println(result);
    }


    public static List<List<String>> groupAnagramsT(String[] strs) {
        //Map <String, List<String>>  key: after sort -- same str, value: the init str
        //at last, return the new List<map.val>

        Map<String, List<String>> map = new HashMap<>();
        for(String word : strs) {
            char[] charStr = word.toCharArray();
            Arrays.sort(charStr);
            String charKey = String.valueOf(charStr);
            if(map.containsKey(charKey)){
                map.get(charKey).add(word);
            } else {
                map.put(charKey, new ArrayList<>(List.of(word)));
            }
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();


        for (String word : strs) {
            // 将字符串排序后作为 key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(map.containsKey(key)){
                map.get(key).add(word);
            } else {
                map.put(key, new ArrayList<>(List.of(word)));
            }

            // 将相同 key 的字符串放入同一个列表
//            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        // 返回所有分组结果
        return new ArrayList<>(map.values());
    }

}
