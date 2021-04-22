package PACKAGE_NAME;

import java.util.Scanner;
//分解质因数的算法


public class salkjf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//输入
        System.out.println("请输入一个大于3的数:");
        int number = input.nextInt();
        fengjie(number);
    }

    public static void fengjie(int j){


        for(int i=2;i<Math.sqrt(j);i++){

//这个if是找最小公约数
            if(j%i == 0){
                System.out.print(i+"*");

//这个if是判断他是不是素数，如果是素数，就将这个数输出，然后就执行break;了
                if(isPrime(j/i)){
                    System.out.print(j/i);
                }
                else

//如果不是素数，就继续分解，找公约数
                    fengjie(j/i);

                break;
            }
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
    }

