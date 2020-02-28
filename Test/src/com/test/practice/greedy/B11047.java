package com.test.practice.greedy;

import java.util.Scanner;

/**
 * 동전 N가지, 동전의 합 K  (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 * 동전의 값 N개 오름차순으로 입력 (총 N+2개 입력)
 * 동전을 조합하여 동전의 합 K를 만드는데 필요한 동전의 개수 최솟값 구해보자!
 */
public class B11047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int coinCount = sc.nextInt();
		int amount = sc.nextInt();
		int[] coins = new int[coinCount];
		for(int i=0; i<coinCount; i++) {
			coins[i] = sc.nextInt();
		}
		
		System.out.println(getCoinCount(amount, coinCount, coins));
		sc.close();
	}

	private static int getCoinCount(int amount, int len, int[] coins) {
		int cnt = 0;
		for(int i=len-1; i>=0; i--) {
			if(coins[i] < amount) {
				cnt += Integer.valueOf(amount / coins[i]);
				amount = amount % coins[i];
			}
		}
		
		return cnt;
		
	}

}
