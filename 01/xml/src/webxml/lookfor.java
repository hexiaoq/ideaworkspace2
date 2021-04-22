package webxml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lookfor {
List<Entity> entitylist;
List<Mapping> mappinglist;
    Map<String,String> emap=new HashMap<String,String>();
    Map<String,String> mmap=new HashMap<String,String>();

    public lookfor(List<Entity> entitylist,List<Mapping> mappinglist) {
this.mappinglist=mappinglist;
        this.entitylist = entitylist;
        for (Entity e:entitylist
             ) {emap.put(e.getName(),e.getCls());
        }
        for (Mapping m:mappinglist
        ) {mmap.put(m.getPattern(),m.getName());

        }

        }

    public String getclz(String pattern){
        String s;
        s=mmap.get(pattern);
        return emap.get(s);}

}
