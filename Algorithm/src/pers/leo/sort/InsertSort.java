package pers.leo.sort;

import java.util.Arrays;

/**
 * @author leo
 * @create 2021-01-05-23:54
 */
public class InsertSort {

    /*
        时间复杂度：
        平均时间O(n^2)
        最差情形O(n^2)
        稳定排序
        额外空间O(1)

        将n个待排序的元素分别看称谓一个有序表和一个无序表，每次从无序表中取出第一个元素
        将其插入有序表中适当位置
     */

    public static void main(String[] args) {

        //初始化数组
        int[] arr = {5, 11, -3, 13, 17};

        //测试插入排序
        insertSort(arr);

        //打印数组
        System.out.println(Arrays.toString(arr));

    }

    private static void insertSort(int[] arr) {

        int insertVal = 0;
        int insertIndex = 0;    //初始化插入位置索引

        for(int i = 1; i < arr.length; i++){

            //以第一个元素为有序，剩余元素为无序
            insertVal = arr[i];
            insertIndex = i - 1;

            //当还没遍历完有序数组且当前插入值(无序数组第一个元素)小于当前有序数组元素
            //将当前有序数组元素后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            //如果发生过后移，将插入值放入有序数组
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

        }

    }

}
