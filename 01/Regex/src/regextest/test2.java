package regextest;

import java.util.Arrays;

/**
 *正则表达式2
 *@何小强
 */
public class test2 {
    public static void main(String[] args) {
        String s="ajjfak!!!1jkdal!!!2何小强";
        String[] str=s.split("!{3}\\w");
        System.out.println(Arrays.toString(str));
    }
}

