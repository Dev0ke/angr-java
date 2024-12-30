import java.util.ArrayList;
import java.util.List;

public class SolutionP751 {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> resList = new ArrayList<>();
        long start = ip2Long(ip);
        for (int i = 0, mod; i < n; i += mod) {
            mod = 1;
            long cur = start + i;
            while (true) {
                if (i + mod > n || cur % mod != 0) {
                    mod >>= 1;
                    break;
                }
                mod <<= 1;
            }
            // 黑科技
            // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Integer.html#numberOfLeadingZeros(int)
            // floor(log2(x)) = 31 - numberOfLeadingZeros(x)
            // ceil(log2(x)) = 32 - numberOfLeadingZeros(x - 1)
            int floorLog2x = 31 - Integer.numberOfLeadingZeros(mod);
            String res = long2Ip(cur) + "/" + (32 - floorLog2x);
            resList.add(res);
        }
        return resList;
    }

    private long ip2Long(String ip) {
        long res = 0;
        for (String x : ip.split("\\.")) {
            res = (res << 8) + Integer.parseInt(x);
        }
        return res;
    }

    private String long2Ip(long x) {
        return (x >> 24) + "." + (x >> 16) % 256 + "." + (x >> 8) % 256 + "." + (x % 256);
    }
}
/*
$751. IP 到 CIDR
https://leetcode.cn/problems/ip-to-cidr/

IP地址 是一个格式化的 32位 无符号整数，每组 8位 被打印为一个十进制数字和，点字符 '.' 起到了分组的作用。
- 例如，二进制数 00001111 10001000 11111111 01101011 ( 为清晰起见增加了空格)被格式化为IP地址将是 “15.136.255.107” 。
CIDR块 是一种用来表示一组特定IP地址的格式。字符串形式，由基础IP地址、斜杠和前缀长度 k 组成。它所覆盖的地址是所有IP地址的 前 k 位 与基础IP地址相同的IP地址。
- 例如， “123.45.67.89/20” 是一个前缀长度为 20 的 CIDR块。任何二进制表示形式匹配 01111011 00101101 0100xxxx xxxxxxxx 的IP地址，其中 x 可以是 0 或 1 ，都在CIDR块覆盖的集合中。
给你一个起始IP地址 ip 和我们需要覆盖的IP地址数量 n 。你的目标是使用 尽可能少的CIDR块 来 覆盖范围 [ip, ip + n - 1] 内的所有IP地址 。不应该覆盖范围之外的其他IP地址。
返回 包含IP地址范围的 CIDR块 的 最短 列表。如果有多个答案，返回其中 任何 一个 。
提示:
7 <= ip.length <= 15
ip 是一个有效的 IPv4 ，形式为 "a.b.c.d" ，其中 a, b, c,  d 是 [0, 255] 范围内的整数
1 <= n <= 1000
每个隐含地址 ip + x ( x < n) 都是有效的 IPv4 地址

求log2(x)黑科技
相似题目: 1483. 树节点的第 K 个祖先
https://leetcode.cn/problems/kth-ancestor-of-a-tree-node/
 */