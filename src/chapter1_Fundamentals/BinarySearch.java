package chapter1_Fundamentals;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
	public static void main(String[] args) {
		String fileName = null;
		if(args.length == 0)
			fileName = "E:\\MyStudyFile\\java\\java_jar\\Algorithm\\algs4-data\\largeW.txt";
		else
			fileName=args[0];
		//读取文件获得一个整型数组
		int[] whiteList = In.readInts(fileName);
		//对数组进行排序
		Arrays.sort(whiteList);
		//排序后打印一下数组
		/*for(int i : whiteList) 
			StdOut.print(i + " ");*/
		//换行
		StdOut.println();
		//从键盘获取输入，将不在文件列表中的数字打印出来
		while(!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			//在表中进行查找，如果没找到，打印出关键字
			if(rank(key,whiteList) < 0) 
				StdOut.println(key + " doesn't exists in file");
			else
				StdOut.println(key + " exists in file");
		}
	}

	private static int rank(int key, int[] whiteList) {
		int low = 0;
		int height = whiteList.length - 1;
		while(low <= height) {
			int mid = (low + height) / 2;
			//如果小于中间值，在低半区进行查找
			if(key < whiteList[mid]) 
				height = mid - 1;
			//如果大于中间值，在高半区进行查找
			else if(key > whiteList[mid])
				low = mid + 1;
			//找到返回关键字在列表中的索引
			else
				return mid;
		}
		//没找到，返回负一
		return -1;
	}
	
}
