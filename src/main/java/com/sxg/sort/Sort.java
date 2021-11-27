package com.sxg.sort;

/**
 * @author sxg
 * create in 2021/11/24
 */
public class Sort {


    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 6, 4, 8, 7, 1};
        insertSort(array);
        for (int a : array) {
            System.out.println(a);
        }

    }


    /**
     * 插入排序
     *
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 以i为中点，每次保证左边的数组顺序
            int value = array[i];
            int k = i; // 以k为游标，寻找合适的位置插入array[i]
            for (int j = i - 1; j >= 0; j--) {
                if (value < array[j]) {
                    array[k] = array[j];
                    k = j;
                } else {
                    break;// 如果i对应的元素就是最大的就不用比较，直接放在队列尾
                }
            }
            if (value != array[k]) {
                array[k] = value;
            }
        }
    }
}
