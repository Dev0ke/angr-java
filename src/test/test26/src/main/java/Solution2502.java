import java.util.Arrays;

public class Solution2502 {
    static class Allocator {
        private final int n;
        private final int[] arr;

        public Allocator(int n) {
            this.n = n;
            arr = new int[n];
        }

        public int allocate(int size, int mID) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) {
                    cnt = 0;
                } else {
                    cnt++;
                    if (cnt == size) {
                        Arrays.fill(arr, i - size + 1, i + 1, mID);
                        return i - size + 1;
                    }
                }
            }
            return -1;
        }

        public int free(int mID) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == mID) {
                    cnt++;
                    arr[i] = 0;
                }
            }
            return cnt;
        }
    }
}
/*
2502. 设计内存分配器
https://leetcode.cn/problems/design-memory-allocator/

第 323 场周赛 T3。

给你一个整数 n ，表示下标从 0 开始的内存数组的大小。所有内存单元开始都是空闲的。
请你设计一个具备以下功能的内存分配器：
1. 分配 一块大小为 size 的连续空闲内存单元并赋 id mID 。
2. 释放 给定 id mID 对应的所有内存单元。
注意：
- 多个块可以被分配到同一个 mID 。
- 你必须释放 mID 对应的所有内存单元，即便这些内存单元被分配在不同的块中。
实现 Allocator 类：
- Allocator(int n) 使用一个大小为 n 的内存数组初始化 Allocator 对象。
- int allocate(int size, int mID) 找出大小为 size 个连续空闲内存单元且位于 最左侧 的块，分配并赋 id mID 。返回块的第一个下标。如果不存在这样的块，返回 -1 。
- int free(int mID) 释放 id mID 对应的所有内存单元。返回释放的内存单元数目。
提示：
1 <= n, size, mID <= 1000
最多调用 allocate 和 free 方法 1000 次

暴力
 */