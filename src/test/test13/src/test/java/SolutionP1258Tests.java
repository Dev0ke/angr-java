import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1258Tests {
    private final SolutionP1258 solutionP1258 = new SolutionP1258();

    @Test
    public void example1() {
        List<List<String>> synonyms = UtUtils.stringToStringList2("""
                [["happy","joy"],["sad","sorrow"],["joy","cheerful"]]
                """);
        String text = "I am happy today but was sad yesterday";
        List<String> expected = List.of(
                "I am cheerful today but was sad yesterday",
                "I am cheerful today but was sorrow yesterday",
                "I am happy today but was sad yesterday",
                "I am happy today but was sorrow yesterday",
                "I am joy today but was sad yesterday",
                "I am joy today but was sorrow yesterday"
        );
        Assertions.assertEquals(expected, solutionP1258.generateSentences(synonyms, text));
    }
}
