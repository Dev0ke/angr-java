import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1268Tests {
    private final Solution1268 solution1268 = new Solution1268();

    @Test
    public void example1() {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["mobile","moneypot","monitor"],
                ["mobile","moneypot","monitor"],
                ["mouse","mousepad"],
                ["mouse","mousepad"],
                ["mouse","mousepad"]]
                """);
        Assertions.assertEquals(expected, solution1268.suggestedProducts(products, searchWord));
    }

    @Test
    public void example2() {
        String[] products = {"havana"};
        String searchWord = "havana";
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
                """);
        Assertions.assertEquals(expected, solution1268.suggestedProducts(products, searchWord));
    }

    @Test
    public void example3() {
        String[] products = {"bags", "baggage", "banner", "box", "cloths"};
        String searchWord = "bags";
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
                """);
        Assertions.assertEquals(expected, solution1268.suggestedProducts(products, searchWord));
    }

    @Test
    public void example4() {
        String[] products = {"havana"};
        String searchWord = "tatiana";
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [[],[],[],[],[],[],[]]
                """);
        Assertions.assertEquals(expected, solution1268.suggestedProducts(products, searchWord));
    }
}