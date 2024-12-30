import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    private String s;

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        List<String> resList = new ArrayList<>();
        helper(0, 0, "", "", resList);
        return resList;
    }

    private void helper(int pos, int segI, String seg, String ip, List<String> resList) {
        if (pos == s.length() && segI == 3 && isValidSeg(seg)) {
            resList.add(ip + seg);
        } else if (pos < s.length() && segI <= 3) {
            char ch = s.charAt(pos);
            if (isValidSeg(seg + ch)) {
                helper(pos + 1, segI, seg + ch, ip, resList);
            }
            if (seg.length() > 0 && segI < 3) {
                helper(pos + 1, segI + 1, "" + ch, ip + seg + ".", resList);
            }
        }
    }

    private boolean isValidSeg(String seg) {
        return Integer.parseInt(seg) <= 255 && (seg.equals("0") || seg.charAt(0) != '0');
    }
}
/*
93. 复原 IP 地址
https://leetcode.cn/problems/restore-ip-addresses/

有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
- 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
提示：
1 <= s.length <= 20
s 仅由数字组成

回溯法。
 */