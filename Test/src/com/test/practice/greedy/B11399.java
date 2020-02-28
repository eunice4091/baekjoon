package com.test.practice.greedy;

import java.util.Scanner;

// ATM
// N = 1~1000
// 대기자 N명 각각 소요시간 t
// N번째 대기자의 소요시간은 t1 + t2 + ... + tn
// 가장 짧은 총 소요시간?
public class B11399 {

	public static void main(String[] str) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int time[] = new int[N];
		for (int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		}
		int sortedTime[] = sortArray(time);
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				result += sortedTime[j];
			}
		}
		System.out.print(result);

	}
	public static int[] sortArray(int[] time) {
		int len = time.length;
		for(int i=0; i<len; i++) {
			int maxIndex = 0;
			for(int j=0; j<len-i; j++) {
				if(time[maxIndex] < time[j]) {
					maxIndex = j;
				}
			}
			int tmp = time[len-1-i];
			time[len-1-i] = time[maxIndex];
			time[maxIndex] = tmp;
		}
		return time;
	}
//	public static int[] sortArray(int[] input) {
//		int length = input.length;
//		int max = 0;
//		for (int i = length - 1; i > 0; i--) {
//			max = i;
//			for (int j = i - 1; j >= 0; j--) {
//				if (input[j] > input[max]) {
//					max = j;
//				}
//			}
//			int tmp = input[i];
//			input[i] = input[max];
//			input[max] = tmp;
//		}
//
//		return input;
//	}
}
