import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *通过配置文件和反射的的方式建立最便捷的连接
 *@何小强
 */
public class conn {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("F:\\idea workspace\\01\\JDBC1\\src\\config.properties"));
        String pwd=properties.getProperty("pwd");
        String user=properties.getProperty("user");
        String url=properties.getProperty("url");String driveclass=properties.getProperty("driveclass");

//driver对象  类加载时由静态模板块自动执行    类似于准备车
        Class.forName(driveclass);

        //connection   相当于开车门和人员上车
        Connection connection = DriverManager.getConnection(url, user, pwd) ;
        System.out.println(connection);


    }
}
