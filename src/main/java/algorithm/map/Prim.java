package algorithm.map;

import java.util.Arrays;
import java.util.Scanner;

public class Prim {

	static final int MAXV = 1000;
	static final int INF = Integer.MAX_VALUE;

	static int n, m;// n为顶点数，m为边数
	static int[][] G = new int[MAXV][MAXV];// 图，邻接矩阵表示
	static int[] d = new int[MAXV];// d[u]表示S集合到u点的最短距离（与Dijkstra的不同是d[u]的含义）
	static boolean[] visit = new boolean[MAXV];// 记录该点是否被访问过

	public static int Prim(int start) {
		int res = 0; // 最小生成树的权和
		Arrays.fill(d, INF);
		d[start] = 0; // 起点距离S集合为0

		for (int i = 0; i < n; i++) {
			// 从V-S集合中选择一个距离S集合最小的节点u
			int u = -1, MIN = INF;
			for (int j = 0; j < n; j++) {
				if (visit[j] == false && d[j] < MIN) {
					u = j;
					MIN = d[j];
				}
			}
			if (u == -1) // 找不到小于INF的d[u]，则剩下的节点与集合S不连通
				return -1;
			visit[u] = true; // 访问u
			res += d[u]; // 最小生成树权和累加

			for (int v = 0; v < n; v++) {
				if (visit[v] == false && G[u][v] != INF
						&& G[u][v] < d[v]) { // 更新其他未访问的且可到达的节点到S集合的最小距离
					d[v] = G[u][v];
				}
			}
		}

		return res;
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
				G[j][i] = INF;
			}
		}
		// 输入图
		for (int i = 0; i < m; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			G[u][v] = w;
			G[v][u] = w;
		}

		int ans = Prim(0); // 以0为起点
		System.out.println(ans);

//		for (int i = 0; i < n; i++) {
//			System.out.print(d[i] + " ");
//		}
//		System.out.println();
	}

}

/*
6 8
0 1 1
0 3 4
0 4 4
1 3 2
2 5 1
3 2 2
3 4 3
4 5 3

9
*/