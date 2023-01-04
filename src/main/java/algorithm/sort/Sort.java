package algorithm.sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Sort {

    /*
     * 1.二路归并排序
     * 时间复杂度(最好、最坏、平均)：O(nlogn)，O(nlogn)，O(nlogn)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     */

    // 合并两个有序数组
    private static void merge(int[] target, int l1, int r1, int l2, int r2) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int i = l1, j = l2;
        while (i <= r1 && j <= r2) {
            if (target[i] < target[j]) {
                temp.add(target[i++]);
            } else {
                temp.add(target[j++]);
            }
        }
        while (i <= r1) {
            temp.add(target[i++]);
        }
        while (j <= r2) {
            temp.add(target[j++]);
        }
        for (int q = 0; q < temp.size(); q++) {
            target[l1 + q] = temp.get(q);
        }
    }

    // 递归
    public static void mergeSort(int[] target, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(target, left, mid);
            mergeSort(target, mid + 1, right);
            merge(target, left, mid, mid + 1, right);
        }
    }

    /*
     * 2.快速排序
     * 时间复杂度(最好、最坏、平均)：O(nlogn)，O(n^2)，O(nlogn)
     * 空间复杂度：O(logn)~O(n)
     * 稳定性：不稳定
     */

    // 确定某个元素的位置
    static int getPosition(int[] nums, int left, int right) {
        int tempi = (int) (Math.random() * (right - left + 1) + left); // 随机选择下标
        System.out.println(tempi);
        int key = nums[tempi];
        nums[tempi] = nums[left];
        nums[left] = key;
        while (left < right) {
            while (left < right && nums[right] >= key)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= key)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = key;
        return left;
    }

    // 递归
    static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int p = getPosition(nums, left, right);
            quickSort(nums, left, p - 1);
            quickSort(nums, p + 1, right);
        }
    }


    /*
     * 3.直接插入排序
     * 时间复杂度(最好、最坏、平均)：O(n)，O(n^2)，O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */

    static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i - 1; // 从i-1处开始比较
            int temp = nums[i]; // 暂存需要插入的值
            while (j >= 0 && nums[j] > temp) { // 直到找到一个小于或等于temp的数或者到了最左边
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp; // 在后面插入
        }
    }

    /*
     * 4.折半插入排序
     * 时间复杂度(最好、最坏、平均)：O(nlogn)，O(n^2)，O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */

    static void midInsertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i]; // 暂存需要插入的值
            int left = 0, right = i - 1;
            // 找到要插入的位置
            while (left <= right) {
                int mid = right - (right - left) / 2;
                if (nums[mid] > temp) { // 小于中间的，则往左边找
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 插入位置为right+1，那么要将这个位置后面的元素都往后移一位
            for (int j = i - 1; j >= right + 1; j--) {
                nums[j + 1] = nums[j];
            }

            nums[right + 1] = temp; // 在该位置插入
        }
    }


    /*
     * 5.堆排序
     * 时间复杂度(最好、最坏、平均)：O(nlogn)，O(nlogn)，O(nlogn)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */

    // 对数组在[low,high]范围内向下调整（大根堆）
    static void downAdjust(int[] nums, int low, int high) {
        int i = low, j = low * 2 + 1; // i为父节点，j为左子节点
        while (j <= high) {
            // 找i的两个子节点中最大的
            if (j + 1 <= high && nums[j + 1] > nums[j]) { // 如果右子节点存在，且比左子节点大，则选右边
                j = j + 1;
            }

            // 如果子节点中较大的比父节点大，则交换
            if (nums[j] > nums[i]) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                // 继续往下调整
                i = j;
                j = i * 2 + 1;
            } else { // 如果父节点比子节点都大，则不需要继续调整
                break;
            }
        }
    }

    // 建堆（大根堆）
    static void createHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) { // 从最后一个非叶子结点开始，往前遍历，每次都进行向下调整
            downAdjust(nums, i, nums.length - 1);
        }
    }

    // 堆排序（升序）
    static void heapSort(int[] nums) {
        createHeap(nums); // 先建堆

        for (int i = nums.length - 1; i > 0; i--) {
            // 交换第一个和未排序的最后一个元素（即把最大的放最后
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            // 然后从根结点往下调整
            downAdjust(nums, 0, i - 1);
        }

    }

    /*
     * 6.基数排序
     * r为基数，d为元素的位数，n为元素的个数
     * 时间复杂度(最好、最坏、平均)：O(d(n+r))，O(d(n+r))，O(d(n+r))，d趟分配和收集
     * 空间复杂度：O(r)
     * 稳定性：稳定
     */
    // 分配
    static void distribute(int[] nums, int d, Deque<Integer>[] queue_list){
        for(int item : nums){
            queue_list[(int)(item/Math.pow(10, d)) % 10].offer(item);
        }
    }

    // 收集
    static boolean collect(int[] nums, Deque<Integer>[] queue_list){
        int n = queue_list[0].size();
        int i = 0;
        for(Deque<Integer> queue : queue_list){
            while(!queue.isEmpty()){
                nums[i++] = queue.poll();
            }
        }
        return n == nums.length;
    }

    // 排序
    static void radixSort(int[] nums, Deque<Integer>[] queue_list){
        boolean isEnd = false;
        int d = 0;
        while(!isEnd){
            distribute(nums, d++, queue_list);
            isEnd = collect(nums, queue_list);
        }
    }


    public static void main(String[] args) {
        //  TODO Auto-generated method stub
        int[] nums = {5, 2, 5, 11, 23, 5, 2, 4, 6};
//        quickSort(nums, 0, nums.length - 1);
        Deque<Integer>[] queue_list = new ArrayDeque[10];
        for(int i=0;i<10;i++){
            queue_list[i] = new ArrayDeque<>();
        }
        radixSort(nums, queue_list);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}
