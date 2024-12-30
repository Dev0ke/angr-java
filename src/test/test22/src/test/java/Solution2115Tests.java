import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2115Tests {
    private final Solution2115 solution2115 = new Solution2115();

    @Test
    public void example1() {
        String[] recipes = {"bread"};
        List<List<String>> ingredients = UtUtils.stringToStringList2("""
                [["yeast","flour"]]
                """);
        String[] supplies = {"yeast", "flour", "corn"};
        List<String> expected = Arrays.asList("bread");
        List<String> actual = solution2115.findAllRecipes(recipes, ingredients, supplies);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String[] recipes = {"bread", "sandwich"};
        List<List<String>> ingredients = UtUtils.stringToStringList2("""
                [["yeast","flour"],["bread","meat"]]
                """);
        String[] supplies = {"yeast", "flour", "meat"};
        List<String> expected = Arrays.asList("bread", "sandwich");
        List<String> actual = solution2115.findAllRecipes(recipes, ingredients, supplies);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        String[] recipes = {"bread", "sandwich", "burger"};
        List<List<String>> ingredients = UtUtils.stringToStringList2("""
                [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]]
                """);
        String[] supplies = {"yeast", "flour", "meat"};
        List<String> expected = Arrays.asList("bread", "sandwich", "burger");
        List<String> actual = solution2115.findAllRecipes(recipes, ingredients, supplies);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        String[] recipes = {"bread"};
        List<List<String>> ingredients = UtUtils.stringToStringList2("""
                [["yeast","flour"]]
                """);
        String[] supplies = {"yeast"};
        List<String> expected = new ArrayList<>();
        List<String> actual = solution2115.findAllRecipes(recipes, ingredients, supplies);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
