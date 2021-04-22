package webspider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class webspider
{
    static public StringBuilder  getcontext(String u,String chraset) throws Exception {
        URL url=new URL(u);
        BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream(),chraset));
        String context="";StringBuilder str = new StringBuilder();
        while ((context=reader.readLine())!=null)
        {
            str.append("\n");
            str.append(context);

        }
        return  str;

    }

    public static void main(String[] args) throws Exception {
        StringBuilder sr=getcontext("https://www.tmall.com/", "utf-8");
        Pattern p=Pattern.compile("<[Aa] href=.+?>");
        Matcher m=p.matcher(sr);

        while(m.find())
        {
            System.out.println(m.group());
        }
    }
}
