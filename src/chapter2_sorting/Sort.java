package chapter2_sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author 曾幸彬(bingoo)
 * email:2045620125@qq.com
 * 2017年10月12日 下午11:54:33
 *This is a sort object which contains all kinds of sort alogorithms
 */
public class Sort {
    /**
     * bubble sort
     * 总共进行n-1趟排序
     * 每一趟排序都将最大的值往后面移动
     * @param a
     */
    public static void bubbleSort(Comparable[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 0; j < a.length - i - 1;j++) {
                if(a[j].compareTo(a[j + 1]) > 0) {
                    swap(a,j,j+1);
                }
            }
        }
        //或者
        /*for(int i = 1; i < a.length; i++) {
            for(int j = 0; j < a.length - i;j++) {
                if(a[j].compareTo(a[j+1]) > 0) {
                    swap(a,j,j+1);
                }
            }
        }*/
    }
    /**
     * simple selection sort,every time finding the first min object
     * then the secod,and then the third etc...
     * @param a
     */
    public static void simpleSelectSort(Comparable[] a) {
        long start = System.currentTimeMillis();
        System.out.println("before sorting:" + Arrays.toString(a));
        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                if(a[i].compareTo(a[j]) > 0) {
                    //swap
                    swap(a,i,j);//frequently swap
                }
            }
        }
        System.out.println("after sorting:" + Arrays.toString(a));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    public static void improveSimpleSelectSort(Comparable[] a) {
        long start = System.currentTimeMillis();
        System.out.println("before sorting:" + Arrays.toString(a));
        //do sort
        for(int i = 0; i < a.length; i++) {
            int min = i;//define a variable to record the min object's index
            for(int j = i+1; j < a.length; j++) {
                if(a[min].compareTo(a[j]) > 0) {
                    min = j;//every time recording the min object's index to avoid swap two object frequently
                }
                
            }
            //do swap
            swap(a,i,min);//only swap once time
        }
        System.out.println("after sorting:" + Arrays.toString(a));
       long end = System.currentTimeMillis();
       System.out.println(end - start);
    }
    /**
     * direct insertion sort
     *寻找插入位置的时候，相当于使用了直接查找的方法
     * @param a
     */
    public static void directInsertSort(Comparable[] a) {
        for(int i = 1; i < a.length; i++) {
            int j;
            Comparable temp = a[i];//record the value of a[i]
            for(j = i - 1; j >= 0 && a[j].compareTo(temp) > 0; j--) {
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
    }
    /**
     * binary insertion sort
     * 寻找插入位置的时候使用了折半查找的方法
     *解析：在使用折半查找的过程中，如果前面的有序序列中存在要查找的数据，则继续查找（向低半区或者高半区差早都可以）
     *那么最终循环结束的时候，肯定满足条件low > high,其中经过了low=high
     *此时存在三种情况，即在最后一次循环
     *1.key = a[mid]:可当作以下情况2或者情况3
     *2.key < a[mid]:low=high=mid，此时在低半区查找，所以high=mid-1，导致了，high<low退出循环,此时应该将a[high+1],也就是a[low]以后元素，向后移动
     *3.key > a[mid]：low=high=mid,此时在高半区查找，所以low = mid+1,导致了low>high退出循环,此时应该将a[low],也就是a[hight+1]以后的元素往后移动
     *综上所述，最后插入的位置为索引为low或者high+1的位置，因为low=high+1
     * @param a
     */
    public static void binaryInsertSort(Comparable[] a) {
        for(int j = 1; j < a.length; j++) {
            int low = 0;
            int high = j - 1;
            while(low >= high) {
                int mid = (low + high) / 2;
                if(a[j].compareTo(a[mid]) < 0) {
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
            Comparable temp = a[j];
            for(int i = j-1; i >= high + 1;i--) {
                a[i+1] = a[i];
            }
            a[high+1] = temp;
            //或者
            /*for(int i = j - 1; i >= low; i--) {
                a[i+1] = a[i];
            }
            a[low] = temp;*/
        }
    }
    /**
     * shell sort
     * 缩小增量排序，直到增量为1的时候
     * 进行了分组，组内进行直接插入排序
     */
    public static void shellSort(Comparable[] a) {
        for(int mid = a.length/2; mid >= 1; mid /=2) {//缩小增量
            for(int i = mid; i < a.length; i++) {//分组，组内进行直接插入排序
                if(a[i-mid].compareTo(a[i]) > 0) {
                    Comparable temp = a[i];
                    int j;
                    for(j = i-mid;j >= 0 && a[j].compareTo(temp) > 0;j -= mid) {
                        a[j+mid] = a[j];
                    }
                    a[j+mid] = temp;
                }
            }
        }
    } 
    /**
     * swap value of two object
     * @param a
     * @param i
     * @param j
     */
    public static void swap(Comparable[] a,int i,int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        //test
        Comparable[] a = new Integer[10000];
        Random rand = new Random();
        for(int i = 0; i < 10000; i++) {
            a[i] = rand.nextInt(10000);
        }
        Comparable[] b = a;
        improveSimpleSelectSort(a);
        System.out.println("------------------------");
        simpleSelectSort(b);
    }
}
