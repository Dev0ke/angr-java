import java.util.ArrayList;
import java.util.List;

public class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int len1 = list1.length;
        int len2 = list2.length;

        int minIdxSum = Integer.MAX_VALUE;
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (list1[i].equals(list2[j])) {
                    if (i + j < minIdxSum) {
                        minIdxSum = i + j;
                        resList.clear();
                        resList.add(list1[i]);
                    } else if (i + j == minIdxSum) {
                        resList.add(list1[i]);
                    }
                }
            }
        }
        return resList.toArray(String[]::new);
    }
}
/*
599. 两个列表的最小索引总和
https://leetcode.cn/problems/minimum-index-sum-of-two-lists/

假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
提示:
1 <= list1.length, list2.length <= 1000
1 <= list1[i].length, list2[i].length <= 30 
list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成。
list1 的所有字符串都是 唯一 的。
list2 中的所有字符串都是 唯一 的。

简单贪心。
 */