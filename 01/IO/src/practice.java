import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        	Scanner op=new Scanner(System.in);
        		int i=op.nextInt();int b=0;
        		op.close();
        		int a[]=new int[20];
        for (int j = 0; j <20 ; j++) {
            System.out.println(fenjie(i,b,a)[j]);

        }
        System.out.println("sm");
    }
    public static int[] fenjie(int j,int b,int[] c){

        for(int i=2;i<Math.sqrt(i);i++){

//这个if是找最小公约数
            if(j%i == 0){if(i>9)
            {
                for (; b <20 ; b++) {
                    c[b]=qvwei(i)[b];

                }


            }else{
                c[b]=i;
                b++;}}

//这个if是判断他是不是素数，如果是素数，就将这个数输出，然后就执行break;了
            if(isPrime(j/i)){
                if(j/i>9)
                {
                    for ( ; b <20 ; b++) {
                        c[b]=qvwei(j/i)[b];

                    }


                }else{
                    c[b]=j/i;
                    b++;}
                break;
            }
            else

//如果不是素数，就继续分解，找公约数
                fenjie(j/i,b,c);


        }
        return c;
    }

    //判断是否是素数
    public static boolean isPrime(int n){
        for(int i=2;i<Math.sqrt(n);i++)
        {
            if(n%i == 0)
                return false;
        }
        return true;
    }
    //取各位上的数字
    public static int[] qvwei(int n){
        int a[]=new int[20];int b=0;
        for (int i = 1; i <n ; i=i*10,b++) {

            a[b]=n/i%10;

        }
        return a;
    }
}
