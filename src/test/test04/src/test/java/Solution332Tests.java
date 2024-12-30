import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution332Tests {
    private final Solution332 solution332 = new Solution332();

    @Test
    public void example1() {
        List<List<String>> tickets = UtUtils.stringToStringList2("""
                [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
                """);
        List<String> expected = List.of("JFK", "MUC", "LHR", "SFO", "SJC");
        Assertions.assertEquals(expected, solution332.findItinerary(tickets));
    }

    @Test
    public void example2() {
        List<List<String>> tickets = UtUtils.stringToStringList2("""
                [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
                """);
        List<String> expected = List.of("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
        Assertions.assertEquals(expected, solution332.findItinerary(tickets));
    }
}
