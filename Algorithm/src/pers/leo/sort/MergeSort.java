package pers.leo.sort;

import java.util.Arrays;

/**
 * @author leo
 * @create 2021-01-06-23:30
 */
public class MergeSort {

    /*
        时间复杂度：
        平均时间O(nlogn)
        最差情形O(nlogn)
        稳定排序
        额外空间O(1)

        分治法，将待排序数组拆分成小数组，递归求解
     */

    public static void main(String[] args) {

        //初始化数组
        int[] arr = {5, 11, -3, 13, 17,17};
        //辅助数组
        int[] temp = new int[arr.length];

        //测试归并排序
        mergeSort(arr, 0, arr.length - 1, temp);

        //打印数组
        System.out.println(Arrays.toString(arr));

    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {

        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);

        int k = 0;
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (i = left, j = 0; i <= right; i++, j++) {
            arr[i] = temp[j];
        }

    }

}
