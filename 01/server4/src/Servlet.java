import java.io.IOException;

/**
 * 服务器的小脚本接口
 */
public interface Servlet {
     void service(request r, response re) throws IOException;
}
