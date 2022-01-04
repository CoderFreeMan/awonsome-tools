package com.awesome.tips.stringTest;

/**
 * @author yangdejun
 * @date 2020/09/04
 **/
public class AddTest {
    public static void main(String[] args) {
        char[] foo = new char[]{'@', 'a', '*'};
        char ch;
        int x = 0;
        while ((ch = foo[++x]) != '*') {
            System.out.println("" + x + ": " + ch);
        }
    }
}
