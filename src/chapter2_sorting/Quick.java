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
        sort(a,0,a.length - 1);//��������п�����������
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
    /**
     * ���������㷨�ĸĽ������ڶ���С������˵����������Ȳ�������������˿��ԶԿ���������ͨ���з��������Ľ�С�����������
     * �������򣬶�����ʹ�ÿ�����������Ĳ���M����ָ��������ĳ���ΪM��һ����5~15֮���ֵ��ʱ�����ò�������
     * @param a
     * @param lo
     * @param high
     * @param M
     */
    public static void sort(Comparable<Object>[] a,int lo,int high,int M) {
        if(high <= lo + M) {
            System.out.println("Ԫ�ظ���С��" + M + "ʹ�ò�������");
            //���ò�������
            Insertion.sort(a, lo, high);
            //�ݹ����
            return;
        }
        //��ȡ�зֵ�����
        int j = partition(a, lo, high);
        //����벿��Ԫ�ؽ�������
        sort(a,lo,j - 1);
        //���Ұ벿��Ԫ�ؽ�������
        sort(a,j + 1,high);
    }
    /**
     * �������еĵ�һ��Ԫ����Ϊ�зֵ㣬��������С�ڵ����зֵ�Ԫ���Ƶ��зֵ���ߣ����ڵ����зֵ��Ԫ���Ƶ��зֵ��ұ�
     * �Ӷ���֤�зֵ���ߵ�Ԫ�ض��������зֵ㣬�ұߵ�Ԫ�ز�С���зֵ�
     * @param a
     * @param lo
     * @param high
     * @return
     */
    private static int partition(Comparable<Object>[] a, int lo, int high) {
        //��������ɨ�������
        int i = lo,j = high + 1;
        //�����еĵ�һ��Ԫ����Ϊ�з�Ԫ��
        Comparable<Object> v = a[lo];
        //�������������м�ѭ��ɨ�裬����߱ȴ��ڵ���v��Ԫ���Ƶ�Ԫ��v���ұߣ����ұ�С�ڵ���v��Ԫ���Ƶ�v�����
        while(true) {
            //�����Ѱ�Ҵ��ڵ��ڵ�Ԫ��
            while(less(a[++i],v))
                if(i == high)
                    break;
            //���ұ�Ѱ��С�ڵ���v��Ԫ��
            while(less(v,a[--j]))
                if(j == lo)//�������������ʵ����ʡ�ԣ���Ϊ��ѡ�������еĵ�һ��Ԫ����Ϊ�зֵ㣬��������ɨ��ָ���ܹ�ɨ�赽��һ��Ԫ�أ���ôѭ������less(v,a[--j])Ϊfalse����Ϊ��ʱv==a[--j]����ѭ������
                    break;
            if(i >= j)//��������
                break;
            //����ߴ��ڵ���v��Ԫ�غ��ұ�С�ڵ���v��Ԫ�ؽ��н���
                exch(a,i,j);
        }
        //��a[lo]��a[j]������ʹ�з�Ԫ�ش�����ȷ��λ�ã���֤�з�Ԫ����ߵ�Ԫ�ز������зֵ㣬�ұߵ�Ԫ�ز�С���зֵ�
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
