import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1472 {
    static class BrowserHistory {
        private Deque<String> forwardStack = new ArrayDeque<>();
        private final Deque<String> backStack = new ArrayDeque<>();

        public BrowserHistory(String homepage) {
            backStack.push(homepage);
        }

        public void visit(String url) {
            backStack.push(url);
            forwardStack = new ArrayDeque<>();
        }

        public String back(int steps) {
            for (int i = 0; i < steps && backStack.size() > 1; i++) {
                forwardStack.push(backStack.pop());
            }
            return backStack.peek();
        }

        public String forward(int steps) {
            for (int i = 0; i < steps && !forwardStack.isEmpty(); i++) {
                backStack.push(forwardStack.pop());
            }
            return backStack.peek();
        }
    }
}
/*
1472. 设计浏览器历史记录
https://leetcode.cn/problems/design-browser-history/

你有一个只支持单个标签页的 浏览器 ，最开始你浏览的网页是 homepage ，你可以访问其他的网站 url ，也可以在浏览历史中后退 steps 步或前进 steps 步。
请你实现 BrowserHistory 类：
- BrowserHistory(string homepage) ，用 homepage 初始化浏览器类。
- void visit(string url) 从当前页跳转访问 url 对应的页面  。执行此操作会把浏览历史前进的记录全部删除。
- string back(int steps) 在浏览历史中后退 steps 步。如果你只能在浏览历史中后退至多 x 步且 steps > x ，那么你只后退 x 步。请返回后退 至多 steps 步以后的 url 。
- string forward(int steps) 在浏览历史中前进 steps 步。如果你只能在浏览历史中前进至多 x 步且 steps > x ，那么你只前进 x 步。请返回前进 至多 steps步以后的 url 。
提示：
1 <= homepage.length <= 20
1 <= url.length <= 20
1 <= steps <= 100
homepage 和 url 都只包含 '.' 或者小写英文字母。
最多调用 5000 次 visit， back 和 forward 函数。

两个栈互相倒
 */