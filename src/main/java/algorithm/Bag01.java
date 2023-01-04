package algorithm;

import java.util.Scanner;

public class Bag01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		int n = 0;
		int W = 0;
		n = scanner.nextInt();// n个物品
		W = scanner.nextInt();// W是背包的最大容量
		int[] w = new int[n + 1];// 每个物品的重量
		int[] v = new int[n + 1];// 每个物品的价值
		for (int i = 1; i <= n; i++) {
			w[i] = scanner.nextInt();
			v[i] = scanner.nextInt();
		}

		int[][] dp = new int[n + 1][W + 1];// dp[i][j]表示前i个物品装入容量为j的背包所能得到的最大总价值

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (w[i] > j) {// 第i个物品重量大于j容量，放不进去
					dp[i][j] = dp[i - 1][j];
				} else {
					// 放进去和不放进去比较，取最大值
					// 放进去：放入第i个物品后价值达到dp[i][j]，即上一个状态应该是dp[i-1][j-w[i]]，再加上v[i]，等于dp[i][j]
					dp[i][j] = Math.max(dp[i - 1][j - w[i]] + v[i],
							dp[i - 1][j]);
				}
			}
		}

		System.out.println(dp[n][W]);
	}

}
/*
 * 5 20 2 3 3 4 4 5 5 8 9 10
 */