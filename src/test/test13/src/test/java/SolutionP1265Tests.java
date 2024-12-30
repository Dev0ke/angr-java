import org.junit.jupiter.api.Test;

public class SolutionP1265Tests {
    private final SolutionP1265 solutionP1265 = new SolutionP1265();

    // TODO
    private static class ImmutableListNodeImpl implements SolutionP1265.ImmutableListNode {
        public ImmutableListNodeImpl(int[] head) {
        }

        @Override
        public void printValue() {

        }

        @Override
        public SolutionP1265.ImmutableListNode getNext() {
            return null;
        }
    }

    @Test
    public void example1() {
        int[] arr = {1, 2, 3, 4};
        SolutionP1265.ImmutableListNode head = new ImmutableListNodeImpl(arr);

    }

    @Test
    public void example2() {
        int[] arr = {0, -4, -1, 3, -5};
        SolutionP1265.ImmutableListNode head = new ImmutableListNodeImpl(arr);

    }

    @Test
    public void example3() {
        int[] arr = {-2, 0, 6, 4, 4, -6};
        SolutionP1265.ImmutableListNode head = new ImmutableListNodeImpl(arr);

    }
}