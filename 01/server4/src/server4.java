import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在3的基础上加入多线程
 * bug 使用rester可以  使用html网页 线程却执行两次 且存在错误 ex；login.html
 */

public class server4 {
    static int i=0;
    private ServerSocket serverSocket;


    public static void main(String[] args) {
        server4 server = new server4();
        server.start();

    }


    public void start() {
        try {
            serverSocket = new ServerSocket(8888);//建立服务器套接口，指明端口
            System.out.println("服务器建立");
            receive();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void receive() throws IOException {

        while(true) {
            try{
                i++;
            Socket socket = serverSocket.accept();//当有客户端访问服务器套接口指明的端口时，便建立服务器与客户端之间的套接口
            System.out.println(i+"个客户端已建立连接");
            new Thread(new thread(socket)).start();}
            catch (Exception e){
                System.out.println("客户端错误");
            }

        }
    }

}
