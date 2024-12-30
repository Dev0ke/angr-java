import java.util.HashMap;
import java.util.Map;

public class SolutionP1165 {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            idxMap.put(keyboard.charAt(i), i);
        }

        int res = 0;
        char pre = keyboard.charAt(0);
        for (char ch : word.toCharArray()) {
            res += Math.abs(idxMap.get(ch) - idxMap.get(pre));
            pre = ch;
        }
        return res;
    }
}
/*
$1165. 单行键盘
https://leetcode.cn/problems/single-row-keyboard/

我们定制了一款特殊的键盘，所有的键都 排列在一行上 。
给定一个长度为 26 的字符串 keyboard ，来表示键盘的布局(索引从 0 到 25 )。一开始，你的手指在索引 0 处。要输入一个字符，你必须把你的手指移动到所需字符的索引处。手指从索引 i 移动到索引 j 所需要的时间是 |i - j|。
您需要输入一个字符串 word 。写一个函数来计算用一个手指输入需要多少时间。
提示：
keyboard.length == 26
keyboard 按某种特定顺序排列，并包含每个小写英文字母一次。
1 <= word.length <= 104
word[i] 为小写英文字母

HashMap模拟
 */