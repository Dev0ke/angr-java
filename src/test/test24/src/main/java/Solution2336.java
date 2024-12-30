import java.util.TreeSet;

public class Solution2336 {
    static class SmallestInfiniteSet {
        private final TreeSet<Integer> treeSet;

        public SmallestInfiniteSet() {
            treeSet = new TreeSet<>();
            for (int i = 1; i <= 1000; i++) {
                treeSet.add(i);
            }
        }

        public int popSmallest() {
            int first = treeSet.first();
            treeSet.remove(first);
            return first;
        }

        public void addBack(int num) {
            treeSet.add(num);
        }
    }
}
/*
2336. 无限集中的最小数字
https://leetcode.cn/problems/smallest-number-in-infinite-set/

第 301 场周赛 T2。

现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。
实现 SmallestInfiniteSet 类：
- SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
- int popSmallest() 移除 并返回该无限集中的最小整数。
- void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集中。
提示：
1 <= num <= 1000
最多调用 popSmallest 和 addBack 方法 共计 1000 次

有序集合模拟
 */