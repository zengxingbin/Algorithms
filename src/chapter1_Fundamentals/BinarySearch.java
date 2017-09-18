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
		//��ȡ�ļ����һ����������
		int[] whiteList = In.readInts(fileName);
		//�������������
		Arrays.sort(whiteList);
		//������ӡһ������
		/*for(int i : whiteList) 
			StdOut.print(i + " ");*/
		//����
		StdOut.println();
		//�Ӽ��̻�ȡ���룬�������ļ��б��е����ִ�ӡ����
		while(!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			//�ڱ��н��в��ң����û�ҵ�����ӡ���ؼ���
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
			//���С���м�ֵ���ڵͰ������в���
			if(key < whiteList[mid]) 
				height = mid - 1;
			//��������м�ֵ���ڸ߰������в���
			else if(key > whiteList[mid])
				low = mid + 1;
			//�ҵ����عؼ������б��е�����
			else
				return mid;
		}
		//û�ҵ������ظ�һ
		return -1;
	}
	
}
