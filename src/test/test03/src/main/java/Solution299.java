public class Solution299 {
    public String getHint(String secret, String guess) {
        // secret 和 guess 仅由数字组成
        int[] secretNum = new int[10];
        int[] guessNum = new int[10];

        // 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
        int x = 0;
        // 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
        int y = 0;
        for (int i = 0; i < secret.length(); i++) {
            char ch1 = secret.charAt(i);
            char ch2 = guess.charAt(i);
            if (ch1 == ch2) {
                x++;
            }
            secretNum[ch1 - '0']++;
            guessNum[ch2 - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            y += Math.min(secretNum[i], guessNum[i]);
        }
        y = y - x;
        // "xAyB"
        return x + "A" + y + "B";
    }
}
/*
299. 猜数字游戏
https://leetcode.cn/problems/bulls-and-cows/

你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
- 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
- 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
请注意秘密数字和朋友猜测的数字都可能含有重复数字。
提示：
1 <= secret.length, guess.length <= 1000
secret.length == guess.length
secret 和 guess 仅由数字组成

遍历
时间复杂度 O(n)
空间复杂度 O(1)
 */