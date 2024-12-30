import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SolutionP379 {
    static class PhoneDirectory {
        private final PriorityQueue<Integer> free;
        private final Set<Integer> usedSet;

        public PhoneDirectory(int maxNumbers) {
            free = new PriorityQueue<>();
            for (int i = 0; i < maxNumbers; i++) {
                free.add(i);
            }
            usedSet = new HashSet<>();
        }

        public int get() {
            if (free.isEmpty()) {
                return -1;
            }
            int phone = free.remove();
            usedSet.add(phone);
            return phone;
        }

        public boolean check(int number) {
            return !usedSet.contains(number);
        }

        public void release(int number) {
            if (usedSet.contains(number)) {
                usedSet.remove(number);
                free.add(number);
            }
        }
    }
}
/*
$379. 电话目录管理系统
https://leetcode.cn/problems/design-phone-directory/

设计一个电话目录管理系统，让它支持以下功能：
1. get: 分配给用户一个未被使用的电话号码，获取失败请返回 -1
2. check: 检查指定的电话号码是否被使用
3. release: 释放掉一个电话号码，使其能够重新被分配
提示：
1 <= maxNumbers <= 10^4
0 <= number < maxNumbers
调用方法的总数处于区间 [0 - 20000] 之内

模拟
坑：release 有可能是未分配的电话号！！！
 */