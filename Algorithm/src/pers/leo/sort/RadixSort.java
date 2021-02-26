package pers.leo.sort;

import java.util.Arrays;

/**
 * @author leo
 * @create 2021-01-06-0:19
 */
public class RadixSort {

    /*
        时间复杂度：
        平均时间O(logRB)
        最差情形O(logRB) B是真数(0-9) R是基数(个十百)
        稳定排序
        额外空间O(n)

        将数组元素按照个十百位分别排好序，最终得到有序数组
     */

    public static void main(String[] args) {

        //初始化数组
        //因为基数排序取模求每位的值，所以不支持负数
        int[] arr = {5, 11, 3, 13, 17};

        //测试基数排序
        radixSort(arr);

        //打印数组
        System.out.println(Arrays.toString(arr));


    }

    private static void radixSort(int[] arr) {

        //确认桶 二维数组的大小
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        //定义桶
        int[][] bucket = new int[10][arr.length];
        //记录桶中实际存放多少个数据
        int[] bucketElementCounts = new int[10];

        //对元素的每个对应位排序
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出元素对应位的值
                int digitOfElement = arr[j] / n % 10;
                //放入对应桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            //每个桶的索引
            int index = 0;

            //遍历每个桶，将桶中数据放入原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //放入原数组
                        arr[index++] = bucket[k][l];
                    }
                }
                //处理后置0
                bucketElementCounts[k] = 0;
            }
        }
    }

}
