public class Solution831 {
    public String maskPII(String s) {
        int idx = s.indexOf("@");
        if (idx == -1) {
            // 手机号码
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    stringBuilder.append(ch);
                }
            }
            String phoneNum = stringBuilder.toString();
            int len = phoneNum.length();
            String res = "***-***-";
            if (len == 11) {
                res = "+*-***-***-";
            } else if (len == 12) {
                res = "+**-***-***-";
            } else if (len == 13) {
                res = "+***-***-***-";
            }
            return res + phoneNum.substring(len - 4);
        } else {
            // 邮箱
            s = s.toLowerCase(java.util.Locale.ENGLISH);
            return s.charAt(0) + "*****" + s.substring(idx - 1);
        }
    }
}
/*
831. 隐藏个人信息
https://leetcode.cn/problems/masking-personal-information/

第 83 场周赛 T2。

给你一条个人信息字符串 s ，可能表示一个 邮箱地址 ，也可能表示一串 电话号码 。返回按如下规则 隐藏 个人信息后的结果：
电子邮件地址：
一个电子邮件地址由以下部分组成：
- 一个 名字 ，由大小写英文字母组成，后面跟着
- 一个 '@' 字符，后面跟着
- 一个 域名 ，由大小写英文字母和一个位于中间的 '.' 字符组成。'.' 不会是域名的第一个或者最后一个字符。
要想隐藏电子邮件地址中的个人信息：
- 名字 和 域名 部分的大写英文字母应当转换成小写英文字母。
- 名字 中间的字母（即，除第一个和最后一个字母外）必须用 5 个 "*****" 替换。
电话号码：
一个电话号码应当按下述格式组成：
- 电话号码可以由 10-13 位数字组成
- 后 10 位构成 本地号码
- 前面剩下的 0-3 位，构成 国家代码
- 利用 {'+', '-', '(', ')', ' '} 这些 分隔字符 按某种形式对上述数字进行分隔
要想隐藏电话号码中的个人信息：
- 移除所有 分隔字符
- 隐藏个人信息后的电话号码应该遵从这种格式：
  - "***-***-XXXX" 如果国家代码为 0 位数字
  - "+*-***-***-XXXX" 如果国家代码为 1 位数字
  - "+**-***-***-XXXX" 如果国家代码为 2 位数字
  - "+***-***-***-XXXX" 如果国家代码为 3 位数字
- "XXXX" 是最后 4 位 本地号码
提示：
- s 是一个 有效 的电子邮件或者电话号码
- 如果 s 是一个电子邮件：
  - 8 <= s.length <= 40
  - s 是由大小写英文字母，恰好一个 '@' 字符，以及 '.' 字符组成
- 如果 s 是一个电话号码：
  - 10 <= s.length <= 20
  - s 是由数字、空格、字符 '('、')'、'-' 和 '+' 组成

本题有取巧的成分。字符串 S，它可能是一个 邮箱地址 ，也可能是一串 电话号码。
根据这点可以通过 @ 字符进行区分（实际项目中需用正则表达式更精确进行判断）。
字符串中仅保留数字可用 String.replaceAll("\\D+", "");
 */