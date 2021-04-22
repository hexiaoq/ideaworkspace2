package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class solution2 {
    //6.Z形字符串
    public String convert(String s, int numRows) {
        if(numRows<=2)
        {
            return s;
        }
        List<StringBuilder> list=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());

        }
        char[] chars = s.toCharArray();
        for (int i = 0,j=0; i < chars.length; i++,j++) {

            list.get(Math.abs(j)).append(chars[i]);
            if(j==numRows-1)
            {
                j=-j;
            }


        }
        StringBuilder a=new StringBuilder();
        for (int i = 0; i <numRows ; i++) {
            a.append(chars[i]);

        }
        return a.toString();


    }
    //7.整数的反转
@Test
    public void reverse() {
        int x=1234;
        List<Integer> list=new ArrayList<>();
        while(Math.abs(x)!=0)
        {
            int n=x%10;
            list.add(n);
            x/=10;
            System.out.println(n);

        }
        int sum=0;
    System.out.println(list);
    for (int i = 0; i < list.size(); i++) {
            sum= sum+(int)(list.get(i)*Math.pow(10,list.size()-i-1));

        }
        System.out.println(sum);


    }
}
