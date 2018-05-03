package chapter2_sorting;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * @author 曾幸彬(bingoo)
 * email:2045620125@qq.com
 * 2018年5月3日 下午10:38:53
 *快速排序的各种实现
 */
public class Quick {
    
    /**对外提供的快速排序算法的入口
     * 接收一个数组，用快速排序算法对数组里面的元素进行排序
     * @param a
     */
    public static void sort(Comparable<Object>[] a) {
        StdRandom.shuffle(a);//排序之前，先将数组中的元素打乱，消除对输入的依赖
        sort(a,0,a.length - 1 );//对数组进行快速排序排序
    }
    /**
     * 私有的快速排序算法
     * @param a
     * @param lo
     * @param high
     */
    private static void sort(Comparable<Object>[] a,int lo,int high) {
        //比较索引lo和high之间的大小
        if(lo >= high)
            return;
        //计算切分点的索引
        int j = partition(a,lo,high);
        //再对数组的左半部分进行快速排序
        sort(a,lo,j - 1);
        //再对数组的右半部分进行快速排序
        sort(a,j + 1,high);
    }
    private static int partition(Comparable<Object>[] a, int lo, int high) {
        //创建左右扫描的索引
        int i = lo,j = high + 1;
        //数组中的第一个元素作为切分元素
        Comparable<Object> v = a[lo];
        //从左右两边向中间循环扫描，将左边比v大的元素移到元素v的右边，将右边比v小的元素移到v的左边
        while(true) {
            //在左边寻找比v大的元素
            while(less(a[++i],v))
                if(i == high)
                    break;
            //在右边寻找比v小的元素
            while(less(v,a[--j]))
                if(j == lo)
                    break;
            if(i >= j)//交换结束
                break;
            //将左边比v大的元素和右边比v小的元素进行交换
                exch(a,i,j);
        }
        //将a[lo]和a[j]交换，使切分元素处于正确的位置，保证切分元素左边的元素都比切分元素小，右边的元素都比切分元素大
        exch(a,lo,j);
        return j;//返回交换后切分元素所处位置的索引
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
