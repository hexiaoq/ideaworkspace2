import java.io.*;

public class copy {
    public static void main(String[] args) throws IOException {
        InputStream is=new FileInputStream("msg.txt");
        byte[] b=new byte[100];
        is.read(b);
        File f=new File("m.txt");
        OutputStream os=new FileOutputStream(f);
        os.write(b);
        String info=new String(b,0,100,"utf-8");
        System.out.println(info);


    }
}
