import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2782Tests {
    static class CategoryHandlerImpl implements SolutionP2782.CategoryHandler {
        int[] categories;
        int n;

        public CategoryHandlerImpl(int[] categories) {
            this.categories = categories;
            n = categories.length;
        }

        @Override
        public boolean haveSameCategory(int a, int b) {
            if (a < 0 || a > n) return false;
            if (b < 0 || b > n) return false;
            return categories[a] == categories[b];
        }
    }

    private final SolutionP2782 solutionP2782 = new SolutionP2782();

    @Test
    public void example1() {
        int n = 6;
        int[] categories = {1, 1, 2, 2, 3, 3};
        CategoryHandlerImpl categoryHandler = new CategoryHandlerImpl(categories);
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2782.numberOfCategories(n, categoryHandler));
    }

    @Test
    public void example2() {
        int n = 5;
        int[] categories = {1, 2, 3, 4, 5};
        CategoryHandlerImpl categoryHandler = new CategoryHandlerImpl(categories);
        int expected = 5;
        Assertions.assertEquals(expected, solutionP2782.numberOfCategories(n, categoryHandler));
    }

    @Test
    public void example3() {
        int n = 3;
        int[] categories = {1, 1, 1};
        CategoryHandlerImpl categoryHandler = new CategoryHandlerImpl(categories);
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2782.numberOfCategories(n, categoryHandler));
    }
}