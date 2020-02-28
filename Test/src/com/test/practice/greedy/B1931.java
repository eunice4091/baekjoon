package com.test.practice.greedy;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 1931 회의실 배정
 * 1개의 회의실, N개의 회의
 * 사용표
 * 각 회의 I 시작시간, 종료 시간 입력
 * 각 회의가 겹치치 않게 하면서 회의실을 사용할 수 있는 최대수의 회의
 * n번째회의의 끝나는 시간과 n+1번째 회의의 끝나는 시간 동일할 수 있다.
 * 
 * N(1 ≤ N ≤ 100,000)
 * 시작 시간과 끝나는 시간은 2^31-1보다 작거나 같은 자연수
 */
import java.util.Scanner;

public class B1931 {
	public static void main(String[] str) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int time[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}
		int cnt = schedule(time);
		System.out.println(cnt);
		sc.close();
	}

	public static int schedule(int[][] time) {
		int cnt = 1;
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				if (arg0[1] == arg1[1]) {
					return arg0[0] - arg1[0];
				} else {
					return arg0[1] - arg1[1];
				}
			}
		});
		int lastTime = 0;
		for (int i = 1; i < time.length; i++) {
			if (time[i][0] >= time[lastTime][1]) {
				cnt++;
				lastTime = i;
			}
		}

		return cnt;
	}

//	public static int[][] sortTime(int[][] time){
//		int len = time.length;
//		for(int i=0; i<len; i++) {
//			int min=i;
//			for(int j=i+1; j<len; j++) {
//				if(time[min][1]>=time[j][1]) {
//					min = j;
//				}
//			}
//			int[] tmp = time[min];
//			time[min] = time[i];
//			time[i] = tmp;
//		}
//		
//		return time;
//	}
}
