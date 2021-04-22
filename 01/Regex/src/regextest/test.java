package regextest;
/**
 *正则表达式1
 *@何小强
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        Pattern p=Pattern.compile("\\w{5}");
        Matcher m=p.matcher("hxq11##hexio##12345");


        while(m.find()){
            System.out.println(m.group());
        }

    }
}
