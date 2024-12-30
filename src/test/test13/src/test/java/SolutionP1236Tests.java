import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP1236Tests {
    private final SolutionP1236 solutionP1236 = new SolutionP1236();

    // TODO
    private static class HtmlParserImpl implements SolutionP1236.HtmlParser {
        public HtmlParserImpl(String[] urls, int[][] edges) {

        }

        @Override
        public List<String> getUrls(String url) {
            return new ArrayList<>();
        }
    }

    @Test
    public void example1() {
        String startUrl = "http://news.yahoo.com/news/topics/";
        String[] urls = {
                "http://news.yahoo.com",
                "http://news.yahoo.com/news",
                "http://news.yahoo.com/news/topics/",
                "http://news.google.com",
                "http://news.yahoo.com/us"
        };
        int[][] edges = UtUtils.stringToInts2("[[2,0],[2,1],[3,2],[3,1],[0,4]]");
        SolutionP1236.HtmlParser htmlParser = new HtmlParserImpl(urls, edges);
        List<String> expected = Arrays.asList(
                "http://news.yahoo.com",
                "http://news.yahoo.com/news",
                "http://news.yahoo.com/news/topics/",
                "http://news.yahoo.com/us"
        );
        List<String> actual = solutionP1236.crawl(startUrl, htmlParser);
        expected.sort(null);
        actual.sort(null);
//        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String startUrl = "http://news.google.com";
        String[] urls = {
                "http://news.yahoo.com",
                "http://news.yahoo.com/news",
                "http://news.yahoo.com/news/topics/",
                "http://news.google.com"
        };
        int[][] edges = UtUtils.stringToInts2("[[0,2],[2,1],[3,2],[3,1],[3,0]]");
        SolutionP1236.HtmlParser htmlParser = new HtmlParserImpl(urls, edges);
        List<String> expected = Arrays.asList(
                "http://news.google.com"
        );
        List<String> actual = solutionP1236.crawl(startUrl, htmlParser);
        expected.sort(null);
        actual.sort(null);
//        Assertions.assertEquals(expected, actual);
    }
}