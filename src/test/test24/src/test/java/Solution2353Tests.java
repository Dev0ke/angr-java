import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2353Tests {
    @Test
    public void example1() {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};

        Solution2353.FoodRatings foodRatings = new Solution2353.FoodRatings(foods, cuisines, ratings);

        // 返回 "kimchi"
        // "kimchi" 是分数最高的韩式料理，评分为 9 。
        Assertions.assertEquals("kimchi", foodRatings.highestRated("korean"));

        // 返回 "ramen"
        // "ramen" 是分数最高的日式料理，评分为 14 。
        Assertions.assertEquals("ramen", foodRatings.highestRated("japanese"));

        // "sushi" 现在评分变更为 16 。
        foodRatings.changeRating("sushi", 16);

        // 返回 "sushi"
        // "sushi" 是分数最高的日式料理，评分为 16 。
        Assertions.assertEquals("sushi", foodRatings.highestRated("japanese"));

        // "ramen" 现在评分变更为 16 。
        foodRatings.changeRating("ramen", 16);

        // 返回 "ramen"
        // "sushi" 和 "ramen" 的评分都是 16 。
        // 但是，"ramen" 的字典序比 "sushi" 更小。
        Assertions.assertEquals("ramen", foodRatings.highestRated("japanese"));
    }
}
