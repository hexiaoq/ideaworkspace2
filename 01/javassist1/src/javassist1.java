import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.reflect.Method;

public class javassist1  {
   public static void test() throws Exception {
        ClassPool pool= ClassPool.getDefault();
        CtClass cc=pool.get("test");
       System.out.println(cc.getName());
       System.out.println(cc.getSimpleName());

    }

    /**
     * 创建新的方法
     * @throws Exception
     */
    public  static  void test2() throws Exception {
       ClassPool pool=ClassPool.getDefault();
       CtClass cc=pool.get("test");
        CtMethod method=CtMethod.make("public int add(int a,int b) {return $1+$2;}",cc);
        cc.addMethod(method);

        Class clazz=cc.toClass();
        Object c=clazz.newInstance();
        Method m=clazz.getDeclaredMethod("add",int.class,int.class);
        Object result=m.invoke(c,100,500);
        System.out.println(result);
    }

    /**
     * 改变原有方法  用处：在使用完某个方法后 如果想再次使用这个方法并希望这个方法发生改变即可使用此方法
     * @param args
     * @throws Exception
     */
    public static void test3() throws  Exception{
         ClassPool pool=ClassPool.getDefault();
        CtClass cc=pool.get("test");
        CtMethod cm=cc.getDeclaredMethod("sayhello");
        cm.insertAfter("   System.out.println(\"end\");");
        cm.insertBefore("System.out.println(\"start\");");



        Class clazz=cc.toClass();
        Object c=clazz.newInstance();
        Method m=clazz.getDeclaredMethod("sayhello",int.class);
        m.invoke(c,300);

    }

    public static void main(String[] args) throws Exception {
        test3();
    }
}
