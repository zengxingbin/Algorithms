package chapter2_sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 
 * @author ���ұ�(bingoo)
 * email:2045620125@qq.com
 * 2017��10��22�� ����10:54:56
 *ϣ��������С�������򣬶�Ҫ��������ݽ��з��飬�����ڽ���ֱ�Ӳ�������ʹ���鲿�����򣩣��������ݽ�������Ϊ1
 *��ֱ�Ӳ�������
 */
public class Shell {
    public static void sort(Comparable[] a) {
        // ʹ��N��¼����ĳ���
        int N = a.length;
        // ���ڲ�����������
        int h = 1;
        // ������������
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        // �������ϣ������
        // ��һ��ѭ��������С����
        for (int i = h; i >= 1; i /= 3) {
            // �ڶ���ѭ����������
            for (int j = i; j < a.length; j++) {
                if (a[j - i].compareTo(a[j]) > 0) {
                    // ʹ��һ����ʱ��������¼Ҫ���뵽������е�Ԫ�أ���ֹ���ƶ�Ԫ�صĹ����б�����
                    Comparable temp = a[j];
                    // ������ѭ�������������ڽ���ֱ�Ӳ�������
                    int x;
                    for(x = j-i; x >=0 && a[x].compareTo(temp) > 0; x -= i) {
                        //��temp���Ԫ�ض������ƶ�
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
