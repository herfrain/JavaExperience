package algorithm.tree;

/**
 * @Description: 线段树（动态开点）
 * 基于求「区间和」以及对区间进行「加减」的更新操作，且为「动态开点」
 * @Author: LFool
 * @Date 2022/6/7 09:15
 **/
public class SegmentTreeDynamic {
    class Node {
        Node left, right;
        int val, add;
    }
    private int N = (int)(1e+9);
    private Node root = new Node();

    // [left, right]范围内的元素都增加val
    public void update(int left, int right, int val){
        update(root, 0, N, left, right, val);
    }
    
    private void update(Node node, int start, int end, int L, int R, int val) {
        if (L <= start && end <= R) {
            node.val += (end - start + 1) * val;
            node.add += val;
            return ;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (L <= mid) {
            update(node.left, start, mid, L, R, val);
        }
        if (R > mid) {
            update(node.right, mid + 1, end, L, R, val);
        }
        pushUp(node);
    }

    // 查询[left, right]中的元素和
    public int query(int left, int right){
        return this.query(root, 0, N, left, right);
    }
    
    private int query(Node node, int start, int end, int L, int R) {
        if (L <= start && end <= R) {
            return node.val;
        }
        int mid = (start + end) >> 1, ans = 0;
        pushDown(node, mid - start + 1, end - mid);
        if (L <= mid) {
            ans += query(node.left, start, mid, L, R);
        }
        if (R > mid) {
            ans += query(node.right, mid + 1, end, L, R);
        }
        return ans;
    }

    private void pushUp(Node node) {
        node.val = node.left.val + node.right.val;
    }

    private void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        if (node.add == 0) {
            return ;
        }
        node.left.val += node.add * leftNum;
        node.right.val += node.add * rightNum;
        // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }
}
