package com.collections.demo.collections2;

import java.util.*;

public class coll2 {
    public static void main(String[] args) {
        {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7);
        for (Integer num : nums) {
            if (num % 2 == 1) {
                System.out.println(num);
            }
        }
        }
        System.out.println("================");
        {
            List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7);
            Set<Integer> set = new TreeSet<>(nums);
            for (Integer i : set) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        }
        System.out.println("================");
        {
            var strs = List.of("baz", "ligh", "ter", "baz", "ligh");
            var set = new HashSet<>(strs);
            for (String s : set) {
                System.out.println(s);
            }
        }
        System.out.println("================");
        {
            List<String> strings = List.of("один", "два","два", "три", "три", "три");
            Map<String, Integer> map = new HashMap<>();
            for (String word : strings) {
                var num = map.get(word);
                if (num == null) {
                    map.put(word, 1);
                } else {
                    map.put(word, num + 1);
                }
            }
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                System.out.println(pair.getKey() + "-->" + pair.getValue());
            }

            for (Integer value : map.values()) {
                System.out.println(value);
            }
            for (String s : map.keySet()) {
                System.out.println(s);
            }


        }
    }
}
