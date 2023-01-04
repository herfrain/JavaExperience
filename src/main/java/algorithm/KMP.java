package algorithm;

import java.util.Arrays;
import java.util.Scanner;

// 改进的模式匹配算法，Knuth-Morris-Pratt 算法，KMP
public class KMP {

    // 获取子串T的next移动数组
    static int[] getNext(String T) {
        int n = T.length();
        int[] next = new int[n];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < n - 1) {
            if (j == -1 || T.charAt(i) == T.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    // S[pos, S.length()) 匹配子串 T，返回第一次匹配子串的首字符下标
    static int index_KMP(String S, String T, int[] next, int pos) {
        int i = pos, j = 0;
        while (i < S.length() && j < T.length()) {
            if (j == -1 || S.charAt(i) == T.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j >= T.length()) {
            return i - T.length();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        String T = scanner.nextLine();
        int pos = scanner.nextInt();

        int[] next = getNext(T);
        int res = index_KMP(S, T, next, pos);

        System.out.println(Arrays.toString(next));
        System.out.println(res);
    }
}
/*
ababcabcacbab
abcac
0
* */