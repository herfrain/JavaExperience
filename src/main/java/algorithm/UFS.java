package algorithm;

import java.util.Scanner;

/*
 * 并查集（Union Find Set）
 * 是一种维护集合的数据结构
 * 操作：
 * 1.合并：合并两个集合
 * 2.查找：判断两个元素是否属于同一集合
 * 特点：
 * 1.father[i]表示元素i的父亲结点，若father[i]=i，说明元素i是该集合的根结点
 * 2.同一个集合中只存在一个根节点，它是所属集合的标识
 */

public class UFS {

	static int[] father;

	//1.初始化，每个元素都是独立的一个集合
	static void init(int n){
		father=new int[n+1];
		for(int i=1;i<=n;i++){
			father[i]=i;
		}
	}

	//2.查找元素x的根结点
	//迭代方式
	int findFather(int x){
		while(x!=father[x]){//如果不是根结点继续循环
			x=father[x];//x变成自己的父亲结点
		}
		return x;
	}
	//递归方式
	int findFather2(int x){
		if(x==father[x]) return x;//如果找到根结点则返回
		else return findFather2(father[x]);//如果元素x不是根结点，则判断它父亲结点是否是根结点
	}

	//3.合并
	static void union(int a,int b){//合并a和b两个元素所在的集合
		//先判断这两个元素是否属于同一集合
		int rootA=findFather2_depress(a);
		int rootB=findFather2_depress(b);
		if(rootA!=rootB){//如果不属于同一集合才需要合并
			father[rootA]=rootB;//让rootA的父亲结点指向rootB（反过来也行），这样就合并了两个集合
		}
	}

	//4.路径压缩
	//当路径(某元素到根结点的路径）长度为k，则找根结点需要O(k)
	//这时候可以将这个集合的所有结点的父亲都指向根结点，找根结点的时间复杂度为O(1)
	int maxStep=10;//最大允许的路径长度
	//迭代方式
	int findFather_depress(int x){//在查找的时候就可以进行路径压缩
		int xx=x;//先保存原结点
		int step=0;//记录路径长度
		while(x!=father[x]){//如果不是根结点继续循环
			x=father[x];//x变成自己的父亲结点
			step++;
		}
		//此时x是根结点
		if(step>maxStep){//如果超过这个阈值，则进行路径压缩
			while(xx!=father[xx]){
				int temp=xx;//保存当前元素
				xx=father[xx];//当前元素变成其父亲
				father[temp]=x;//将原来的结点的父亲指向根结点
			}
		}
		return x;
	}
	//递归方式
	static int findFather2_depress(int x){
		if(x==father[x]) return x;//如果找到根结点则返回
		else{
			int f=findFather2_depress(father[x]);//这里会返回根结点
			father[x]=f;//回溯时将当前元素的父亲指向根结点
			return f;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,m;
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		m=scanner.nextInt();

		init(n);
		for(int i=0;i<m;i++){
			int a,b;
			a=scanner.nextInt();
			b=scanner.nextInt();
			union(a, b);
		}
//		for(int i=1;i<=n;i++){
//			System.out.print(father[i]+" ");
//		}System.out.println();

		boolean[] isRoot=new boolean[n+1];//记录i是否是根结点
		for(int i=1;i<=n;i++){//遍历所有结点
			isRoot[findFather2_depress(i)]=true;//他们的根结点赋值为true
		}
//		for(int i=1;i<=n;i++){
//			System.out.print(father[i]+" ");
//		}System.out.println();

		int ans=0;
		for(int i=1;i<=n;i++){//遍历所有结点
			if(isRoot[i]==true) ans++;
		}

		System.out.println(ans);
	}

}

/*
4 2
1 4
2 3
2

7 5
1 2
2 3
3 1
1 4
5 6
3
*/