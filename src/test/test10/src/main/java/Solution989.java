import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        // 将 num 与 k 转成倒序 List
        List<Integer> numList = changeArr2List(num);
        List<Integer> kList = changeInt2List(k);

        // 同步长指针
        int idx = 0;
        // 进位
        int carry = 0;
        List<Integer> ansList = new ArrayList<>();
        while (idx < numList.size() && idx < kList.size()) {
            int sum = numList.get(idx) + kList.get(idx) + carry;
            // sum >= 10 进位 1
            carry = (sum > 9) ? 1 : 0;
            ansList.add(sum % 10);
            idx++;
        }

        // 两个 List 不等长的情况
        while (idx < numList.size()) {
            int sum = numList.get(idx) + carry;
            carry = (sum > 9) ? 1 : 0;
            ansList.add(sum % 10);
            idx++;
        }
        while (idx < kList.size()) {
            int sum = kList.get(idx) + carry;
            carry = (sum > 9) ? 1 : 0;
            ansList.add(sum % 10);
            idx++;
        }

        // 进位为 1 的情况
        if (carry == 1) {
            ansList.add(1);
        }

        // 翻转 List 返回
        Collections.reverse(ansList);
        return ansList;
    }

    private List<Integer> changeArr2List(int[] num) {
        List<Integer> listNum = Arrays.stream(num).boxed().collect(Collectors.toList());
        Collections.reverse(listNum);
        return listNum;
    }

    private List<Integer> changeInt2List(int k) {
        List<Integer> list = new ArrayList<>();
        while (k > 0) {
            int lastNum = k % 10;
            list.add(lastNum);
            k /= 10;
        }
        return list;
    }
}
/*
989. 数组形式的整数加法
https://leetcode.cn/problems/add-to-array-form-of-integer/

第 123 场周赛 T1。

整数的 数组形式  num 是按照从左到右的顺序表示其数字的数组。
- 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。
给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。
提示：
1 <= num.length <= 10^4
0 <= num[i] <= 9
num 不包含任何前导零，除了零本身
1 <= k <= 10^4

相似题目: 2. 两数相加
https://leetcode.cn/problems/add-two-numbers/
 */
