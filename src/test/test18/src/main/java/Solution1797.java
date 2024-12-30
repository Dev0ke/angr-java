import java.util.HashMap;
import java.util.Map;

public class Solution1797 {
    static class AuthenticationManager {
        private final int timeToLive;
        private final Map<String, Integer> hashMap;

        public AuthenticationManager(int timeToLive) {
            this.hashMap = new HashMap<>();
            this.timeToLive = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            hashMap.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            // 将给定 tokenId 且 未过期 的验证码在 currentTime 时刻更新。
            // 如果给定 tokenId 对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
            if (hashMap.containsKey(tokenId)) {
                if (hashMap.get(tokenId) > currentTime) {
                    hashMap.put(tokenId, currentTime + timeToLive);
                }
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int cnt = 0;
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() > currentTime) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
/*
1797. 设计一个验证系统
https://leetcode.cn/problems/design-authentication-manager/

你需要设计一个包含验证码的验证系统。每一次验证中，用户会收到一个新的验证码，这个验证码在 currentTime 时刻之后 timeToLive 秒过期。
如果验证码被更新了，那么它会在 currentTime （可能与之前的 currentTime 不同）时刻延长 timeToLive 秒。
请你实现 AuthenticationManager 类：
- AuthenticationManager(int timeToLive) 构造 AuthenticationManager 并设置 timeToLive 参数。
- generate(string tokenId, int currentTime) 给定 tokenId ，在当前时间 currentTime 生成一个新的验证码。
- renew(string tokenId, int currentTime) 将给定 tokenId 且 未过期 的验证码在 currentTime 时刻更新。
如果给定 tokenId 对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
- countUnexpiredTokens(int currentTime) 请返回在给定 currentTime 时刻，未过期 的验证码数目。
如果一个验证码在时刻 t 过期，且另一个操作恰好在时刻 t 发生（renew 或者 countUnexpiredTokens 操作），过期事件 优先于 其他操作。
提示：
1 <= timeToLive <= 10^8
1 <= currentTime <= 10^8
1 <= tokenId.length <= 5
tokenId 只包含小写英文字母。
所有 generate 函数的调用都会包含独一无二的 tokenId 值。
所有函数调用中，currentTime 的值 严格递增 。
所有函数的调用次数总共不超过 2000 次。

模拟，咋眼一看，以为类似 redis ttl 的机制。本题 tokenId 过期后，系统的 key 并不会消失。
 */