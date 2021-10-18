package com.sxg.jdk.stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 多个集合取交集
 *
 * @author sxg
 * create in 2021/10/8
 */
public class Intersection {


    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Lists.newArrayList(1, 2, 3, 4));
        result.add(Lists.newArrayList(1, 3, 4));
        result.add(Lists.newArrayList(1, 2, 3));
        List<Integer> list = result.stream().reduce((a, b) -> {
            a.retainAll(b);
            return a;
        }).orElse(Collections.emptyList());
        System.out.println(list);
    }
}
