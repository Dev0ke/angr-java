public class Solution717 {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;

        int idx = 0;
        while (idx < len - 1) {
            if (bits[idx] == 0) {
                idx++;
            } else {
                idx += 2;
            }
        }
        return idx == len - 1;
    }
}
/*
717. 1 比特与 2 比特字符
https://leetcode.cn/problems/1-bit-and-2-bit-characters/

有两种特殊字符：
- 第一种字符可以用一比特 0 表示
- 第二种字符可以用两比特（10 或 11）表示
给你一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一个一比特字符，则返回 true 。
提示:
1 <= bits.length <= 1000
bits[i] 为 0 或 1

题目保证以 0 结尾，因此，遇到 1 走两步，遇到 0 走一步，判断最终能否走到 len-1 即可。
 */