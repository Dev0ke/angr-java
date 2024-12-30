import java.util.Random;

public class Solution470 {
    static class Solution extends SolBase {
        public int rand10() {
            int a, b, idx;
            while (true) {
                a = rand7();
                b = rand7();
                idx = b + (a - 1) * 7;
                if (idx <= 40) {
                    return 1 + (idx - 1) % 10;
                }
                a = idx - 40;
                b = rand7();
                // get uniform dist from 1 - 63
                idx = b + (a - 1) * 7;
                if (idx <= 60) {
                    return 1 + (idx - 1) % 10;
                }
                a = idx - 60;
                b = rand7();
                // get uniform dist from 1 - 21
                idx = b + (a - 1) * 7;
                if (idx <= 20) {
                    return 1 + (idx - 1) % 10;
                }
            }
        }
    }

    static class SolBase {
        Random random = new Random();

        public int rand7() {
            return random.nextInt(7);
        }
    }
}
/*
470. 用 Rand7() 实现 Rand10()
https://leetcode.cn/problems/implement-rand10-using-rand7/description/

给定方法 rand7 可生成 [1,7] 范围内的均匀随机整数，试写一个方法 rand10 生成 [1,10] 范围内的均匀随机整数。
你只能调用 rand7() 且不能调用其他方法。请不要使用系统的 Math.random() 方法。
每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
提示:
1 <= n <= 10^5
进阶:
rand7()调用次数的 期望值 是多少 ?
你能否尽量少调用 rand7() ?

拒绝采样
 */