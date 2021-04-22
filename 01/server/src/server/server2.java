package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class server2 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        server2 server = new server2();
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
        byte[] data = new byte[1024 * 1024];
        try {
            InputStream is = socket.getInputStream();//套接口存在输入输出流
            int len = is.read(data);
            String info = new String(data, 0, len);
            System.out.println(info);

            StringBuilder content = new StringBuilder();
            content.append("<html>");
            content.append("<head>");
            content.append("<title>");
            content.append("服务器响应成功");
            content.append("</title>");
            content.append("</head>");
            content.append("<body>");
            content.append("shsxt gogogo");
            content.append("</body>");
            content.append("</html>");
            int size = content.toString().getBytes().length;
            StringBuilder responseinfo = new StringBuilder();
            String BLANK = " ";
            String CRLF = "\r\n";
            //1.添加响应行HTTP/1.1 200 OK
            responseinfo.append("HTTP/1.1").append(BLANK).append(200).append(BLANK).append("OK").append(CRLF);
            //2.响应头（最后一行存在空行）
            /*时间
            Server:shsxt Server/0.0.1;charset=GBK
            Content-type:text/html
            Content-length:39725426
            */
            responseinfo.append("Date:").append(new Date()).append(CRLF);
            responseinfo.append("Server").append("shsxt Server/0.0.1;charset=utf-8").append(CRLF);
            responseinfo.append("Content-type:text/html").append(CRLF);
            responseinfo.append("Content-length:").append(size).append(CRLF);
            responseinfo.append(CRLF);
            //3.正文
            responseinfo.append(content.toString());
            //写出到客户端
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(responseinfo.toString());
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void end() {

    }
}
