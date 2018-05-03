package chapter2_sorting;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * @author ���ұ�(bingoo)
 * email:2045620125@qq.com
 * 2018��5��3�� ����10:38:53
 *��������ĸ���ʵ��
 */
public class Quick {
    
    /**�����ṩ�Ŀ��������㷨�����
     * ����һ�����飬�ÿ��������㷨�����������Ԫ�ؽ�������
     * @param a
     */
    public static void sort(Comparable<Object>[] a) {
        StdRandom.shuffle(a);//����֮ǰ���Ƚ������е�Ԫ�ش��ң����������������
        sort(a,0,a.length - 1 );//��������п�����������
    }
    /**
     * ˽�еĿ��������㷨
     * @param a
     * @param lo
     * @param high
     */
    private static void sort(Comparable<Object>[] a,int lo,int high) {
        //�Ƚ�����lo��high֮��Ĵ�С
        if(lo >= high)
            return;
        //�����зֵ������
        int j = partition(a,lo,high);
        //�ٶ��������벿�ֽ��п�������
        sort(a,lo,j - 1);
        //�ٶ�������Ұ벿�ֽ��п�������
        sort(a,j + 1,high);
    }
    private static int partition(Comparable<Object>[] a, int lo, int high) {
        //��������ɨ�������
        int i = lo,j = high + 1;
        //�����еĵ�һ��Ԫ����Ϊ�з�Ԫ��
        Comparable<Object> v = a[lo];
        //�������������м�ѭ��ɨ�裬����߱�v���Ԫ���Ƶ�Ԫ��v���ұߣ����ұ߱�vС��Ԫ���Ƶ�v�����
        while(true) {
            //�����Ѱ�ұ�v���Ԫ��
            while(less(a[++i],v))
                if(i == high)
                    break;
            //���ұ�Ѱ�ұ�vС��Ԫ��
            while(less(v,a[--j]))
                if(j == lo)
                    break;
            if(i >= j)//��������
                break;
            //����߱�v���Ԫ�غ��ұ߱�vС��Ԫ�ؽ��н���
                exch(a,i,j);
        }
        //��a[lo]��a[j]������ʹ�з�Ԫ�ش�����ȷ��λ�ã���֤�з�Ԫ����ߵ�Ԫ�ض����з�Ԫ��С���ұߵ�Ԫ�ض����з�Ԫ�ش�
        exch(a,lo,j);
        return j;//���ؽ������з�Ԫ������λ�õ�����
    }
    /**
     * ���������е�����Ԫ��
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable<Object>[] a, int i, int j) {
        Comparable<Object> temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }   
    /**
     * �Ƚ�����Ԫ�صĴ�С
     * @param v1
     * @param v2
     * @return
     */
    private static boolean less(Comparable<Object> v1, Comparable<Object> v2) {
        return v1.compareTo(v2) < 0;
    }
    
}
