import java.util.Scanner;

public class smith {
    public static void main(String[] args) {
        int j=1;int c[] = new int[9];int b=0;
        while(j!=0){
        	Scanner op=new Scanner(System.in);
        		int i=op.nextInt();
        		j=i;
        		while (method(i+1)==0)
                {i++;

                }
        		c[b]=method(i+1);
        		b++;
        }
        for (int z = 0; z <b-1 ; z++) {
            System.out.println(c[z]);

        }
    }
    static int method(int i) {
        int j = i;
        int c[] = new int[30];
        int x[] = new int[30];
        int b = 0;
        int v = 0;
   fenjie(i,b,c);


        int all = 0;
        int oll = 0;
        for (int x1 : c) {
            all = all + x1;

        }
        for (int i1 : qvwei(i)) {
            oll = oll + i1;

        }
        if (all == oll)
            return i;
        else return 0;
    }
    //分解质因数并保存到数组
   public static void fenjie(int j,int b,int[] c){

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
                if(i>9)
                {
                    for ( ; b <20 ; b++) {
                        c[b]=qvwei(i)[b];

                    }


                }else{
                    c[b]=i;
                    b++;}
                break;
            }
            else

//如果不是素数，就继续分解，找公约数
                fenjie(j/i,b,c);


        }
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
