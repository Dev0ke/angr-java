import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP362Tests {
    @Test
    public void example1() {
        SolutionP362.HitCounter counter = new SolutionP362.HitCounter();

        // 在时刻 1 敲击一次。
        counter.hit(1);

        // 在时刻 2 敲击一次。
        counter.hit(2);

        // 在时刻 3 敲击一次。
        counter.hit(3);

        // 在时刻 4 统计过去 5 分钟内的敲击次数, 函数返回 3 。
        Assertions.assertEquals(3, counter.getHits(4));

        // 在时刻 300 敲击一次。
        counter.hit(300);

        // 在时刻 300 统计过去 5 分钟内的敲击次数，函数返回 4 。
        Assertions.assertEquals(4, counter.getHits(300));

        // 在时刻 301 统计过去 5 分钟内的敲击次数，函数返回 3 。
        Assertions.assertEquals(3, counter.getHits(301));
    }
}
