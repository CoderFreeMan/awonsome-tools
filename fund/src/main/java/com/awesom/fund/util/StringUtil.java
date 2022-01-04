package com.awesom.fund.util;

import com.google.common.collect.Lists;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangdejun
 * @date 2020/09/22
 **/
public class StringUtil {

    /**
     * 提取字符串中的数字为一串数字字符串
     * @param var
     * @return
     */
    public static String extractNums(String var) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < var.length(); i++) {
            if (var.charAt(i) >= 48 && var.charAt(i) <= 57) {
                sb.append(var.charAt(i));
            }
        }
        return sb.toString();
    }

    public static List<String> extractSplitNums(String var) {
        StringBuilder sb = new StringBuilder();
        List<String> response = Lists.newArrayListWithExpectedSize(2);
        int counter = 0;
        for (int i = 0; i < var.length(); i++) {
            if (var.charAt(i) >= 48 && var.charAt(i) <= 57) {
                sb.append(var.charAt(i));
                counter++;
            }
            else {
                if (sb.length() > 0) {
                    response.add(new String(sb.toString()));
                    sb.delete(0, sb.length());
                }
                counter = 0;
            }
        }
        return response;
    }

}
