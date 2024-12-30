public class Solution2075 {
    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        int cols = len / rows;
        // 还原矩阵
        char[][] chars = new char[rows][cols];
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                chars[i][j] = encodedText.charAt(idx++);
            }
        }
        // 还原 originalText
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (j + i < cols) {
                    stringBuilder.append(chars[j][j + i]);
                }
            }
        }
        // 移除 尾随空格
        return stringBuilder.toString().stripTrailing();
    }
}
/*
2075. 解码斜向换位密码
https://leetcode.cn/problems/decode-the-slanted-ciphertext/

第 267 场周赛 T3。

字符串 originalText 使用 斜向换位密码 ，经由 行数固定 为 rows 的矩阵辅助，加密得到一个字符串 encodedText 。
originalText 先按从左上到右下的方式放置到矩阵中。
先填充蓝色单元格，接着是红色单元格，然后是黄色单元格，以此类推，直到到达 originalText 末尾。箭头指示顺序即为单元格填充顺序。
所有空单元格用 ' ' 进行填充。矩阵的列数需满足：用 originalText 填充之后，最右侧列 不为空 。
接着按行将字符附加到矩阵中，构造 encodedText 。
先把蓝色单元格中的字符附加到 encodedText 中，接着是红色单元格，最后是黄色单元格。箭头指示单元格访问顺序。
例如，如果 originalText = "cipher" 且 rows = 3 ，那么我们可以按下述方法将其编码：
蓝色箭头标识 originalText 是如何放入矩阵中的，红色箭头标识形成 encodedText 的顺序。在上述例子中，encodedText = "ch   ie   pr" 。
给你编码后的字符串 encodedText 和矩阵的行数 rows ，返回源字符串 originalText 。
注意：originalText 不 含任何尾随空格 ' ' 。生成的测试用例满足 仅存在一个 可能的 originalText 。
提示：
0 <= encodedText.length <= 10^6
encodedText 仅由小写英文字母和 ' ' 组成
encodedText 是对某个 不含 尾随空格的 originalText 的一个有效编码
1 <= rows <= 1000
生成的测试用例满足 仅存在一个 可能的 originalText

模拟。矩阵变换。
 */