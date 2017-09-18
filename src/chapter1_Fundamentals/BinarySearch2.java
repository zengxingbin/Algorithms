package chapter1_Fundamentals;

public class BinarySearch2 {
    public int rank(int key,int[] whileList,int low,int high) {
        if(low > high)
            return -1;
        int mid = (low + high) / 2;
        if(key < whileList[mid])
            return rank(key,whileList,low,mid - 1);
        if(key > whileList[mid])
            return rank(key,whileList,mid + 1,high);
        else
            return mid;
    }
}
