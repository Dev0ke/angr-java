import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1;
        int carry = 0;
        List<Integer> ans = new ArrayList<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = carry;
            if (i >= 0) x += arr1[i];
            if (j >= 0) x += arr2[j];

            if (x >= 2) {
                ans.add(x - 2);
                carry = -1;
            } else if (x >= 0) {
                ans.add(x);
                carry = 0;
            } else {
                ans.add(1);
                carry = 1;
            }
            i--;
            j--;
        }

        // 移除后缀 0
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
1073. 负二进制数相加
https://leetcode.cn/problems/adding-two-negabinary-numbers/description/

给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。
数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，arr = [1,1,0,1] 表示数字 (-2)^3 + (-2)^2 + (-2)^0 = -3。数组形式 中的数字 arr 也同样不含前导零：即 arr == [0] 或 arr[0] == 1。
返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。
提示：
1 <= arr1.length, arr2.length <= 1000
arr1[i] 和 arr2[i] 都是 0 或 1
arr1 和 arr2 都没有前导0

模拟。
https://leetcode.cn/problems/adding-two-negabinary-numbers/solutions/2273578/fu-er-jin-zhi-shu-xiang-jia-by-leetcode-nwktq/
相似题目: 1017. 负二进制转换
https://leetcode.cn/problems/convert-to-base-2/description/
 */