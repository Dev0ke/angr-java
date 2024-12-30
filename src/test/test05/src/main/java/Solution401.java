import java.util.ArrayList;
import java.util.List;

public class Solution401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> resList = new ArrayList<>();

        // 状态压缩 2^10 = 1024
        for (int state = 0; state < (1 << 10); state++) {
            if (Integer.bitCount(state) == turnedOn) {
                // 时
                int hours = 0;
                for (int k = 0; k < 4; k++) {
                    if (((state >> k) & 1) == 1) {
                        hours += (8 >> k);
                    }
                }

                // 分
                int minutes = 0;
                for (int k = 4; k < 10; k++) {
                    if (((state >> k) & 1) == 1) {
                        minutes += (32 >> (k - 4));
                    }
                }

                if (hours <= 11 && minutes <= 59) {
                    String time = hours + ":" + format(minutes);
                    resList.add(time);
                }
            }
        }
        return resList;
    }

    private String format(int num) {
        if (num < 10) {
            return "0" + num;
        } else {
            return "" + num;
        }
    }
}
/*
401. 二进制手表
https://leetcode.cn/problems/binary-watch/

二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
- 例如，下面的二进制手表读取 "3:25" 。
给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
小时不会以零开头：
- 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
分钟必须由两位数组成，可能会以零开头：
- 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
提示：
0 <= turnedOn <= 10

状态压缩。
 */