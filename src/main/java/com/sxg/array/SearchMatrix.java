package com.sxg.array;

/**
 * 搜索二维矩阵 II
 * <p>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * @author sxg
 * create in 2021/9/16
 */
public class SearchMatrix {

    /**
     * 应该从最下角或者右下角入手，应该这两个位置所在的行和列中，一个是最大值一个是最小值。 如果左上和右下，要么都是最小值，要么都是最大值，不适合通过比较缩小搜索范围。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        return false;
    }
}
