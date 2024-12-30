import java.util.ArrayList;
import java.util.List;

public class Solution937 {
    public String[] reorderLogFiles(String[] logs) {
        List<Log> list = new ArrayList<>();
        for (String log : logs) {
            list.add(new Log(log));
        }
        list.sort((o1, o2) -> {
            // 所有 字母日志 都排在 数字日志 之前。
            if (o1.isLetter != o2.isLetter) {
                return Integer.compare(o2.isLetter, o1.isLetter);
            }
            if (o1.isLetter == 1) {
                // 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
                if (o1.second.equals(o2.second)) {
                    return o1.first.compareTo(o2.first);
                }
                return o1.second.compareTo(o2.second);
            }
            // 数字日志 应该保留原来的相对顺序。
            return 0;
        });

        return list.stream().map(o -> o.log).toArray(String[]::new);
    }

    private static class Log {
        String log;
        String first;
        String second;
        int isLetter;

        public Log(String log) {
            String[] split = log.split(" ", 2);
            this.log = log;
            this.first = split[0];
            this.second = split[1];
            if (!Character.isDigit(second.charAt(0))) {
                isLetter = 1;
            }
        }
    }
}
/*
937. 重新排列日志文件
https://leetcode.cn/problems/reorder-data-in-log-files/

给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
有两种不同类型的日志：
- 字母日志：除标识符之外，所有字均由小写字母组成
- 数字日志：除标识符之外，所有字均由数字组成
请按下述规则将日志重新排序：
- 所有 字母日志 都排在 数字日志 之前。
- 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
- 数字日志 应该保留原来的相对顺序。
返回日志的最终顺序。
提示：
1 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] 中，字与字之间都用 单个 空格分隔
题目数据保证 logs[i] 都有一个标识符，并且在标识符之后至少存在一个字

自定义排序
时间复杂度 O(nlogn)
空间复杂度 O(logn)
 */