package chapter2_sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author ���ұ�(bingoo)
 * email:2045620125@qq.com
 * 2017��10��12�� ����11:54:33
 *This is a sort object which contains all kinds of sort alogorithms
 */
public class Sort {
    /**
     * bubble sort
     * �ܹ�����n-1������
     * ÿһ�����򶼽�����ֵ�������ƶ�
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
        //����
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
     *Ѱ�Ҳ���λ�õ�ʱ���൱��ʹ����ֱ�Ӳ��ҵķ���
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
     * Ѱ�Ҳ���λ�õ�ʱ��ʹ�����۰���ҵķ���
     *��������ʹ���۰���ҵĹ����У����ǰ������������д���Ҫ���ҵ����ݣ���������ң���Ͱ������߸߰������綼���ԣ�
     *��ô����ѭ��������ʱ�򣬿϶���������low > high,���о�����low=high
     *��ʱ��������������������һ��ѭ��
     *1.key = a[mid]:�ɵ����������2�������3
     *2.key < a[mid]:low=high=mid����ʱ�ڵͰ������ң�����high=mid-1�������ˣ�high<low�˳�ѭ��,��ʱӦ�ý�a[high+1],Ҳ����a[low]�Ժ�Ԫ�أ�����ƶ�
     *3.key > a[mid]��low=high=mid,��ʱ�ڸ߰������ң�����low = mid+1,������low>high�˳�ѭ��,��ʱӦ�ý�a[low],Ҳ����a[hight+1]�Ժ��Ԫ�������ƶ�
     *�����������������λ��Ϊ����Ϊlow����high+1��λ�ã���Ϊlow=high+1
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
            //����
            /*for(int i = j - 1; i >= low; i--) {
                a[i+1] = a[i];
            }
            a[low] = temp;*/
        }
    }
    /**
     * shell sort
     * ��С��������ֱ������Ϊ1��ʱ��
     * �����˷��飬���ڽ���ֱ�Ӳ�������
     */
    public static void shellSort(Comparable[] a) {
        for(int mid = a.length/2; mid >= 1; mid /=2) {//��С����
            for(int i = mid; i < a.length; i++) {//���飬���ڽ���ֱ�Ӳ�������
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
