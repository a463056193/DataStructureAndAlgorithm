package pers.leo.sort;

import java.util.Arrays;

/**
 * @author leo
 * @create 2021-01-06-10:55
 */
public class QuickSort {

    /*
        时间复杂度：
        平均时间O(nlogn)
        最差情形O(n^2)
        不稳定排序
        额外空间O(nlogn)

        通过一趟排序将待排序数组分割成两个独立的部分，其中一部分的所有数据比另一部分的所有数据小
        递归进行，达到有序
     */

    public static void main(String[] args) {

        //初始化数组
        int[] arr = {5, 11, -3, 13, 17};

        //测试快速排序
        quickSort(arr, 0, arr.length - 1);

        //打印数组
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int left, int right) {

        //扫描过了整个数组
        if (left >= right) return;

        //这样定义方便实现
        int l = left - 1;
        int r = right + 1;
        int pivot = arr[(left + right) / 2];
        int temp = 0;

        while (l < r) {
            do l++; while (arr[l] < pivot);
            do r--; while (arr[r] > pivot);
            if (l < r) {
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        quickSort(arr, left, r);
        quickSort(arr, r + 1, right);
    }

}
