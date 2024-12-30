import java.util.ArrayList;
import java.util.List;

public class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> resList = new ArrayList<>();
        int num = 1;
        // 保证最多不超过 n 个数
        for (int i = 0; i < n; i++) {
            resList.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num++;
            }
        }
        return resList;
    }
}
/*
386. 字典序排数
https://leetcode.cn/problems/lexicographical-numbers/

给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
提示：
1 <= n <= 5 * 10^4

迭代。
 */