import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1257Tests {
    private final SolutionP1257 solutionP1257 = new SolutionP1257();

    @Test
    public void example1() {
        List<List<String>> regions = UtUtils.stringToStringList2("""
                [["Earth","North America","South America"],
                ["North America","United States","Canada"],
                ["United States","New York","Boston"],
                ["Canada","Ontario","Quebec"],
                ["South America","Brazil"]]
                """);
        String region1 = "Quebec";
        String region2 = "New York";
        String expected = "North America";
        Assertions.assertEquals(expected, solutionP1257.findSmallestRegion(regions, region1, region2));
    }
}