import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionP359 {
    static class Logger {
        Deque<Log> msgQueue;
        Set<String> msgSet;

        public Logger() {
            msgQueue = new ArrayDeque<>();
            msgSet = new HashSet<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            // clean up.
            while (!msgQueue.isEmpty()) {
                Log head = msgQueue.getFirst();
                if (timestamp - head.t >= 10) {
                    msgQueue.removeFirst();
                    msgSet.remove(head.msg);
                } else {
                    break;
                }
            }

            if (msgSet.contains(message)) return false;
            Log newLog = new Log(timestamp, message);
            msgQueue.addLast(newLog);
            msgSet.add(message);
            return true;
        }

        static class Log {
            int t;
            String msg;

            public Log(int t, String msg) {
                this.t = t;
                this.msg = msg;
            }
        }
    }
}
/*
$359. 日志速率限制器
https://leetcode.cn/problems/logger-rate-limiter/description/

请你设计一个日志系统，可以流式接收消息以及它的时间戳。每条 不重复 的消息最多只能每 10 秒打印一次。也就是说，如果在时间戳 t 打印某条消息，那么相同内容的消息直到时间戳变为 t + 10 之前都不会被打印。
所有消息都按时间顺序发送。多条消息可能到达同一时间戳。
实现 Logger 类：
- Logger() 初始化 logger 对象
- bool shouldPrintMessage(int timestamp, string message) 如果这条消息 message 在给定的时间戳 timestamp 应该被打印出来，则返回 true ，否则请返回 false 。
提示：
0 <= timestamp <= 10^9
每个 timestamp 都将按非递减顺序（时间顺序）传递
1 <= message.length <= 30
最多调用 10^4 次 shouldPrintMessage 方法

队列 + 集合。
 */