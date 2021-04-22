import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TEST {

    public static void main(String[] args) throws IOException {
        String ms=null;

        try (BufferedReader os = new BufferedReader(new FileReader("msg.txt"))) {
       while ((ms=os.readLine())!=null)
                System.out.println(ms);

        }


        System.out.println("出现异常");

    }
}
