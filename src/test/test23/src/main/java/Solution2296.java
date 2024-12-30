public class Solution2296 {
    static class TextEditor {
        StringBuilder sb;
        // 光标
        private int cursor;

        public TextEditor() {
            this.sb = new StringBuilder();
            this.cursor = 0;
        }

        public void addText(String text) {
            sb.insert(cursor, text);
            // 光标移动
            cursor += text.length();
        }

        public int deleteText(int k) {
            // 可以删除的字符不会超过光标左侧长度
            int deleteLen = Math.min(k, cursor);
            sb.delete(cursor - deleteLen, cursor);
            // 光标移动
            cursor -= deleteLen;
            return deleteLen;
        }

        public String cursorLeft(int k) {
            // 光标移动
            cursor = Math.max(0, cursor - k);
            // 返回长度
            int echoLen = Math.min(10, cursor);
            return sb.substring(cursor - echoLen, cursor);
        }

        public String cursorRight(int k) {
            // 光标移动
            cursor = Math.min(sb.length(), cursor + k);
            // 返回长度
            int echoLen = Math.min(10, cursor);
            return sb.substring(cursor - echoLen, cursor);
        }
    }
}
/*
2296. 设计一个文本编辑器
https://leetcode.cn/problems/design-a-text-editor/

第 296 场周赛 T4。

请你设计一个带光标的文本编辑器，它可以实现以下功能：
- 添加：在光标所在处添加文本。
- 删除：在光标所在处删除文本（模拟键盘的删除键）。
- 移动：将光标往左或者往右移动。
当删除文本时，只有光标左边的字符会被删除。光标会留在文本内，也就是说任意时候 0 <= cursor.position <= currentText.length 都成立。
请你实现 TextEditor 类：
- TextEditor() 用空文本初始化对象。
- void addText(string text) 将 text 添加到光标所在位置。添加完后光标在 text 的右边。
- int deleteText(int k) 删除光标左边 k 个字符。返回实际删除的字符数目。
- string cursorLeft(int k) 将光标向左移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
- string cursorRight(int k) 将光标向右移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
提示：
1 <= text.length, k <= 40
text 只含有小写英文字母。
调用 addText ，deleteText ，cursorLeft 和 cursorRight 的 总 次数不超过 2 * 10^4 次。

StringBuilder 暴力模拟。
注意由于光标的存在，`addText` 操作时应该用 `StringBuilder#insert()` 而不是 `StringBuilder#append()`。
 */