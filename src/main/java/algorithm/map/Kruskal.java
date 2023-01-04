package algorithm.map;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Kruskal {

	static final int MAX = 1000;
	static final int INF = Integer.MAX_VALUE;

	static int[][] Edges = new int[MAX][MAX]; // 边集合，每条边表示为[u,v,w]，结点u与v之间有连接，权值为w
	static int n, m; // n为顶点数，m为边数
	static int[] parent;

	static int findRoot(int u){
		int tmp = u;
		while(parent[u] != -1){
			u = parent[u];
		}
		// 路径压缩
		while(parent[tmp] != -1){
			int t = tmp;
			tmp = parent[tmp];
			parent[t] = u;
		}
		return u;
	}

	static boolean union(int u, int v){
		int r1 = findRoot(u);
		int r2 = findRoot(v);
		if(r1 == r2){
			return false;
		}else{
			parent[r2] = r1;
			return true;
		}
	}

	static int Kruskal(){
		int res = 0; // 最小生成树权值
		int size = 0; // 最小生成树边个数
		Arrays.sort(Edges, 0, m, (A, B) -> A[2]-B[2]);

		// 在未访问的边中，寻找权值最小的边，而且该边两个节点不在同一集合中
		for(int i=0; i<m && size != n - 1; i++){
			if(union(Edges[i][0], Edges[i][1])){
				res += Edges[i][2];
				size++;
			}
		}

		if(size != n - 1) return -1; // 不连通

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		// 初始化并查集
		parent = new int[n];
		Arrays.fill(parent, -1);

		// 输入图
		for (int i = 0; i < m; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			Edges[i] = new int[]{u, v, w};
		}

		int ans = Kruskal();
		System.out.println(ans);
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