package algorithm.tree;

/**
 * @author Herfrain
 * @date 2022/8/30 11:26
 * @description 树状数组模板
 * 1、数组不变，求区间和：「前缀和」、「树状数组」、「线段树」
 * 2、多次修改某个数（单点），求区间和：「树状数组」、「线段树」
 * 3、多次修改某个区间，输出最终结果：「差分」
 * 4、多次修改某个区间，求区间和：「线段树」、「树状数组」（看修改区间范围大小）
 * 5、多次将某个区间变成同一个数，求区间和：「线段树」、「树状数组」（看修改区间范围大小）
 */
class NumArray {
    int[] tree;
    int[] nums;
    int n;

    // 求x的最低位为1表示的值
    // 注意: x不能等于0, 否则会进入死循环, 所以树状数组通常使用的下标会执行+1操作
    int lowbit(int x) {
        return x & -x;
    }
    // 查询前缀和的方法
    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }
    // 在树状数组 x 位置中增加值 u
    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tree[i] += u;
        }
    }

    public NumArray(int[] _nums) {
        nums = _nums;
        n = nums.length;
        tree = new int[n + 1];
        // 默认数组是从 1 开始
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int i, int val) {
        // 原有的值是 nums[i]，要使得修改为 val，需要增加 val - nums[i]
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int l, int r) {
        return query(r + 1) - query(l);
    }
}
