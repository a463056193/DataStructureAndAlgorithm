package pers.leo.sort;

import java.util.Arrays;

/**
 * @author leo
 * @create 2021-01-07-0:44
 */
public class HeapSort {

    /*
        时间复杂度：
        平均时间O(nlogn)
        最差情形O(nlogn)
        不稳定排序
        额外空间O(1)

        将待排序数组构造为大顶堆，则数组中最大值为根节点
        根节点与末尾元素交换，此时末尾成为最大值
        然后将剩余元素重新构造为大根堆，重复执行，得到有序数组
        (升序大根堆，降序小根堆)
     */

    public static void main(String[] args) {

        //初始化数组
        int[] arr = {5, 11, -3, 13, 17};

        //测试堆排序
        heapSort(arr);

        //打印数组
        System.out.println(Arrays.toString(arr));

    }

    private static void heapSort(int[] arr) {

        int temp = 0;

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

    }

    private static void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        arr[i] = temp;

    }

}
