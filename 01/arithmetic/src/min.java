//1 要求：给定一个含n(n≥1)个整数的数组，请设计一个在时间上尽可能高效的算法，
// 找出数组中未出现的最小正整数。例如，数组{-5, 3, 2, 3}中未出现的最小正整数是1；数组{1, 2, 3}中未出现的最小正整数是4。

import java.util.Scanner;

public class min {
    public static void main(String[] args) {
        Scanner op=new Scanner(System.in);
        int i=op.nextInt();
        int a[]=new int[i];
        for (int j = 0; j <i ; j++) {
            a[j]=op.nextInt();
    }
        for (int k = 1; ; k++) {int c=0;
            for (int l = 0; l <i ; l++) {
                if(k==a[l])
                    break;
                c=l;

                }
            if(c==i-1) {
                System.out.println(k);
                break;
            }

        }
    }
}
