package algorithm.tree;

/**
 * @author Herfrain
 * @date 2022/8/30 11:26
 * @description 线段树模板
 */
public class SegmentTree {
    int n;
    int[] nums;
    int[] segmentTree; // 线段树，保存一个线段的和，segmentTree[0]保存nums[0, n-1]的和

    public SegmentTree(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.segmentTree = new int[4 * n];
        buildTree(0, 0, n - 1);
    }

    // 初始化线段树
    void buildTree(int node, int l, int r) {
        if (l == r) { // 叶子节点，只有一个元素
            segmentTree[node] = nums[l];
            return;
        }
        int m = (r - l) / 2 + l;
        buildTree(node * 2 + 1, l, m); // 构建左子树
        buildTree(node * 2 + 2, m + 1, r);
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2]; // 本线段和 = 左子树的线段和 + 右子树的线段和
    }

    void update(int index, int val, int node, int l, int r) {
        if (l == r) {
            segmentTree[node] = val;
            return;
        }
        int m = (r - l) / 2 + l;
        if (index <= m) {
            update(index, val, node * 2 + 1, l, m);
        } else {
            update(index, val, node * 2 + 2, m + 1, r);
        }
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    // 将 nums[index] 的值 更新 为 val
    public void update(int index, int val) {
        update(index, val, 0, 0, n - 1);
    }

    int sumRange(int left, int right, int node, int l, int r) {
        if (left <= l && r <= right) {
            return segmentTree[node];
        }
        int m = (r - l) / 2 + l;
        int left_sum = 0, right_sum = 0;
        if (left <= m) {
            left_sum = sumRange(left, right, node * 2 + 1, l, m);
        } else if (right > m) {
            right_sum = sumRange(left, right, node * 2 + 2, m + 1, r);
        }
        return left_sum + right_sum;
    }

    //  返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
    public int sumRange(int left, int right) {
        return sumRange(left, right, 0, 0, n - 1);
    }
}
