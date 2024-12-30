import java.util.HashMap;
import java.util.Map;

public class Solution1095 {
    private Map<Integer, Integer> memoMap;

    private int memoGet(MountainArray mountainArr, int index) {
        if (memoMap == null) {
            memoMap = new HashMap<>();
        }
        if (memoMap.containsKey(index)) {
            return memoMap.get(index);
        }
        int value = mountainArr.get(index);
        memoMap.put(index, value);
        return value;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();

        // 先找到山峰
        int peak = peakIndexInMountainArray(mountainArr, len);

        // 左侧二分找
        int left = 0;
        int right = peak;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (memoGet(mountainArr, mid) == target) {
                return mid;
            } else if (memoGet(mountainArr, mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 右侧二分找
        left = peak + 1;
        right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (memoGet(mountainArr, mid) == target) {
                return mid;
            } else if (memoGet(mountainArr, mid) > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // solution 852 二分查找 O(logn)
    public int peakIndexInMountainArray(MountainArray mountainArr, int len) {
        int left = 1;
        int right = len - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (memoGet(mountainArr, mid) > memoGet(mountainArr, mid - 1)
                    && memoGet(mountainArr, mid) > memoGet(mountainArr, mid + 1)) {
                return mid;
            } else if (mountainArr.get(mid) > mountainArr.get(mid - 1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    interface MountainArray {
        int get(int index);

        int length();
    }
}
/*
1095. 山脉数组中查找目标值
https://leetcode.cn/problems/find-in-mountain-array/

（这是一个 交互式问题 ）
给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
如果不存在这样的下标 index，就请返回 -1。
何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
首先，A.length >= 3
其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
- A[0] < A[1] < ... A[i-1] < A[i]
- A[i] > A[i+1] > ... > A[A.length - 1]
你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
- MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
- MountainArray.length() - 会返回该数组的长度
注意：
对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。
提示：
3 <= mountain_arr.length() <= 10000
0 <= target <= 10^9
0 <= mountain_arr.get(index) <= 10^9

二分。
相似题目: 852. 山脉数组的峰顶索引
https://leetcode.cn/problems/peak-index-in-a-mountain-array/
 */