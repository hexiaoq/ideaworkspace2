package Flyweight;

import java.util.HashMap;
import java.util.Map;
//享元工厂，享元模式和工厂模式结合

public class flyweightfactory
{
    static Map<String,Cheeseflyweight> map=new HashMap<String,Cheeseflyweight>();
    static Cheeseflyweight produce(String key){
        if(map.get(key)!=null)
            return map.get(key);
        else

map.put(key,new Cheeseflyweight(key));
        return map.get(key);
    }
}
