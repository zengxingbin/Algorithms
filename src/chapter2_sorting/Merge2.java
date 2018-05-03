package chapter2_sorting;

import java.util.Arrays;

/**
 * 
 * @author ���ұ�(bingoo) email:2045620125@qq.com 2017��11��5�� ����10:22:03 �Ե����ϵĹ鲢����
 *         ��������������е�ÿһ��Ԫ�ؿ�����һ�������飬Ȼ����������鲢��Ȼ���ڽ������Ĺ鲢��������ƣ�����������ĳ���
 */
public class Merge2 {
    // ��������
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        // Ϊ�����������ռ�
        aux = new Comparable[a.length];
        // ���й鲢����,�Ƚ��������鲢���ڽ������Ĺ鲢������ƣ����������鳤��
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
        // ������a�е����ݸ��Ƶ���������aux
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        // aux����a
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
