package chapter2_sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author ���ұ�(bingoo)
 * email:2045620125@qq.com
 * 2017��10��26�� ����10:48:59
 *�ڹ鲢�����У�ʹ���˵ݹ�ķ�ʽ�����ǵݹ��ʹС��ģ����ķ������ȹ���Ƶ�����ͻή���㷨������
 *���Կ��Զ�С��ģ����ʹ�ò�ͬ�������㷨�����磬�Գ���С��15��������в������򣬶���ʹ�õݹ�ķ�ʽ
 */
public class MergeWithInsert {
    //��������
    private static Comparable[] aux;
    
    public static void merge(Comparable[] a,int low,int mid,int high) {
        int i = low;
        int j = mid + 1;
        //������a�����ݱ��ݵ�aux
        for(int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        //����merge
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
        //��������������㹻�Ĵ洢�ռ�
        aux = new Comparable[a.length];
        //����ʵ�ʵ�����
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a, int low, int high) {
        //ԭ���ݹ����������
        /*if(low >= high) {
            return;
        }*/
        if(high -low + 1 <= 15) {
            //�������ģС��15ʱ��ʹ�ò�������,����ʹ�ù鲢����
            insert(a,low,high);
            
        }else {
            //����ʹ�õݹ�
            int mid = (low + high) / 2;
            //��������벿�ֵݹ�����
            sort(a,low,mid);
            //�Ұ벿�ֵݹ�����
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
     * �Զ��ж������������ǽ���
     * ͨ��Ѱ�������е�һ�鲻��ȵ������ж��������ǽ���
     * @param a
     */
    public static boolean isSorted(Comparable[] a) {
        boolean flag = true;//true ����������false�����ǽ���,Ĭ������
        int count = 0;
        boolean isFirst = false;//�Ƿ����Ѿ����ֵ�һ�鲻��ȵ���
        //
        for(int i = 0; i < a.length - 1; i++) {
            if(a[i].compareTo(a[i+1]) == 0) {
                continue;
            }
            if(!isFirst) {
                //�ж������ǽ���
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
     * �Զ��ж������ǽ���ĵ�2�ַ�ʽ
     * ����Ҫô������Ҫô�ǽ���
     * �ֱ�������ͽ���ĳ�����м�⣬���������һ������������һ��
     * @param args
     */
    public static boolean isSorted2(Comparable[] a) {
        boolean asc = true;
        boolean desc = true;
        //����������
        for(int i = 0; i < a.length - 1; i++) {
            if(a[i].compareTo(a[i+1]) > 0) {
                asc = false;//����
                break;
            }
        }
        //�����ǽ���
        for(int i = 0; i < a.length - 1; i++) {
            if(a[i].compareTo(a[i+1]) < 0) {
                desc = false;//����
                break;
            }
        }
        return asc || desc;//Ҫô����Ҫô����Ҫô����
    }
    public static void main(String[] args) {
        Integer[] array = new Integer[] {7,3,2,4,6,8,9,5,0,10,1,17,16,15,30,25};
        sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(isSorted(array));
        System.out.println(isSorted2(array));
    }
}
