package com.sxg.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * @author foreversxg
 * create in 2021/6/29
 */
public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            result.add(0);// rowIndex 递增，列表的长度也要增加，否则下面操作可能出现越界
            for (int j = i; j > 0; j--) {
                // 为了达成O(K)的空间复杂度需要复用同一个数组，所以需要从后往前计算，因为第i列的第j个元素v(i,j) 等于 v(i-1,j) + v(i-1,j-1)
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}
