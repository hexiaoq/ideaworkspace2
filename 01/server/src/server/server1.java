package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server1 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        server1 server=new server1();
        server.start();

    }
    public  void start(){
        try {
            serverSocket=new ServerSocket(8888);//建立服务器套接口，指明端口
            System.out.println("服务器建立");
            receive();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void receive() throws IOException {
       Socket socket=serverSocket.accept();//当有客户端访问服务器套接口指明的端口时，便建立服务器与客户端之间的套接口
        System.out.println("一个服务器已建立连接");
        byte[] data=new byte[1024*1024];
        try {
            InputStream is=socket.getInputStream();//套接口存在输入输出流
            int len=is.read(data);
            String info=new String(data,0,len);
            System.out.println(info);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
    public void end(){

    }
}
