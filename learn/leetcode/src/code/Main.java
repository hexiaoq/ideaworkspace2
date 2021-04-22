package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(r.readLine());
        String s = r.readLine();


            for (int i = s.length() - 1; i >= 0; i--) {



                for (int j = 0; j < s.charAt(i) - 'a' + 1; j++) {
                    char[] chars = s.toCharArray();
                    chars[i] = (char) (chars[i] - j);
                    for (int k = s.length()-1; k >=i ; k--) {
                        for (int l = 0; l < s.charAt(k)-'a'+1; l++) {
                            chars[k] = (char) (chars[k] - l);
                            if (is(chars, n)) {
                                StringBuilder a = new StringBuilder();
                                for (int z = 0; z < chars.length; z++) {
                                    a.append(chars[z]);
                                }
                                System.out.println(a.toString());

                                return;
                            }

                        }

                    }

                }


            }



        System.out.println(-1);
    }
    public  static boolean is(char[] s,int k)
    {
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i <s.length ; i++) {
            if(!map.containsKey(s[i]))
            {
                map.put(s[i],1);

            }
            else{
                map.put(s[i],map.getOrDefault(s[i],0)+1);
            }

        }
        Collection<Integer> values = map.values();
        Integer[] integers = values.toArray(new Integer[values.size()]);
        for (int i = 0; i < integers.length; i++) {
            if(integers[i]%k!=0)
            {
                return false;
            }

        }
        return true;



    }

}
