import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Solution2197 {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums) {
            stack.push(num);
            int gcd = 2;
            while (stack.size() >= 2 && gcd > 1) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                gcd = getGCD(num1, num2);
                if (gcd > 1) {
                    int lcm = (int) ((long) num1 * num2 / gcd);
                    stack.push(lcm);
                } else {
                    stack.push(num2);
                    stack.push(num1);
                }
            }
        }

        List<Integer> resList = new ArrayList<>(stack);
        Collections.reverse(resList);
        return resList;
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
2197. 替换数组中的非互质数
https://leetcode.cn/problems/replace-non-coprime-numbers-in-array/

第 283 场周赛 T4。

给你一个整数数组 nums 。请你对数组执行下述操作：
1.从 nums 中找出 任意 两个 相邻 的 非互质 数。
2.如果不存在这样的数，终止 这一过程。
3.否则，删除这两个数，并 替换 为它们的 最小公倍数（Least Common Multiple，LCM）。
4.只要还能找出两个相邻的非互质数就继续 重复 这一过程。
返回修改后得到的 最终 数组。可以证明的是，以 任意 顺序替换相邻的非互质数都可以得到相同的结果。
生成的测试用例可以保证最终数组中的值 小于或者等于 10^8 。
两个数字 x 和 y 满足 非互质数 的条件是：GCD(x, y) > 1 ，其中 GCD(x, y) 是 x 和 y 的 最大公约数 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
生成的测试用例可以保证最终数组中的值 小于或者等于 10^8 。

有人相爱，有人夜里开车看海，有人周赛1000人AC的T4做不出来。。。
直接模拟即可。
LCM(num1, num2) = num1 * num2 / GCD(num1, num2)
注意题目说：可以证明的是，以 任意 顺序替换相邻的非互质数都可以得到相同的结果。
因此可以用栈模拟，假设所有的替换都发生在栈顶。
时间复杂度 O(nlogn)
空间复杂度 O(n)
 */