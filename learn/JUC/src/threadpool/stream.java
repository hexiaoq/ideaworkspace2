package threadpool;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class stream {
    public static void main(String[] args) {
        user u1=new user(1,"a",21);
       user u2= new user(1,"b",26);
        user u3=new user(1,"c",23);
        user u4=new user(4,"d",24);
        user u5=new user(4,"e",28);

        List<user> users = Arrays.asList(u1, u2, u3,u4,u5);

        users.stream().filter(user ->{return user.getId()%2==0;}).
                filter(user -> {return user.getAge()>21;}).
                map(user -> user.getName().toUpperCase()).
                sorted((uu1,uu2)->uu2.compareTo(uu1)).forEach(System.out::println);


    }
}
