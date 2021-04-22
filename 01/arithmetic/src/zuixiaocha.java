import java.util.Scanner;
//最接近数问题（20分）
//题目内容：
//
//设计算法找出整数数组a[n]（n<=50）中相差最小的两个元素（称为最接近数）的差。
//
//
//
//输入格式:
//
//第一行为数组大小n，第二行为n个数组元素，元素之间用空格分开
//
//
//
//输出格式：
//
//最接近数的差
//
//
//
//输入样例：
//
//5
//
//65 38 26 75 40
//
//
//
//输出样例：
//
//2

public class zuixiaocha {
    public static void main(String[] args) {
        	Scanner op=new Scanner(System.in);
        		int i=op.nextInt();
        int a[]=new int[i];
        for (int j = 0; j <i ; j++) {
            a[j]=op.nextInt();

        }int e= Math.abs(a[i - 1] - a[i - 2]);
        for(;i>1;i--) {
            int k=0;
            for (int c = i - 1; c - 1 >= 0; c--) {

                k = Math.abs(a[i - 1] - a[i - 2]);
                if (k > (Math.abs(a[i - 1] - a[c - 1]))) {
                    k = Math.abs(a[i - 1] - a[c - 1]);

                }
                if(e>k)
                    e=k;

            }

        }
        System.out.println(e);
    }
}
