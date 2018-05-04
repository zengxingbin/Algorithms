package chapter2_sorting;

public class Insertion {
    /**
     * 对整个数组进行排序
     * @param a
     */
    public static void sort(Comparable<Object>[] a) {
        //第一个元素默认有序，因此从第二个元素开始，将后面的元素逐个插入到前面的有序队列里
        for(int i = 1; i < a.length; i++) {
            //记录当前要插入的元素，防止在元素的移动过程中被覆盖
            Comparable<Object> insertEle = a[i];
            int j;
            for(j = i - 1; j >= 0; j--) {
                if(less(insertEle,a[j]))
                    a[j+1] = a[j];
                else
                    break;//寻找到插入点,结束循环
            }
            a[j+1] = insertEle;//由于a[j] <= insertEle，故insertEle应该插入到a[j+1]的位置
        }
    }
    /**
     * 对数组中的特定部分进行插入排序，其中start为起始索引，end为结束索引
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
     * 交换数组中的两个元素
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
     * 比较两个元素的大小
     * @param v1
     * @param v2
     * @return
     */
    private static boolean less(Comparable<Object> v1, Comparable<Object> v2) {
        return v1.compareTo(v2) < 0;
    }
}
