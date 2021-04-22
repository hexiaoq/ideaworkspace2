import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class thread implements Runnable {
    private Socket socket;
    private request r;
    private response re;
    public thread(Socket socket){
        this.socket=socket;
        try {
            r = new request(socket);
            re=new response(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void run() {


        try {
            r.request();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(r.getURL());
        Servlet servlet=webapp.getServletFromURL(r.getURL());

        if(null!=servlet)
        {
            try {
                servlet.service(r,re);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else{
            try {

                InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
                byte[] b=new byte[1024*10];
                is.read(b);
                String s=new String(b).trim();
                re.add(s);
                re.givebrowser(404);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





}
