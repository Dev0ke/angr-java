public class SolutionP702 {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 10000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            // FFFTTT
            if (reader.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return reader.get(left) == target ? left : -1;
    }

    interface ArrayReader {
        int get(int index);
    }
}
/*
$702. 搜索长度未知的有序数组
https://leetcode.cn/problems/search-in-a-sorted-array-of-unknown-size/

这是一个交互问题。
您有一个升序整数数组，其长度未知。您没有访问数组的权限，但是可以使用 ArrayReader 接口访问它。你可以调用 ArrayReader.get(i):
- 返回数组第ith个索引(0-indexed)处的值(即secret[i])，或者
- 如果 i  超出了数组的边界，则返回 2^31 - 1
你也会得到一个整数 target。
如果存在secret[k] == target，请返回索引 k 的值；否则返回 -1
你必须写一个时间复杂度为 O(log n) 的算法。
提示：
1 <= secret.length <= 10^4
-10^4 <= secret[i], target <= 10^4
secret 严格递增

二分
 */