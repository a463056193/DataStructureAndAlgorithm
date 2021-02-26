package pers.leo.sort;

import java.util.Arrays;

/**
 * @author leo
 * @create 2021-01-06-10:15
 */
public class ShellSort {

    /*
        时间复杂度：
        平均时间O(nlogn)
        最差情形O(n^s) 1 < s < 2
        不稳定排序
        额外空间O(1)

        按下标的一定增量分组，对分组使用插入排序算法排序，当增量减至1时，排序完成
        相比于直接对整个数组使用插入排序，减少了数组元素后移次数
     */

    public static void main(String[] args) {

        //初始化数组
        int[] arr = {5, 11, -3, 13, 17};

        //测试希尔排序
        shellSort2(arr);

        //打印数组
        System.out.println(Arrays.toString(arr));

    }

    private static void shellSort1(int[] arr) {

        int temp = 0;

        //缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //分成几组，对各组进行遍历
            for (int i = gap; i < arr.length; i++) {
                //遍历组内元素，步长为gap
                for (int j = i - gap; j >= 0; j -= gap) {

                    //如果组内当前元素小于下一个元素，则交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }

    }

    //因为对分组排序时交换消耗资源，将交换改成移动(参照插入排序)
    private static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];

                //当组内当前元素小于下一个元素，后移
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;

            }
        }
    }

}
