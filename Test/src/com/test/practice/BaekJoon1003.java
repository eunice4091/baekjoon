package com.test.practice;

import java.util.Scanner;

public class BaekJoon1003 {
	static int[][] results;
	
	public static void main(String[] str) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		results = new int[41][2];
		int[] inputs = new int[T];
		int j=0;
		while(j<41) {
			fibonacci(j);
			j++;
		}
		for (int i = 0; i < T; i++) {
			inputs[i] = sc.nextInt();
		}

		for(int i=0; i<T; i++) {
			System.out.println(results[inputs[i]][0] + " " + results[inputs[i]][1]);
		}
	}
	
	public static void fibonacci(int n) {
		if(n == 0) {
			results[n][0] = 1;
		} else if (n==1) {
			results[n][1] = 1;
		} else {
			results[n][0] = results[n-1][0] + results[n-2][0];
			results[n][1] = results[n-1][1] + results[n-2][1];
		}
	}
	
	// 재귀로하면 시간초과
//	public static void main(String[] str) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		int[] n = new int[T];
//		for (int i = 0; i < T; i++) {
//			n[i] = sc.nextInt();
//		}
//
//		for (int i = 0; i < T; i++) {
//			call0Count = 0;
//			call1Count = 0;
//			fibonacci(n[i]);
//			System.out.println(call0Count + " " + call1Count);
//		}
//		sc.close();
//	}
//
//	public static int fibonacci(int n) {
//		if (n == 0) {
//			call0Count++;
//			return n;
//		} else if (n == 1) {
//			call1Count++;
//			return n;
//		} else {
//			return fibonacci(n - 1) + fibonacci(n - 2);
//		}
//	}
}
