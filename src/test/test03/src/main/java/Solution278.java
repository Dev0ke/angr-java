public class Solution278 {
    static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (isBadVersion(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        // UT
        public Solution(int bad) {
            super(bad);
        }
    }

    private static class VersionControl {
        int bad;

        public VersionControl(int bad) {
            this.bad = bad;
        }

        boolean isBadVersion(int version) {
            return version >= bad;
        }
    }
}
/*
278. 第一个错误的版本
https://leetcode.cn/problems/first-bad-version/

你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，
所以错误的版本之后的所有版本都是错的。
假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。
你应该尽量减少对调用 API 的次数。
提示：
1 <= bad <= n <= 2^31 - 1

二分
 */