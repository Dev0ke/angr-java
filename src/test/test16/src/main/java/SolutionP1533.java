public class SolutionP1533 {
    public int getIndex(ArrayReader reader) {
        int left = 0;
        int right = reader.length() - 1;
        boolean evenLen;
        while (left < right) {
            // 长度是否为偶数
            evenLen = (right - left + 1) % 2 == 0;
            int mid = left + (right - left) / 2;

            // 奇数比较 [left,mid-1] mid [mid+1,right]
            // 偶数比较 [left,mid] [mid+1,right]
            int compare = reader.compareSub(left, (evenLen ? mid : mid - 1), mid + 1, right);

            if (compare > 0) {
                right = mid;
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    interface ArrayReader {
        // Compares the sum of arr[l..r] with the sum of arr[x..y]
        // return 1 if sum(arr[l..r]) > sum(arr[x..y])
        // return 0 if sum(arr[l..r]) == sum(arr[x..y])
        // return -1 if sum(arr[l..r]) < sum(arr[x..y])
        int compareSub(int l, int r, int x, int y);

        // Returns the length of the array
        int length();
    }
}
/*
$1533. 找到最大整数的索引
https://leetcode.cn/problems/find-the-index-of-the-large-integer/

我们有这样一个整数数组 arr ，除了一个最大的整数外，其他所有整数都相等。你不能直接访问该数组，你需要通过 API ArrayReader 来间接访问，这个 API 有以下成员函数：
- int compareSub(int l, int r, int x, int y)：其中 0 <= l, r, x, y < ArrayReader.length()， l <= r 且 x <= y。
这个函数比较子数组 arr[l..r] 与子数组 arr[x..y] 的和。该函数返回：
 - 1 若 arr[l]+arr[l+1]+...+arr[r] > arr[x]+arr[x+1]+...+arr[y] 。
 - 0 若 arr[l]+arr[l+1]+...+arr[r] == arr[x]+arr[x+1]+...+arr[y] 。
 - -1 若 arr[l]+arr[l+1]+...+arr[r] < arr[x]+arr[x+1]+...+arr[y] 。
- int length()：返回数组的长度。
你最多可以调用函数 compareSub() 20 次。你可以认为这两个函数的时间复杂度都为 O(1) 。
返回 arr 中最大整数的索引。
提示:
2 <= arr.length <= 5 * 10^5
1 <= arr[i] <= 100
arr 中除一个最大元素外，其余所有元素都相等。
进阶
如果 arr 中有两个整数比其他数大呢？
如果有一个数比其他数大，另一个数比其他数小呢？

二分。
 */