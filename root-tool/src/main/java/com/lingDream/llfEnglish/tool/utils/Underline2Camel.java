package com.lingDream.llfEnglish.tool.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 驼峰法-下划线互转
 *
 * @author cshaper
 * @version 1.0.0
 * @since 2015.07.04
 */
@Component
public class Underline2Camel {

    /**
     * 下划线转驼峰法
     *
     * @param line       源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰
     * @return 转换后的字符串
     */
    public String underline2Camel(String line, boolean smallCamel) {
        if (line == null || "".equals(line)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String word = matcher.group();
            stringBuilder.append(smallCamel && matcher.start() == 0 ? Character.toLowerCase(word.charAt(0)) : Character.toUpperCase(word.charAt(0)));
            int index = word.lastIndexOf('_');
            if (index > 0) {
                stringBuilder.append(word.substring(1, index).toLowerCase());
            } else {
                stringBuilder.append(word.substring(1).toLowerCase());
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 驼峰法转下划线
     *
     * @param line 源字符串
     * @return 转换后的字符串
     */
    public String camel2Underline(String line) {
        if (line == null || "".equals(line)) {
            return "";
        }
        line = String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuilder stringBuffer = new StringBuilder();
        Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String word = matcher.group();
            stringBuffer.append(word.toUpperCase());
            stringBuffer.append(matcher.end() == line.length() ? "" : "_");
        }
        return stringBuffer.toString();
    }
}