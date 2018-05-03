package chapter2_sorting;

import java.util.Arrays;

/**
 * 
 * @author 曾幸彬(bingoo) email:2045620125@qq.com 2017年11月5日 下午10:22:03 自底向上的归并排序
 *         将整个大的数组中的每一个元素看作是一个子数组，然后进行两两归并，然后在进行四四归并，如此类推，不超过数组的长度
 */
public class Merge2 {
    // 辅助数组
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        // 为辅助数组分配空间
        aux = new Comparable[a.length];
        // 进行归并排序,先进行两两归并，在进行四四归并如此类推，不超过数组长度
        for(int i = 1; i < a.length; i *=2 ) {
            for(int j = 0; j < a.length - i; j += 2 * i) {
                merge(a,j,j+i-1,Math.min(j+2*i-1, a.length-1));
            }
        }

    }
    public static void sort2(Comparable[] a) {
        aux = new Comparable[a.length];
        int low;
        int mid;
        int high;
        for(int i = 1; i < a.length; i *= 2) {
            for(int j = 0; j < a.length; j += 2 * i) {
                low = j;
                high = Math.min(j + 2*i - 1,a.length - 1);
                mid = (low+high)/2;
/*                if(a[mid].compareTo(a[mid+1]) <= 0) 
                    continue;*/
                merge(a,low,mid,high);
            }
        }
    }
    public static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        // 将数组a中的内容复制到辅助数组aux
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        // aux排序到a
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) <= 0) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = { 1, 3, 2, 2, 3, 5, 1, 7, 10, 3, 5, 19, 35, 24 };
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
