import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP635Tests {
    @Test
    public void example1() {
        SolutionP635.LogSystem logSystem = new SolutionP635.LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");

        // 返回 [3,2,1]，返回从 2016 年到 2017 年所有的日志。
        Assertions.assertEquals(List.of(3, 2, 1), logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"));

        // 返回 [2,1]，返回从 Jan. 1, 2016 01:XX:XX 到 Jan. 1, 2017 23:XX:XX 之间的所有日志
        // 不返回日志 3 因为记录时间 Jan. 1, 2016 00:00:00 超过范围的起始时间
        Assertions.assertEquals(List.of(2, 1), logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour"));
    }
}
