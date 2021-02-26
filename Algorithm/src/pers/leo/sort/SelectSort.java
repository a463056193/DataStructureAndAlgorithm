package pers.leo.sort;

import java.util.Arrays;

/**
 * @author leo
 * @create 2021-01-05-23:37
 */
public class SelectSort {

    /*
        时间复杂度：
        平均时间O(n^2)
        最差情形O(n^2)
        不稳定排序
        额外空间O(1)

        每轮排序将一个元素交换至顶部，当进行arr.length次，数组有序
     */

    public static void main(String[] args) {

        //初始化数组
        int[] arr = {5, 11, -3, 13, 17};

        //测试选择排序
        selectSort(arr);

        //打印数组
        System.out.println(Arrays.toString(arr));


    }

    private static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length; i++){
            //假定最小值
            int minIndex = i;
            int min = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                //遍历后续元素，更新假定最小值
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            // 遍历完，得到最小值
            // 将最小值放在arr[0]
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }

    }


}
