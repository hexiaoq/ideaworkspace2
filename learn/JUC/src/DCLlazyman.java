public class DCLlazyman {
    private DCLlazyman(){

    };
    //防止创建d的时候由于指令重排导致d不为null但指向空的内存,而使其他线程直接返回未被初始化的d
    private static volatile   DCLlazyman d;

    //dcl 双重检测锁的懒汉式单例模式
    public static DCLlazyman getInstance(){
        if(d==null)
        {synchronized(DCLlazyman.class){
            if(d==null)
            d=new DCLlazyman();
        }

        }
        return d;
    }
    public static void main(String[] args) {
        for (int i = 0; i <20 ; i++) {
            new Thread(()-> System.out.println(DCLlazyman.getInstance())).start();
        }


    }
}
