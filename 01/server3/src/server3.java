import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器加入了xmL的内容，直接解析xml文件获得url进而获得和执行serverlet
 * 所存在的bug 使用rester可以正常使用 使用html网页登陆却出错
 */

public class server3 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        server3 server = new server3();
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
        Socket socket = serverSocket.accept();//当有客户端访问服务器套接口指明的端口时，便建立服务器与客户端之间的套接口
        System.out.println("一个服务器已建立连接");
       request r=new request(socket);
        r.request();

            response re=new response(socket);
        System.out.println(r.getURL());
        Servlet servlet=webapp.getServletFromURL(r.getURL());

        if(null!=servlet)
        {
            servlet.service(r,re);
            re.givebrowser(200);
        }
        else{
            re.givebrowser(404);
        }

        }




    public void end() {

    }
}
