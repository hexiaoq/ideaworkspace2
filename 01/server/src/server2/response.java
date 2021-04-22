package server2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class response {
    private BufferedWriter bw;
    //正文
    private StringBuilder content;
    //头信息（响应头，响应行，空行）
    private StringBuilder headinfo;
    //正文长度
    private int len;
    final static String BLANK = " ";
    final  static  String CRLF = "\r\n";
    public response(){
        content=new StringBuilder();
        headinfo=new StringBuilder();
        len=0;

    }
    public response(Socket client) throws IOException {
        this();
        bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
    }
    public void add(String info){
        content.append(info);
        len+=info.getBytes().length;

    }
    public void creatheadinfo(int code) throws IOException {


                headinfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
                switch (code){
                    case 200:headinfo.append("OK").append(CRLF);
                    break;
                    case 404:headinfo.append("NOT FOUND").append(CRLF);
                    break;
                    case 505:headinfo.append("SERVER ERROR").append(CRLF);
                    break;

                }
                headinfo.append("Date:").append(new Date()).append(CRLF);
                headinfo.append("Server").append("shsxt Server/0.0.1;charset=utf-8").append(CRLF);
                headinfo.append("Content-type:text/html").append(CRLF);
                headinfo.append("Content-length:").append(len).append(CRLF);
                headinfo.append(CRLF);}
public void givebrowser(int code) throws IOException {
            creatheadinfo(code);
    bw.append(headinfo);
    bw.append(content);
    bw.flush();
        }



}
