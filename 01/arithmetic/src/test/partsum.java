package test;

import java.util.Scanner;

public class partsum {
    static int a[]=new int[30]; //保存相关元素
  static   int N; //数组长度
   static int K; //要进行判断的和
    public static boolean dfs(int i,int sum)
    {
        if(i == N)
        {
            return sum == K;
        }
        if(dfs(i+1, sum)) return true; //不取下一个数的情况
        if(dfs(i+1, sum+a[i])) return true; //取下一个数的情况
        return false;
    }

public static void main(String[] args) {
        	Scanner op=new Scanner(System.in);
        		N=op.nextInt();
        		K=op.nextInt();
    for (int i = 0; i <N ; i++) {
        a[i]=op.nextInt();
    }

if(dfs(0, 0))
    System.out.println("YES");
else
    System.out.println("NO");



}

}
