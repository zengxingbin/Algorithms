package chapter2_sorting;

import java.util.Arrays;

/**
 * 
 * @author 曾幸彬(bingoo)
 * email:2045620125@qq.com
 * 2017年10月22日 下午11:45:36
 *归并排序
 *思想：将两个有序的子序列合并成大的有序序列
 */
public class MergeAfterJudgeMid {
    //归并用的辅助数组
    private static Comparable[] aux;
    /**
     * 
     * @param a
     * @param low
     * @param high
     * 将大的数组中的左右两部分有序子数组合并的算法
     */
    public static void merge(Comparable[] a,int low,int mid,int high) {
        int i = low;
        int j = mid + 1;
        //将数组a中的所有元素复制到辅助数组中去
        for(int k = low; k<= high; k++) {
            aux[k] = a[k];
        }
        //进行归并
        for(int k = low; k <= high; k++) {
            if(i > mid) {
                a[k] = aux[j++];
            }else if(j > high) {
                a[k] = aux[i++];
            }else if(aux[i].compareTo(aux[j]) > 0) {
                a[k] = aux[j++];
            }else {
                a[k] = aux[i++];
            }
            
        }
    }
    /**
     * 
     * @param a
     * 对数组a进行归并排序
     */
    public static void sort(Comparable[] a) {
        //为辅助数组分配足够的存储空间
        aux = new Comparable[a.length];
        //进行归并
        sort(a,0,a.length-1);
    }
    /**
     * 
     * @param a
     * @param i
     * @param j
     * 重载方法
     */
    private static void sort(Comparable[] a, int low, int high) {
        //当low>high结束递归
        if(low >= high) {
            return;
        }
        int mid = (low+high) / 2;
        //对左半部分进行归并排序
        sort(a,low,mid);
        //对右半部分进行递归排序
        sort(a,mid+1,high);
        //合并前，先判断a[mid]和a[mid+1]的大小，如果a[mid] < a[mid+1],则数组已经有序了，不必再进行归并了，跳过merge方法
        //这样可以使任意有序子数组的运算时间变为线性的
        if(a[mid].compareTo(a[mid+1]) <= 0) {
            return;
        }
        //合并左右两半部分有序数组
        merge(a,low,mid,high);
    }
    public static void main(String[] args) {
        Comparable[] a = new Comparable[] {10,39,4,8,19,20,38,2,3,7,10,34,21,12,9,7,81,25,64};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
