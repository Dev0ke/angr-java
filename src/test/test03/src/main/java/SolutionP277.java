import java.util.HashMap;
import java.util.Map;

public class SolutionP277 {
    static class Solution extends Relation {
        private int numberOfPeople;
        private final Map<Long, Boolean> cache = new HashMap<>();

        @Override
        public boolean knows(int a, int b) {
            if (!cache.containsKey(hash(a, b))) {
                cache.put(hash(a, b), super.knows(a, b));
            }
            return cache.get(hash(a, b));
        }

        private long hash(long x, long y) {
            return (x << 32) + y;
        }

        public int findCelebrity(int n) {
            numberOfPeople = n;
            int celebrityCandidate = 0;
            for (int i = 0; i < n; i++) {
                if (knows(celebrityCandidate, i)) {
                    celebrityCandidate = i;
                }
            }
            if (isCelebrity(celebrityCandidate)) {
                return celebrityCandidate;
            }
            return -1;
        }

        private boolean isCelebrity(int i) {
            for (int j = 0; j < numberOfPeople; j++) {
                if (i == j) continue; // 他们认识自己就不用询问。
                if (knows(i, j) || !knows(j, i)) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Relation {
        boolean knows(int a, int b) {
            return false;
        }
    }
}
/*
$277. 搜寻名人
https://leetcode.cn/problems/find-the-celebrity/description/

假设你是一个专业的狗仔，参加了一个 n 人派对，其中每个人被从 0 到 n - 1 标号。在这个派对人群当中可能存在一位 “名人”。所谓 “名人” 的定义是：其他所有 n - 1 个人都认识他/她，而他/她并不认识其他任何人。
现在你想要确认这个 “名人” 是谁，或者确定这里没有 “名人”。而你唯一能做的就是问诸如 “A 你好呀，请问你认不认识 B呀？” 的问题，以确定 A 是否认识 B。你需要在（渐近意义上）尽可能少的问题内来确定这位 “名人” 是谁（或者确定这里没有 “名人”）。
在本题中，你可以使用辅助函数 bool knows(a, b) 获取到 A 是否认识 B。请你来实现一个函数 int findCelebrity(n)。
派对最多只会有一个 “名人” 参加。若 “名人” 存在，请返回他/她的编号；若 “名人” 不存在，请返回 -1。
提示：
n == graph.length == graph[i].length
2 <= n <= 100
graph[i][j] 是 0 或 1
graph[i][i] == 1
进阶：如果允许调用 API knows 的最大次数为 3 * n ，你可以设计一个不超过最大调用次数的解决方案吗？

使用缓存的逻辑推理。
 */