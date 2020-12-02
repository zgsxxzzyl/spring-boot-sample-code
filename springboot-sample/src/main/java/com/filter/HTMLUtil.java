package com.filter;

public class HTMLUtil {

    private static final char[][] TEXT = new char[64][];
    private static HTMLFilter htmlFilter = new HTMLFilter();

    static {
        for (int i = 0; i < 64; i++) {
            TEXT[i] = new char[]{(char) i};
        }
        // special HTML characters
        TEXT['\''] = "&#039;".toCharArray(); // 单引号 ('&apos;' doesn't work - it is not by the w3 specs)
        TEXT['"'] = "&quot;".toCharArray(); // 单引号
        TEXT['&'] = "&amp;".toCharArray(); // &符
        TEXT['<'] = "&lt;".toCharArray(); // 小于号
        TEXT['>'] = "&gt;".toCharArray(); // 大于号
    }

    /**
     * Encoder
     *
     * @param text  被编码的文本
     * @param array 特殊字符集合
     * @return 编码后的字符
     */
    private static String encode(String text, char[][] array) {
        int len;
        if ((text == null) || ((len = text.length()) == 0)) {
            return "";
        }
        StringBuilder buffer = new StringBuilder(len + (len >> 2));
        char c;
        for (int i = 0; i < len; i++) {
            c = text.charAt(i);
            if (c < 64) {
                buffer.append(array[c]);
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    /**
     * 转义文本中的HTML字符为安全的字符，以下字符被转义：
     * <ul>
     * <li>'  替换为 &amp;#039; (&amp;apos; doesn't work in HTML4)</li>
     * <li>"  替换为 &amp;quot;</li>
     * <li>&amp; 替换为 &amp;amp;</li>
     * <li>&lt; 替换为 &amp;lt;</li>
     * <li>&gt; 替换为 &amp;gt;</li>
     * </ul>
     *
     * @param text 被转义的文本
     * @return 转义后的文本
     */
    public static String escape(String text) {
        return encode(text, TEXT);
    }

    /**
     * 过滤HTML文本，防止XSS攻击
     *
     * @param htmlContent HTML内容
     * @return 过滤后的内容
     */
    public static String filter(String htmlContent) {
        return htmlFilter.filter(htmlContent);
    }
}
