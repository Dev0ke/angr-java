import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1418Tests {
    private final Solution1418 solution1418 = new Solution1418();

    @Test
    public void example1() {
        List<List<String>> orders = UtUtils.stringToStringList2("""
                [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
                """);
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
                """);
        Assertions.assertEquals(expected, solution1418.displayTable(orders));
    }

    @Test
    public void example2() {
        List<List<String>> orders = UtUtils.stringToStringList2("""
                [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
                """);
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
                """);
        Assertions.assertEquals(expected, solution1418.displayTable(orders));
    }

    @Test
    public void example3() {
        List<List<String>> orders = UtUtils.stringToStringList2("""
                [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
                """);
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
                """);
        Assertions.assertEquals(expected, solution1418.displayTable(orders));
    }
}
