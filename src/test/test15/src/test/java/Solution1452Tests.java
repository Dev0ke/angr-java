import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1452Tests {
    private final Solution1452 solution1452 = new Solution1452();

    @Test
    public void example1() {
        List<List<String>> favoriteCompanies = UtUtils.stringToStringList2("""
                [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
                """);
        List<Integer> expected = List.of(0, 1, 4);
        Assertions.assertEquals(expected, solution1452.peopleIndexes(favoriteCompanies));
    }

    @Test
    public void example2() {
        List<List<String>> favoriteCompanies = UtUtils.stringToStringList2("""
                [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
                """);
        List<Integer> expected = List.of(0, 1);
        Assertions.assertEquals(expected, solution1452.peopleIndexes(favoriteCompanies));
    }

    @Test
    public void example3() {
        List<List<String>> favoriteCompanies = UtUtils.stringToStringList2("""
                [["leetcode"],["google"],["facebook"],["amazon"]]
                """);
        List<Integer> expected = List.of(0, 1, 2, 3);
        Assertions.assertEquals(expected, solution1452.peopleIndexes(favoriteCompanies));
    }
}