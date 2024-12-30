import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1634Tests {
    private final SolutionP1634 solutionP1634 = new SolutionP1634();

    @Test
    public void example1() {
        SolutionP1634.PolyNode poly1 = new SolutionP1634.PolyNode(1, 1);
        SolutionP1634.PolyNode poly2 = new SolutionP1634.PolyNode(1, 0);
        SolutionP1634.PolyNode expected = new SolutionP1634.PolyNode(1, 1);
        expected.next = new SolutionP1634.PolyNode(1, 0);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP1634.addPoly(poly1, poly2)));
    }

    @Test
    public void example2() {
        SolutionP1634.PolyNode poly1 = new SolutionP1634.PolyNode(2, 2);
        poly1.next = new SolutionP1634.PolyNode(4, 1);
        poly1.next.next = new SolutionP1634.PolyNode(3, 0);
        SolutionP1634.PolyNode poly2 = new SolutionP1634.PolyNode(3, 2);
        poly2.next = new SolutionP1634.PolyNode(-4, 1);
        poly2.next.next = new SolutionP1634.PolyNode(-1, 0);
        SolutionP1634.PolyNode expected = new SolutionP1634.PolyNode(5, 2);
        expected.next = new SolutionP1634.PolyNode(2, 0);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP1634.addPoly(poly1, poly2)));
    }

    @Test
    public void example3() {
        SolutionP1634.PolyNode poly1 = new SolutionP1634.PolyNode(1, 2);
        SolutionP1634.PolyNode poly2 = new SolutionP1634.PolyNode(-1, 2);
        SolutionP1634.PolyNode expected = null;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionP1634.addPoly(poly1, poly2)));
    }
}
