package com.test.practice.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class B2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int[] cards = new int[n];

		for (int i = 0; i < n; i++) {
			cards[i] = sc.nextInt();
		}
		Arrays.sort(cards);
		int result = 0;
		int cnt = (n - 2) * (n - 1) * n;
		int[] sumList = new int[cnt];
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					sumList[cnt] = cards[i] + cards[j] + cards[k];
				}
			}
		}

		for (int i = 0; i < cnt; i++) {
			if (sumList[i] < sum) {
				sum = sumList[i];
			} else {
				break;
			}
		}

		System.out.print(result);
		sc.close();
	}
}
