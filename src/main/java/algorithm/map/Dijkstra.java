package algorithm.map;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {

	static final int MAXV = 1000;
	static final int INF = Integer.MAX_VALUE;

	static int n, m, st, ed;// n为顶点数，m为边数，st为起点，ed为终点
	static int[][] G = new int[MAXV][MAXV];// 图，邻接矩阵表示
	static int[] d = new int[MAXV];// d[u]表示st点到u点的最短距离
	static boolean[] visit = new boolean[MAXV];// 记录该点是否被访问过

	static void dijkstra(int s) {
		Arrays.fill(d, INF);
		d[s] = 0;

		// n个顶点，遍历n次，每次找到一个未访问的距离最短的点
		for (int i = 0; i < n; i++) {
			// 1.找到一个未被访问的u点,d[u]最小
			int u = -1, MIN = INF;
			for (int j = 0; j < n; j++) {
				if (visit[j] == false && d[j] < MIN) {
					u = j;
					MIN = d[j];
				}
			}

			if (u == -1)
				return;
			visit[u] = true;// 设为已访问

			// 2.更新u点未访问过的可到达的点的最短距离
			for (int v = 0; v < n; v++) {
				// v点未被访问 && u点可到达v点
				if (visit[v] == false && G[u][v] != INF) {
					// 以u为中介点到v点的距离小于当前的d[v]，则更新最短距离
					if (d[u] + G[u][v] < d[v]) {
						d[v] = d[u] + G[u][v];
					} else if (d[u] + G[u][v] == d[v]) {// 如果有多个最短路径，可以用来计数

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
		st = scanner.nextInt();
		// ed=scanner.nextInt();
		// 初始化数组G和d
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				G[i][j] = INF;
			}
		}
		// 输入图
		for (int i = 0; i < m; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			G[u][v] = w;
		}

		dijkstra(st);

		for (int i = 0; i < n; i++) {
			System.out.print(d[i] + " ");
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
 */