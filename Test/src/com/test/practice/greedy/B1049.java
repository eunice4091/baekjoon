package com.test.practice.greedy;

import java.util.Scanner;

/**
 * 기타에서 끊어진 줄 N개 (1~100) 6줄 패키지 또는 낱개 구매 가능
 * 
 * 기타줄 브랜드 M개 (1~50) 6개의 패키지 가격 낱개 가격 (0~1000)
 * 
 * 최소값으로 기타줄 구매
 */
public class B1049 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stringCount = sc.nextInt();
		int brandCount = sc.nextInt();
		int[][] prices = new int[brandCount][2];
		for (int i = 0; i < brandCount; i++) {
			prices[i][0] = sc.nextInt(); // package
			prices[i][1] = sc.nextInt(); // single
		}
		System.out.print(getAmount(stringCount, brandCount, prices));
		sc.close();
	}

	private static int getAmount(int stringCount, int brandCount, int[][] prices) {
		int amount = 0;
		int packageCount = stringCount / 6;
		int singleCount = stringCount % 6;
		int packagePrice = prices[0][0];
		if (prices[0][0] > prices[0][1] * 6) {
			packagePrice = prices[0][1] * 6;
		}
		int singlePrice = prices[0][1];
		for (int i = 1; i < brandCount; i++) {

			if (packagePrice > prices[i][0]) {
				packagePrice = prices[i][0];
				if (prices[i][0] < prices[i][1]) {
					packagePrice = prices[i][1] * 6;
				}
			}
			if (singlePrice > prices[i][1]) {
				singlePrice = prices[i][1];
			}
		}
		amount = packageCount * packagePrice + singleCount * singlePrice;
		return amount;
	}

}
