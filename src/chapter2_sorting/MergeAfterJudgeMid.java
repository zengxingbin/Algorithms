package chapter2_sorting;

import java.util.Arrays;

/**
 * 
 * @author ���ұ�(bingoo)
 * email:2045620125@qq.com
 * 2017��10��22�� ����11:45:36
 *�鲢����
 *˼�룺����������������кϲ��ɴ����������
 */
public class MergeAfterJudgeMid {
    //�鲢�õĸ�������
    private static Comparable[] aux;
    /**
     * 
     * @param a
     * @param low
     * @param high
     * ����������е���������������������ϲ����㷨
     */
    public static void merge(Comparable[] a,int low,int mid,int high) {
        int i = low;
        int j = mid + 1;
        //������a�е�����Ԫ�ظ��Ƶ�����������ȥ
        for(int k = low; k<= high; k++) {
            aux[k] = a[k];
        }
        //���й鲢
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
     * ������a���й鲢����
     */
    public static void sort(Comparable[] a) {
        //Ϊ������������㹻�Ĵ洢�ռ�
        aux = new Comparable[a.length];
        //���й鲢
        sort(a,0,a.length-1);
    }
    /**
     * 
     * @param a
     * @param i
     * @param j
     * ���ط���
     */
    private static void sort(Comparable[] a, int low, int high) {
        //��low>high�����ݹ�
        if(low >= high) {
            return;
        }
        int mid = (low+high) / 2;
        //����벿�ֽ��й鲢����
        sort(a,low,mid);
        //���Ұ벿�ֽ��еݹ�����
        sort(a,mid+1,high);
        //�ϲ�ǰ�����ж�a[mid]��a[mid+1]�Ĵ�С�����a[mid] < a[mid+1],�������Ѿ������ˣ������ٽ��й鲢�ˣ�����merge����
        //��������ʹ�������������������ʱ���Ϊ���Ե�
        if(a[mid].compareTo(a[mid+1]) <= 0) {
            return;
        }
        //�ϲ��������벿����������
        merge(a,low,mid,high);
    }
    public static void main(String[] args) {
        Comparable[] a = new Comparable[] {10,39,4,8,19,20,38,2,3,7,10,34,21,12,9,7,81,25,64};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
