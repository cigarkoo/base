package com.chm.base.structure;

import java.util.Arrays;

/**
 * @author chenhuimin
 * @date 2023-07-11 17:44
 * @desc AllSort
 */

public class AllSort {

    //直接插入排序
    public static void straightInsertionSort(int[] a){
        //注意：i从1开始而不是0是因为第一个肯定是有序的，所以从第二个开始比较即a[1]
        for(int i=1;i<a.length;i++){
            //temp是待排序的值，moveIndex是有序值的最大下标
            //注意：因为数组里的值是变化的【a[j+1] = a[j]】，用下标i访问会访问不到正确的值，所以必须要temp存储
            int temp = a[i],moveIndex=i-1;
            //temp和前面的有序值比较，从队尾开始比较。temp在比较的过程中不加入数组
            for(int j=i-1; j>=0 && temp<a[j]; j--){
                //如果temp<前一个值，那么前一个值后移（可移动的位置最大到temp所在的下标）
                a[j+1] = a[j];
                //moveIndex记录移出去的下标（此时下标的值还是原来的值）
                moveIndex = j;
            }
            //当temp结束比较，moveIndex表示temp应该插入的下标
            //如果moveIndex不是temp原始的下标，那么就插入
            if(moveIndex != i){
                a[moveIndex]  = temp;
            }
        }
    }
    //简单选择排序
    public static void sampleSelectSort(int[] a){
        for(int i=0;i<a.length-1;i++){
            int min = a[i],minIndex=i;
            for(int j=i+1;j<a.length;j++){
                if(min>a[j]){
                    min = a[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                a[minIndex] = a[i];
                a[i] = min;
            }
        }
    }

    //交换排序，冒泡排序
    public static void bubbleSort(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    System.out.println("后：" + Arrays.toString(a));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{88, 44, 38, 5, 47, 15, 36, 26 };
        System.out.println("原始：" + Arrays.toString(a));
        bubbleSort(a);
        System.out.println("后：" + Arrays.toString(a));
    }
}
