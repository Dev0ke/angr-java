public class Solution2468 {
    public String[] splitMessage(String message, int limit) {
        int len = message.length();

        // 分成 b 份
        int b = 0;
        for (int x = 1; x <= len; x++) {
            if ((len + getXLen(x) + limit - 1) / limit <= x) {
                b = x;
                break;
            }
        }

        String[] res = new String[b];
        int beginIndex = 0;
        for (int i = 0; i < b; i++) {
            String suffix = String.format("<%d/%d>", i + 1, b);
            int endIndex = Math.min(len, beginIndex + limit - suffix.length());
            if(endIndex < beginIndex){
                return new String[0];
            }
            String prefix = message.substring(beginIndex, endIndex);
            beginIndex = endIndex;
            res[i] = prefix + suffix;
        }

        return res;
    }

    private int getXLen(int x) {
        if (x <= 9) {
            // <9/9>
            return x * 5;
        } else if (x <= 99) {
            // <10/99> : <9/99>
            return x * 7 - 9;
        } else if (x <= 999) {
            // <100/999> : <9/999> <99/999>
            return x * 9 - 99 - 9;
        } else if (x <= 9999) {
            // <1000/9999>
            return x * 11 - 999 - 99 - 9;
        }
        return -1;
    }
}
/*
2468. 根据限制分割消息
https://leetcode.cn/problems/split-message-based-on-limit/

第 91 场双周赛 T4。

给你一个字符串 message 和一个正整数 limit 。
你需要根据 limit 将 message 分割 成一个或多个 部分 。每个部分的结尾都是 "<a/b>" ，其中 "b" 用分割出来的总数 替换， "a" 用当前部分所在的编号 替换 ，
编号从 1 到 b 依次编号。除此以外，除了最后一部分长度 小于等于 limit 以外，其他每一部分（包括结尾部分）的长度都应该 等于 limit 。
你需要确保分割后的结果数组，删掉每部分的结尾并 按顺序 连起来后，能够得到 message 。同时，结果数组越短越好。
请你返回 message  分割后得到的结果数组。如果无法按要求分割 message ，返回一个空数组。
提示：
1 <= message.length <= 10^4
message 只包含小写英文字母和 ' ' 。
1 <= limit <= 10^4

枚举。本题答案不具有单调性，所以二分的解法是错误的。
 */