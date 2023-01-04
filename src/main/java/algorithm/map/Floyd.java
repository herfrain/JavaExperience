package algorithm.map;

import java.util.Scanner;

public class Floyd {

	static final int MAXV = 1000;
	static final int INF = Integer.MAX_VALUE;

	static int n, m;// n为顶点数，m为边数
	static int[][] G = new int[MAXV][MAXV];// 图，邻接矩阵表示
	static int[][] d = new int[MAXV][MAXV];// d[u][v]表示u点到v点的最短距离
	static boolean[] visit = new boolean[MAXV];// 记录该点是否被访问过

	// Floyd算法，求图中两两节点的最短距离，O(n^3)
	public static void Floyd() {
		// 初始化
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				d[i][j] = G[i][j];
			}
		}

		for (int k = 0; k < n; k++) { // 中间节点
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (d[i][k] == INF || d[k][j] == INF)
						continue; // i通过中间节点到达j，所以中间两段路必须可达
					if (d[i][k] + d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		// 初始化数组G
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				G[i][j] = INF;
			}
			G[i][i] = 0;
		}
		// 输入图
		for (int i = 0; i < m; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			G[u][v] = w;
		}

		Floyd();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

}
/*
6 8 0
0 1 1
0 3 4
0 4 4
1 3 2
2 5 1
3 2 2
3 4 3
4 5 3

0 1 5 3 4 6 
2147483647 0 4 2 5 5 
2147483647 2147483647 0 2147483647 2147483647 1 
2147483647 2147483647 2 0 3 3 
2147483647 2147483647 2147483647 2147483647 0 3 
2147483647 2147483647 2147483647 2147483647 2147483647 0 
 */