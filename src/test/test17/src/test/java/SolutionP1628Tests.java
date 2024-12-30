import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1628Tests {
    @Test
    public void example1() {
        String[] postfix = {"3", "4", "+", "2", "*", "7", "/"};
        int expected = 2;

        SolutionP1628.TreeBuilder treeBuilder = new SolutionP1628.TreeBuilder();
        SolutionP1628.Node actual = treeBuilder.buildTree(postfix);
        Assertions.assertEquals(expected, actual.evaluate());
    }

    @Test
    public void example2() {
        String[] postfix = {"4", "5", "7", "2", "+", "-", "*"};
        int expected = -16;

        SolutionP1628.TreeBuilder treeBuilder = new SolutionP1628.TreeBuilder();
        SolutionP1628.Node actual = treeBuilder.buildTree(postfix);
        Assertions.assertEquals(expected, actual.evaluate());
    }
}
