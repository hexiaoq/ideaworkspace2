package code;

import java.util.*;

public class code6 {
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = s.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=s.nextInt();

        }
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(i%60==0) list.add(arr[i]);
            int c=0;int end=0;
            while (arr[i - 1] - arr[i] >= 9)
            {
                c=c==0?i:c;
                end=i;
                i++;

            }
            if(end-c>=3)
            {
                if(c-4>=0) list.add(arr[c-4]);
                if(c-3>=0) list.add(arr[c-3]);
                if(c-2>=0) list.add(arr[c-2]);
                if(c-1>=0) list.add(arr[c-1]);
                for (int j = c; j <=end ; j++) {
                    list.add(arr[j]);

                }
                if(end+1<arr.length) list.add(arr[end+1]);
                if(end+2<arr.length) list.add(arr[end+2]);
                if(end+3<arr.length) list.add(arr[end+3]);
                if(end+4<arr.length) list.add(arr[end+4]);
            }

        }
        for (int j = 0; j <list.size()-1 ; j++) {
            System.out.print(list.get(j)+",");

        }
        System.out.print(list.get(list.size()-1));
//        String s1 = s.nextLine();
//        Stack<Character> stack=new Stack<>();
//        LinkedList<Character> stack1=new LinkedList<>();
//        for (int i = 0; i <s1.length() ; i++) {
//            if(s1.charAt(i)!=')')
//            {
//                stack.add(s1.charAt(i));
//
//            }
//            else{
//                while(stack.peek()!='(')
//                {
//                    stack1.add(stack.pop());
//                }
//                stack.pop();
//                while (!stack1.isEmpty())
//                {
//                    stack.push(stack1.poll());
//                }
//            }
//
//        }
//        StringBuilder str=new StringBuilder();
//        while(!stack.isEmpty())
//        {
//            str.append(stack.pop());
//        }
//        System.out.println(str.reverse().toString());


//        Scanner s=new Scanner(System.in);
//        int n=s.nextInt();
//        int[] ints = new int[n];
//        for (int i = 0; i < ints.length; i++) {
//            ints[i]=s.nextInt();
//
//        }
//        int max=ints[0];
//        int bor=ints[0];
//        int step=1;
//        for (int i = 1; i <ints.length-1 ; i++) {
//            max=Math.max(max,ints[i]+i);
//            if(i==bor)
//            {
//                step++;
//                bor=max;
//            }
//
//        }
//        System.out.println(step);


    }
}
