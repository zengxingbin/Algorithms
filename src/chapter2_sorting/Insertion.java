package chapter2_sorting;

public class Insertion {
    /**
     * �����������������
     * @param a
     */
    public static void sort(Comparable<Object>[] a) {
        //��һ��Ԫ��Ĭ��������˴ӵڶ���Ԫ�ؿ�ʼ���������Ԫ��������뵽ǰ������������
        for(int i = 1; i < a.length; i++) {
            //��¼��ǰҪ�����Ԫ�أ���ֹ��Ԫ�ص��ƶ������б�����
            Comparable<Object> insertEle = a[i];
            int j;
            for(j = i - 1; j >= 0; j--) {
                if(less(insertEle,a[j]))
                    a[j+1] = a[j];
                else
                    break;//Ѱ�ҵ������,����ѭ��
            }
            a[j+1] = insertEle;//����a[j] <= insertEle����insertEleӦ�ò��뵽a[j+1]��λ��
        }
    }
    /**
     * �������е��ض����ֽ��в�����������startΪ��ʼ������endΪ��������
     * @param a
     * @param start
     * @param end
     */
    public static void sort(Comparable<Object>[] a,int start,int end) {
        for(int i = start + 1; i <= end; i++) {
            Comparable<Object> insert = a[i];
            int j;
            for(j = i - 1; j >= start; j--) {
                if(less(insert,a[j]))
                    a[j+1] = a[j];
                else
                    break;
            }
            a[j+1] = insert;
        }
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
