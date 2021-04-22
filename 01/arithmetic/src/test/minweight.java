package test;

import java.util.Scanner;

public class minweight {
    static int w[][]=new int[100][100];//表示第i个供应商的第j个产品的重量
    static int p[][]=new int[100][100];//表示第i个供应商的第j个产品的价格
    static int minw=10000;//表示最小质量,默认为无穷
    static  int cw=0,cp=0;//当前产品重量和价格
    static int x[]=new int[100];//临时存放所选择的第j个产品的供应商
    static  int bestx[]=new int[100];//存放最优解
    static  int price;static int n;//部件数
    static int c;//供应商数量
    public static void backmethod(int t){

        if(t>n)
        {minw=cw;
            for (int i = 0; i <t ; i++) {
                bestx[i]=x[i];

            }

        }else {
            for (int i = 0; i <c ; i++) {
               cw=cw+w[t][i];
               cp=cp+p[t][i];
               x[t]=i;
               if(cp<=price&&cw<minw)
                   backmethod(t+1);
                cw=cw-w[t][i];
                cp=cp-p[t][i];

            }

        }
    }

    public static void main(String[] args) {
        	Scanner op=new Scanner(System.in);
       n=op.nextInt();
       if(n>=1)
       c=op.nextInt();
       price=op.nextInt();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <c ; j++) {
                w[i][j]=op.nextInt();

            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <c ; j++) {
                p[i][j]=op.nextInt();

            }
        }
backmethod(0);
        for (int i = 0; i <c ; i++) {
            if(i!=c-1)
            System.out.print((bestx[i]+1)+" ");
            else
                System.out.print(bestx[i]+1);


        }
        System.out.print("\n");
        System.out.println(minw);
    }
}
