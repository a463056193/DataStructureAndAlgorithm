package pers.leo.sort;


import java.util.Arrays;

/**
 * @author leo
 * @create 2021-01-05-23:19
 */
public class BubbleSort {

    /*
        时间复杂度：
        平均时间O(n^2)
        最差情形O(n^2)
        稳定排序
        额外空间O(1)

        每轮排序将一个元素冒泡至顶部，当进行arr.length - 1次，数组有序
     */

    public static void main(String[] args) {
        //初始化数组
        int[] arr = {5, 11, -3, 13, 17};

        //测试冒泡排序
        bubbleSort(arr);

        //打印数组
        System.out.println(Arrays.toString(arr));

    }

    private static void bubbleSort(int[] arr){

        int temp = 0;   //定义临时变量用于交换元素
        boolean flag = false;   //标识变量，若一次循环中没有发生交换，则代表已经有序

        for (int i = 0; i < arr.length - 1; i++){

            for (int j = 0; j < arr.length - 1 - i; j++){
                //从小到大，若前面的数比后面的大，则交换
                if (arr[j] > arr[j + 1]){
                    flag = true;    //发生交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (!flag) { //没有发生交换
                break;
            } else {
                flag = false;   //重置标识
            }

        }


    }

}
