import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SolutionP1236 {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = getHostname(startUrl);

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visSet = new HashSet<>();
        queue.add(startUrl);
        visSet.add(startUrl);
        List<String> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curUrl = queue.remove();
                resList.add(curUrl);

                for (String nextUrl : htmlParser.getUrls(curUrl)) {
                    if (!visSet.contains(nextUrl) && getHostname(nextUrl).equals(hostname)) {
                        visSet.add(nextUrl);
                        queue.add(nextUrl);
                    }
                }
            }
        }
        return resList;
    }

    private static String getHostname(String url) {
//        url = url.replace("http://", "");
        url = url.substring(7);
        if (url.contains("/")) {
            return url.substring(0, url.indexOf("/"));
        }
        return url;
    }

    interface HtmlParser {
        public List<String> getUrls(String url);
    }
}
/*
$1236. 网络爬虫
https://leetcode.cn/problems/web-crawler/

给定一个链接 startUrl 和一个接口 HtmlParser ，请你实现一个网络爬虫，以实现爬取同 startUrl 拥有相同 域名标签 的全部链接。
该爬虫得到的全部链接可以 任何顺序 返回结果。
你的网络爬虫应当按照如下模式工作：
- 自链接 startUrl 开始爬取
- 调用 HtmlParser.getUrls(url) 来获得链接url页面中的全部链接
- 同一个链接最多只爬取一次
- 只输出 域名 与 startUrl 相同 的链接集合
如上所示的一个链接，其域名为 example.org。简单起见，你可以假设所有的链接都采用 http协议 并没有指定 端口。
例如，链接 http://leetcode.com/problems 和 http://leetcode.com/contest 是同一个域名下的，
而链接http://example.org/test 和 http://example.com/abc 是不在同一域名下的。
HtmlParser 接口定义如下：
```
interface HtmlParser {
  // 返回给定 url 对应的页面中的全部 url 。
  public List<String> getUrls(String url);
}
```
下面是两个实例，用以解释该问题的设计功能，对于自定义测试，你可以使用三个变量  urls, edges 和 startUrl。
注意在代码实现中，你只可以访问 startUrl ，而 urls 和 edges 不可以在你的代码中被直接访问。
提示：
1 <= urls.length <= 1000
1 <= urls[i].length <= 300
startUrl 为 urls 中的一个。
域名标签的长为1到63个字符（包括点），只能包含从‘a’到‘z’的ASCII字母、‘0’到‘9’的数字以及连字符即减号（‘-’）。
域名标签不会以连字符即减号（‘-’）开头或结尾。
关于域名有效性的约束可参考:  https://en.wikipedia.org/wiki/Hostname#Restrictions_on_valid_hostnames
你可以假定url库中不包含重复项。

BFS
 */