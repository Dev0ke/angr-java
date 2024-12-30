
public class Solution2424 {
    static class LUPrefix {
        private final int n;
        private final DSU dsu;

        public LUPrefix(int n) {
            this.n = n;
            dsu = new DSU(n);
        }

        public void upload(int video) {
            // 每个视频编号为 1 到 n 之间的 不同 数字。映射到 0 ~ n-1
            video--;

            dsu.sz[video]++;
            // dsu.sz[i] > 0 表示 i 已经上传
            if (video + 1 < n && dsu.sz[video + 1] > 0) {
                dsu.union(video, video + 1);
            }
            if (video - 1 >= 0 && dsu.sz[video - 1] > 0) {
                dsu.union(video, video - 1);
            }
        }

        public int longest() {
            return dsu.sz[0];
        }

        private static class DSU {
            // 父节点数组/祖先数组
            int[] fa;
            int[] sz;

            // 初始化
            public DSU(int n) {
                fa = new int[n];
                for (int i = 0; i < n; i++) {
                    fa[i] = i;
                }
                sz = new int[n];
            }

            // 查找
            int find(int x) {
                // 路径压缩
                if (x != fa[x]) {
                    fa[x] = find(fa[x]);
                }
                return fa[x];
            }

            // 合并
            void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) {
                    return;
                }
                // 合并到更小的节点
                if (rootP < rootQ) {
                    fa[rootQ] = rootP;
                    sz[rootP] += sz[rootQ];
                } else {
                    fa[rootP] = rootQ;
                    sz[rootQ] += sz[rootP];
                }
            }
        }
    }
}
/*
2424. 最长上传前缀
https://leetcode.cn/problems/longest-uploaded-prefix/

第 88 场双周赛 T2。

给你一个 n 个视频的上传序列，每个视频编号为 1 到 n 之间的 不同 数字，你需要依次将这些视频上传到服务器。请你实现一个数据结构，在上传的过程中计算 最长上传前缀 。
如果 闭区间 1 到 i 之间的视频全部都已经被上传到服务器，那么我们称 i 是上传前缀。最长上传前缀指的是符合定义的 i 中的 最大值 。
请你实现 LUPrefix 类：
LUPrefix(int n) 初始化一个 n 个视频的流对象。
void upload(int video) 上传 video 到服务器。
int longest() 返回上述定义的 最长上传前缀 的长度。
提示：
1 <= n <= 10^5
1 <= video <= 10^5
video 中所有值 互不相同 。
upload 和 longest 总调用 次数至多不超过 2 * 10^5 次。
至少会调用 longest 一次。

并查集。联通分量总是合并到更小的节点。最后 1 的联通分量大小即为 最长上传前缀 的长度。
时间复杂度 O(nlogn)
 */