public class SolutionP1618 {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int left = 0;
        int right = fonts.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(text, w, h, fonts, fontInfo, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (left - 1 >= 0) ? fonts[left - 1] : -1;
    }

    private boolean checkMid(String text, int w, int h, int[] fonts, FontInfo fontInfo, int mid) {
        int H = fontInfo.getHeight(fonts[mid]);
        int W = 0;
        for (char ch : text.toCharArray()) {
            W += fontInfo.getWidth(fonts[mid], ch);
        }
        return W > w || H > h;
    }

    interface FontInfo {
        // Return the width of char ch when fontSize is used.
        int getWidth(int fontSize, char ch);

        // Return Height of any char when fontSize is used.
        int getHeight(int fontSize);
    }
}
/*
$1618. 找出适应屏幕的最大字号
https://leetcode.cn/problems/maximum-font-to-fit-a-sentence-in-a-screen/

给定一个字符串 text。并能够在 宽为 w 高为 h 的屏幕上显示该文本。
字体数组中包含按升序排列的可用字号，您可以从该数组中选择任何字体大小。
您可以使用FontInfo接口来获取任何可用字体大小的任何字符的宽度和高度。
FontInfo接口定义如下：
interface FontInfo {
  // 返回 fontSize 大小的字符 ch 在屏幕上的宽度。
  // 每调用该函数复杂度为 O(1)
  public int getWidth(int fontSize, char ch);

  // 返回 fontSize 大小的任意字符在屏幕上的高度。
  // 每调用该函数复杂度为 O(1)
  public int getHeight(int fontSize);
}
一串字符的文本宽度应该是每一个字符在对应字号(fontSize)下返回的宽度getHeight(fontSize)的总和。
请注意：文本最多只能排放一排
如果使用相同的参数调用 getHeight 或 getWidth ，则可以保证 FontInfo 将返回相同的值。
同时，对于任何字体大小的 fontSize 和任何字符 ch ：
- getHeight(fontSize) <= getHeight(fontSize+1)
- getWidth(fontSize, ch) <= getWidth(fontSize+1, ch)
返回可用于在屏幕上显示文本的最大字体大小。如果文本不能以任何字体大小显示，则返回-1。
注意:
1 <= text.length <= 50000
text 只包含小写字母
1 <= w <= 10^7
1 <= h <= 10^4
1 <= fonts.length <= 10^5
1 <= fonts[i] <= 10^5
fonts 已经按升序排序，且不包含重复项。
 */