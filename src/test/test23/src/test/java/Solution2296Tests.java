import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2296Tests {
    @Test
    public void example1() {
        // 当前 text 为 "|" 。（'|' 字符表示光标）
        Solution2296.TextEditor textEditor = new Solution2296.TextEditor();

        // 当前文本为 "leetcode|" 。
        textEditor.addText("leetcode");

        // 返回 4
        // 当前文本为 "leet|" 。
        // 删除了 4 个字符。
        Assertions.assertEquals(4, textEditor.deleteText(4));

        // 当前文本为 "leetpractice|" 。
        textEditor.addText("practice");

        // 返回 "etpractice"
        // 当前文本为 "leetpractice|".
        // 光标无法移动到文本以外，所以无法移动。
        // "etpractice" 是光标左边的 10 个字符。
        Assertions.assertEquals("etpractice", textEditor.cursorRight(3));

        // 返回 "leet"
        // 当前文本为 "leet|practice" 。
        // "leet" 是光标左边的 min(10, 4) = 4 个字符。
        Assertions.assertEquals("leet", textEditor.cursorLeft(8));

        // 返回 4
        // 当前文本为 "|practice" 。
        // 只有 4 个字符被删除了。
        Assertions.assertEquals(4, textEditor.deleteText(10));

        // 返回 ""
        // 当前文本为 "|practice" 。
        // 光标无法移动到文本以外，所以无法移动。
        // "" 是光标左边的 min(10, 0) = 0 个字符。
        Assertions.assertEquals("", textEditor.cursorLeft(2));

        // 返回 "practi"
        // 当前文本为 "practi|ce" 。
        // "practi" 是光标左边的 min(10, 6) = 6 个字符。
        Assertions.assertEquals("practi", textEditor.cursorRight(6));
    }
}
