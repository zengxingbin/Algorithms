package chapter2_sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 
 * @author 曾幸彬(bingoo)
 * email:2045620125@qq.com
 * 2017年10月22日 下午10:54:56
 *希尔排序，缩小增量排序，对要排序的数据进行分组，在组内进行直接插入排序（使数组部分有序），最后对数据进行增量为1
 *的直接插入排序
 */
public class Shell {
    public static void sort(Comparable[] a) {
        // 使用N记录数组的长度
        int N = a.length;
        // 用于产生递增序列
        int h = 1;
        // 产生递增序列
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        // 下面进行希尔排序
        // 第一个循环用于缩小增量
        for (int i = h; i >= 1; i /= 3) {
            // 第二个循环用来分组
            for (int j = i; j < a.length; j++) {
                if (a[j - i].compareTo(a[j]) > 0) {
                    // 使用一个临时变量来记录要插入到有序队列的元素，防止在移动元素的过程中被覆盖
                    Comparable temp = a[j];
                    // 第三个循环用来进行组内进行直接插入排序
                    int x;
                    for(x = j-i; x >=0 && a[x].compareTo(temp) > 0; x -= i) {
                        //比temp大的元素都往后移动
                        a[x+i] = a[x];
                    }
                    a[x+i] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Integer[] a = new Integer[] {10,39,4,8,19,20,38,2,3,7,10,34,21,12,9,7,81,25,64};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
