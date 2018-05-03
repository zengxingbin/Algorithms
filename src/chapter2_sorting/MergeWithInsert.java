package chapter2_sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author 曾幸彬(bingoo)
 * email:2045620125@qq.com
 * 2017年10月26日 下午10:48:59
 *在归并排序中，使用了递归的方式，但是递归会使小规模问题的方法调度过于频繁，就会降低算法的性能
 *所以可以对小规模问题使用不同的排序算法，比如，对长度小于15的数组进行插入排序，而不使用递归的方式
 */
public class MergeWithInsert {
    //辅助数组
    private static Comparable[] aux;
    
    public static void merge(Comparable[] a,int low,int mid,int high) {
        int i = low;
        int j = mid + 1;
        //将数组a的内容备份到aux
        for(int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        //进行merge
        for(int k = 0; k <= high; k++) {
            if(i > mid) {
                a[k] = aux[j++];
            }else if(j > high) {
                a[k] = aux[i++];
            }else if(aux[i].compareTo(aux[j]) >= 0) {
                a[k] = aux[j++];
            }else {
                a[k] = aux[i++];
            }
        }
    }
    public static void sort(Comparable[] a) {
        //给辅助数组分配足够的存储空间
        aux = new Comparable[a.length];
        //进行实际的排序
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a, int low, int high) {
        //原来递归结束的条件
        /*if(low >= high) {
            return;
        }*/
        if(high -low + 1 <= 15) {
            //当问题规模小于15时，使用插入排序,而不使用归并排序
            insert(a,low,high);
            
        }else {
            //否则使用递归
            int mid = (low + high) / 2;
            //给数组左半部分递归排序
            sort(a,low,mid);
            //右半部分递归排序
            sort(a,mid+1,high);
            //merge
            merge(a,low,mid,high);
        }
        
    }
    private static void insert(Comparable[] a, int low, int high) {
        for(int i = low + 1; i <= high; i++) {
            if(a[i - 1].compareTo(a[i]) > 0) {
                Comparable temp = a[i];
                int j;
                for(j = i - 1; j >= 0 && a[j].compareTo(temp)>0; j--) {
                    a[j+1] = a[j];
                }
                a[j+1] = temp;
            }
        }
    }
    /**
     * 自动判定数组是升序还是降序
     * 通过寻找数组中第一组不想等的数来判断是升序还是降序
     * @param a
     */
    public static boolean isSorted(Comparable[] a) {
        boolean flag = true;//true 代表是升序，false代表是降序,默认升序
        int count = 0;
        boolean isFirst = false;//是否是已经发现第一组不相等的数
        //
        for(int i = 0; i < a.length - 1; i++) {
            if(a[i].compareTo(a[i+1]) == 0) {
                continue;
            }
            if(!isFirst) {
                //判断升序还是降序
                if(a[i].compareTo(a[i+1]) < 0) {
                    flag = true;
                }else {
                    flag = false;
                }
                isFirst = true; 
                continue;
            }else {
                if(flag) {
                    if(a[i].compareTo(a[i+1]) > 0) {
                        return false;
                    }
                }else {
                    if(a[i].compareTo(a[i+1]) < 0) {
                        return false;
                    }
                }
            }
            
        }
        return true;
    }
    /**
     * 自动判断升序还是降序的第2种方式
     * 数组要么是升序，要么是降序
     * 分别用升序和降序的程序进行检测，如果是有序，一定会满足其中一个
     * @param args
     */
    public static boolean isSorted2(Comparable[] a) {
        boolean asc = true;
        boolean desc = true;
        //假设是升序
        for(int i = 0; i < a.length - 1; i++) {
            if(a[i].compareTo(a[i+1]) > 0) {
                asc = false;//无序
                break;
            }
        }
        //假设是降序
        for(int i = 0; i < a.length - 1; i++) {
            if(a[i].compareTo(a[i+1]) < 0) {
                desc = false;//无序
                break;
            }
        }
        return asc || desc;//要么升序，要么降序，要么无序
    }
    public static void main(String[] args) {
        Integer[] array = new Integer[] {7,3,2,4,6,8,9,5,0,10,1,17,16,15,30,25};
        sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(isSorted(array));
        System.out.println(isSorted2(array));
    }
}
