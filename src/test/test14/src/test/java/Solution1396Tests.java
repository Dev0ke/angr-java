import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1396Tests {
    @Test
    public void example1() {
        Solution1396.UndergroundSystem undergroundSystem = new Solution1396.UndergroundSystem();

        undergroundSystem.checkIn(45, "Leyton", 3);

        undergroundSystem.checkIn(32, "Paradise", 8);

        undergroundSystem.checkIn(27, "Leyton", 10);

        // 乘客 45 "Leyton" -> "Waterloo" ，用时 15-3 = 12
        undergroundSystem.checkOut(45, "Waterloo", 15);

        // 乘客 27 "Leyton" -> "Waterloo" ，用时 20-10 = 10
        undergroundSystem.checkOut(27, "Waterloo", 20);

        // 乘客 32 "Paradise" -> "Cambridge" ，用时 22-8 = 14
        undergroundSystem.checkOut(32, "Cambridge", 22);

        // 返回 14.00000 。只有一个 "Paradise" -> "Cambridge" 的行程，(14) / 1 = 14
        Assertions.assertEquals(14.0, undergroundSystem.getAverageTime("Paradise", "Cambridge"));

        // 返回 11.00000 。有两个 "Leyton" -> "Waterloo" 的行程，(10 + 12) / 2 = 11
        Assertions.assertEquals(11.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"));

        undergroundSystem.checkIn(10, "Leyton", 24);

        // 返回 11.00000
        Assertions.assertEquals(11.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"));

        // 乘客 10 "Leyton" -> "Waterloo" ，用时 38-24 = 14
        undergroundSystem.checkOut(10, "Waterloo", 38);

        // 返回 12.00000 。有三个 "Leyton" -> "Waterloo" 的行程，(10 + 12 + 14) / 3 = 12
        Assertions.assertEquals(12.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"));
    }

    @Test
    public void example2() {
        Solution1396.UndergroundSystem undergroundSystem = new Solution1396.UndergroundSystem();

        undergroundSystem.checkIn(10, "Leyton", 3);

        // 乘客 10 "Leyton" -> "Paradise" ，用时 8-3 = 5
        undergroundSystem.checkOut(10, "Paradise", 8);

        // 返回 5.00000 ，(5) / 1 = 5
        Assertions.assertEquals(5.0, undergroundSystem.getAverageTime("Leyton", "Paradise"));

        undergroundSystem.checkIn(5, "Leyton", 10);

        // 乘客 5 "Leyton" -> "Paradise" ，用时 16-10 = 6
        undergroundSystem.checkOut(5, "Paradise", 16);

        // 返回 5.50000 ，(5 + 6) / 2 = 5.5
        Assertions.assertEquals(5.5, undergroundSystem.getAverageTime("Leyton", "Paradise"));

        undergroundSystem.checkIn(2, "Leyton", 21);

        // 乘客 2 "Leyton" -> "Paradise" ，用时 30-21 = 9
        undergroundSystem.checkOut(2, "Paradise", 30);

        // 返回 6.66667 ，(5 + 6 + 9) / 3 = 6.66667
        Assertions.assertEquals(6.66667, undergroundSystem.getAverageTime("Leyton", "Paradise"), 1e-5);
    }
}
