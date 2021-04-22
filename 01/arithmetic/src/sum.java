//计算 输入n 输出sum=1+2+3+.....+n;
import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        Scanner op=new Scanner(System.in);
        int i=op.nextInt();
        int a[]=new int[i];int b[]=new int[i];
        for (int j = 0; j <i ; j++) {
            a[j]=op.nextInt();
            int sum=0;
            for (int k = 0; k <i ; k++,sum++) {
                if(isoushu(a[k]))
                b[sum]=(1+a[k])*(a[k]/2);
                else
                    b[sum]=(a[k])*((a[k]-1)/2)+a[k];
            }
        }
        System.out.println(i);
        System.out.println(" ");
        for (int z = 0; z <i ; z++) {
            System.out.print(b[z]+" ");

        }
    }
    public static boolean isoushu(int i){
        if(i%2==0)
            return true;
        else
    return false
            ;

    }
}
