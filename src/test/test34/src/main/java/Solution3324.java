import java.util.ArrayList;
import java.util.List;

public class Solution3324 {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            sb.append("a");
            ans.add(sb.toString());
            while (sb.charAt(i) != target.charAt(i)) {
                char old_ch = sb.charAt(i);
                char new_ch = (char) (old_ch + 1);
                sb.deleteCharAt(i);
                sb.append(new_ch);
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}
/*
3324. 出现在屏幕上的字符串序列
https://leetcode.cn/problems/find-the-sequence-of-strings-appeared-on-the-screen/description/

第 420 场周赛 T1。

给你一个字符串 target。
Alice 将会使用一种特殊的键盘在她的电脑上输入 target，这个键盘 只有两个 按键：
- 按键 1：在屏幕上的字符串后追加字符 'a'。
- 按键 2：将屏幕上字符串的 最后一个 字符更改为英文字母表中的 下一个 字符。例如，'c' 变为 'd'，'z' 变为 'a'。
注意，最初屏幕上是一个空字符串 ""，所以她 只能 按按键 1。
请你考虑按键次数 最少 的情况，按字符串出现顺序，返回 Alice 输入 target 时屏幕上出现的所有字符串列表。
提示：
1 <= target.length <= 400
target 仅由小写英文字母组成。

模拟。
 */