import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1104 {
    public List<Integer> pathInZigZagTree(int label) {
        int row = 1, rowStart = 1;
        while (rowStart << 1 <= label) {
            rowStart <<= 1;
            row++;
        }
        if (row % 2 == 0) {
            label = getReverse(label, row);
        }
        List<Integer> ans = new ArrayList<>();
        while (row > 0) {
            if (row % 2 == 0) {
                ans.add(getReverse(label, row));
            } else {
                ans.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(ans);
        return ans;
    }

    private int getReverse(int label, int row) {
        return (1 << (row - 1)) + (1 << row) - 1 - label;
    }
}
/*
1104. 二叉树寻路
https://leetcode.cn/problems/path-in-zigzag-labelled-binary-tree/description/

在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
提示：
1 <= label <= 10^6

数学 / 找规律
时间复杂度 O(log(label))
 */