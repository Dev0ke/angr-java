import java.util.ArrayList;
import java.util.List;

public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNum(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isSelfDividingNum(int num) {
        int tmp = num;
        while (tmp != 0) {
            int cur = tmp % 10;
            if (cur == 0 || num % cur != 0) {
                return false;
            }
            tmp /= 10;
        }
        return true;
    }
}
/*
728. 自除数
https://leetcode.cn/problems/self-dividing-numbers/

自除数 是指可以被它包含的每一位数整除的数。
- 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
自除数 不允许包含 0 。
给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
提示：
1 <= left <= right <= 10^4

根据题意进行模拟即可。
 */
