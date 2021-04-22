package server2;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

public class request {
    private  Map<String,List<String>> pmap;
    private InputStream is;
    private String URL;
    private String PAR;

    public String getURL() {
        return URL;
    }

    public String getPAR() {
        return PAR;
    }

    public request(Socket client) throws IOException {
        is = client.getInputStream();
    }

    public void request() throws IOException {
        pmap=new HashMap<String,List<String>>();
        try {
            byte[] data = new byte[1024 * 1024];
            int len = is.read(data);
            String info = new String(data, 0, len);
            System.out.println(info);
            getmethod(info);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getmethod(String info) {
        String method = info.substring(0, info.indexOf("/") - 1);
        System.out.println("请求方式" + info.substring(0, info.indexOf("/") - 1));
        String par=null;
        int end = info.indexOf("HTTP");
        int begin = info.indexOf("/");
        int tag = info.indexOf("?");
         this.URL = info.substring(begin + 1, end);

        if (method.equals("POST")) {
            int l = info.lastIndexOf("\r\n");
            String last = info.substring(l).trim();
            if (-1 != tag) {
                String url1 = info.substring(begin + 1, tag);
                System.out.println("url->" + url1);
                URL=url1;
                String par1 = info.substring(tag + 1, end);
                System.out.println("参数—>" + par1 + last);
                par=par1+last;
                PAR=par;
            } else {
                System.out.println("url->" + URL);
                System.out.println("参数->" + last);
                par=last;
                PAR=par;

            }

        } else {
            if (-1 != tag) {
                String url1 = info.substring(begin + 1, tag);
                URL=url1;
                System.out.println("url->" + URL);


                 par = info.substring(tag + 1, end);
                System.out.println("参数—>" + par); PAR=par;

            } else {

                System.out.println("url->" +URL);

            }
        }

        getpar(par);

    }

    public void getpar(String info) {
        String[] kv1 = info.split("&");
        for (String kv : kv1
        ) {
            String[] kv2 = kv.split("=");
            kv2 = Arrays.copyOf(kv2, 2);
            String key = kv2[0];
            String value = kv2[1]==null?null:decode(kv2[1],"utf-8");
            if (!pmap.containsKey(key)) {
                pmap.put(key, new ArrayList<String>());
            }
           pmap.get(key).add(value);


        }


    }
    private String decode(String value,String enc)  {
        try {
            return java.net.URLDecoder.decode(value,enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getvalue(String key) {
        List<String> list=pmap.get(key);
        String a="";
        for (String s:list) {a=a+s;
            
        }

        if (null != list)
            return a;

        else return null;


    }
}
