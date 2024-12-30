import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1472Tests {
    @Test
    public void example1() {
        Solution1472.BrowserHistory browserHistory = new Solution1472.BrowserHistory("leetcode.com");

        // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("google.com");

        // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("facebook.com");

        // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        browserHistory.visit("youtube.com");

        // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        Assertions.assertEquals("facebook.com", browserHistory.back(1));

        // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        Assertions.assertEquals("google.com", browserHistory.back(1));

        // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        Assertions.assertEquals("facebook.com", browserHistory.forward(1));

        // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        browserHistory.visit("linkedin.com");

        // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        Assertions.assertEquals("linkedin.com", browserHistory.forward(2));

        // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        Assertions.assertEquals("google.com", browserHistory.back(2));

        // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
        Assertions.assertEquals("leetcode.com", browserHistory.back(7));
    }
}
