import java.util.HashMap;
import java.util.Map;

public class Solution2227 {
    static class Encrypter {
        private final Map<Character, String> char2StringMap;
        private final Map<String, Integer> encryptDictionaryMap;

        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            char2StringMap = new HashMap<>();
            for (int i = 0; i < keys.length; i++) {
                char2StringMap.put(keys[i], values[i]);
            }

            encryptDictionaryMap = new HashMap<>();
            for (String s : dictionary) {
                String encryptStr = encrypt(s);
                encryptDictionaryMap.put(encryptStr, encryptDictionaryMap.getOrDefault(encryptStr, 0) + 1);
            }
        }

        public String encrypt(String word1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : word1.toCharArray()) {
                stringBuilder.append(char2StringMap.get(ch));
            }
            return stringBuilder.toString();
        }

        public int decrypt(String word2) {
            return encryptDictionaryMap.getOrDefault(word2, 0);
        }
    }
}
/*
2227. 加密解密字符串
https://leetcode.cn/problems/encrypt-and-decrypt-strings/

第 287 场周赛 T4。

给你一个字符数组 keys ，由若干 互不相同 的字符组成。还有一个字符串数组 values ，内含若干长度为 2 的字符串。
另给你一个字符串数组 dictionary ，包含解密后所有允许的原字符串。请你设计并实现一个支持加密及解密下标从 0 开始字符串的数据结构。
字符串 加密 按下述步骤进行：
1.对字符串中的每个字符 c ，先从 keys 中找出满足 keys[i] == c 的下标 i 。
2.在字符串中，用 values[i] 替换字符 c 。
字符串 解密 按下述步骤进行：
1.将字符串每相邻 2 个字符划分为一个子字符串，对于每个子字符串 s ，找出满足 values[i] == s 的一个下标 i 。
2.如果存在多个有效的 i ，从中选择 任意 一个。这意味着一个字符串解密可能得到多个解密字符串。
在字符串中，用 keys[i] 替换 s 。
实现 Encrypter 类：
- Encrypter(char[] keys, String[] values, String[] dictionary) 用 keys、values 和 dictionary 初始化 Encrypter 类。
- String encrypt(String word1) 按上述加密过程完成对 word1 的加密，并返回加密后的字符串。
- int decrypt(String word2) 统计并返回可以由 word2 解密得到且出现在 dictionary 中的字符串数目。
提示：
1 <= keys.length == values.length <= 26
values[i].length == 2
1 <= dictionary.length <= 100
1 <= dictionary[i].length <= 100
所有 keys[i] 和 dictionary[i] 互不相同
1 <= word1.length <= 2000
1 <= word2.length <= 200
所有 word1[i] 都出现在 keys 中
word2.length 是偶数
keys、values[i]、dictionary[i]、word1 和 word2 只含小写英文字母
至多调用 encrypt 和 decrypt 总计 200 次

逆向思维。
对于 encrypt 方法，本质上是 mapping，将 char 映射成 String，可以使用 HashMap 进行优化。
对于 decrypt 方法，正向思维是用 dfs 找出所给 "密文" 的全部 "原文"，然而会 MLE 或者 TLE
逆向思维是将 dictionary 所有字符串加密，然后判断 word2 是否为 dictionary 加密后的字符串
失败的提交: https://leetcode.cn/submissions/detail/294041036/
 */