import bean.person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class jasontest {
    @Test
    public void test(){
        person handsome = new person(1, "hxq handsome");
        Gson gson=new Gson();
        String info=gson.toJson(handsome);
        System.out.println(info);
    }
    @Test
    public void  test2(){
        List<person> list=new ArrayList();
        list.add(new person(1,"sa"));
        list.add(new person(2,"adaf"));
        Gson gson=new Gson();
        //转换成字符串
        String info=gson.toJson(list);
        System.out.println(info);
        //字符串转成list,但是此方法的list里的类型不为person
        List<person> list1=gson.fromJson(info,list.getClass());
        System.out.println(list1);
        //转换成泛型为person的list
        List<person> list2=gson.fromJson(info,new TypeToken<ArrayList<person>>(){}.getType());
        person p2=list2.get(1);
        System.out.println(p2);
    }
}
