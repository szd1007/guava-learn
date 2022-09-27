package leet.old;

import leet.ICodePoints;

/**
 * 快排
 * onlogN
 */
public class _1_QuickSort {

    @ICodePoints("//todo 快速排序")
    public static void quickSort(int num[], int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j= end;
        int tmp = num[i];
        while (i<j) {
            while (i<j &&  num[j]>tmp)j--;
            num[i]=num[j];
            while (i<j &&  num[i]<tmp)i++;
            num[j]=num[i];
        }
        num[i]=tmp;
        quickSort(num, start,i-1);
        quickSort(num, i+1, end);
    }

    public static void main(String[] args) {
        int a[]=new int[]{3,1,5,2,4};
        quickSort(a, 0, a.length-1);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
