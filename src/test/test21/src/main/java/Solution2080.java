import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2080 {
    static class RangeFreqQuery {
        private final Map<Integer, List<Integer>> numIdxMap;

        public RangeFreqQuery(int[] arr) {
            numIdxMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                List<Integer> idxList = numIdxMap.getOrDefault(arr[i], new ArrayList<>());
                idxList.add(i);
                numIdxMap.put(arr[i], idxList);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> idxList = numIdxMap.getOrDefault(value, new ArrayList<>());
            if (idxList.isEmpty()) {
                return 0;
            }
            int leftIdx = binarySearchLeftBound(idxList, left);
            int rightIdx = binarySearchRightBound(idxList, right);
            return rightIdx - leftIdx + 1;
        }

        private int binarySearchLeftBound(List<Integer> nums, int target) {
            int left = 0;
            int right = nums.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums.get(mid) == target) {
                    right = mid;
                } else if (nums.get(mid) < target) {
                    left = mid + 1;
                } else if (nums.get(mid) > target) {
                    right = mid;
                }
            }
            return left;
        }

        private static int binarySearchRightBound(List<Integer> nums, int target) {
            int left = 0;
            int right = nums.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums.get(mid) == target) {
                    left = mid + 1;
                } else if (nums.get(mid) < target) {
                    left = mid + 1;
                } else if (nums.get(mid) > target) {
                    right = mid;
                }
            }
            return left - 1;
        }
    }
}
/*
2080. 区间内查询数字的频率
https://leetcode.cn/problems/range-frequency-queries/

第 268 场周赛 T3。

请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
请你实现 RangeFreqQuery 类：
RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。

HashMap 存每个 value 的下标，然后二分找下标边界即可。
 */