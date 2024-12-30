public class Solution427 {
    private int[][] ps2d;

    public Node construct(int[][] grid) {
        int n = grid.length;
        ps2d = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ps2d[i][j] = ps2d[i - 1][j] + ps2d[i][j - 1] - ps2d[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return dfs(0, 0, n, n);
    }

    private Node dfs(int x1, int y1, int x2, int y2) {
        int total = sumRegion(x1, y1, x2, y2);
        if (total == 0) {
            return new Node(false, true);
        } else if (total == (x2 - x1) * (y2 - y1)) {
            return new Node(true, true);
        }
        return new Node(
                true,
                false,
                dfs(x1, y1, (x1 + x2) / 2, (y1 + y2) / 2),
                dfs(x1, (y1 + y2) / 2, (x1 + x2) / 2, y2),
                dfs((x1 + x2) / 2, y1, x2, (y1 + y2) / 2),
                dfs((x1 + x2) / 2, (y1 + y2) / 2, x2, y2)
        );
    }

//    private int sumRegion(int x1, int y1, int x2, int y2) {
//        return ps2d[x2 + 1][y2 + 1] - ps2d[x2 + 1][y1] - ps2d[x1][y2 + 1] + ps2d[x1][y1];
//    }

    public int sumRegion(int r0, int c0, int r1, int c1) {
        return ps2d[r1][c1] - ps2d[r1][c0] - ps2d[r0][c1] + ps2d[r0][c0];
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
/*
427. 建立四叉树
https://leetcode.cn/problems/construct-quad-tree/description/

给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
你需要返回能表示矩阵 grid 的 四叉树 的根结点。
四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
- val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False。注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
- isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;
}
我们可以按以下步骤为二维区域构建四叉树：
1.如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
2.如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
3.使用适当的子网格递归每个子节点。
如果你想了解更多关于四叉树的内容，可以参考 wiki 。
四叉树格式：
你不需要阅读本节来解决这个问题。只有当你想了解输出格式时才会这样做。输出为使用层序遍历后四叉树的序列化形式，其中 null 表示路径终止符，其下面不存在节点。
它与二叉树的序列化非常相似。唯一的区别是节点以列表形式表示 [isLeaf, val] 。
如果 isLeaf 或者 val 的值为 True ，则表示它在列表 [isLeaf, val] 中的值为 1 ；如果 isLeaf 或者 val 的值为 False ，则表示值为 0 。
提示：
n == grid.length == grid[i].length
n == 2^x 其中 0 <= x <= 6

递归 + 二维前缀和
时间复杂度 O(n^2)
相似题目: 558. 四叉树交集
https://leetcode.cn/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/description/
1444. 切披萨的方案数
https://leetcode.cn/problems/number-of-ways-of-cutting-a-pizza/description/
 */