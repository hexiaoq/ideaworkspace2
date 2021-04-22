package threadpool;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

public class dicovery2 {
    public static void main(String[] args) {
        Integer n=11;
        String s = n.toBinaryString(11);


        System.out.println(s);
         int sum=0;
         for(int i=0;i<s.length();i++)
         {
             if(s.charAt(i)=='1')
                 sum++;
         }
        System.out.println(sum);;


}
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1=new LinkedList<>();
            queue2=new LinkedList<>();


        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue2.offer(x);
            while(!queue1.isEmpty())
            {
                queue2.offer(queue1.poll());
            }
            Queue<Integer> tmp=queue1;
            queue1=queue2;
            queue2=tmp;


        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
         return   queue1.poll();

        }

        /** Get the top element. */
        public int top() {
           return queue1.peek();

        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
         return    queue1.isEmpty();

        }
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        StringBuilder s = new StringBuilder();
        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            if(node==root)
            {
                s.append("[");
            }
            if(node==null)
            {
                s.append(",null");
            }
            else
            {
                s.append(","+node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        s.deleteCharAt(s.length()-1);
        s.append("]");
        return  s.toString();

    }

    // Decodes your encoded data to tree.
    public  TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;


    }

    static  int count1;
    public static int movingCount(int m, int n, int k) {
        int arr[][]=new int[m][n];


                traverse(arr,0,0,k);


        return  count1;


    }
    public static void traverse(int grid[][],int i,int j,int k)
    {if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||!count(i,j,k)||grid[i][j]==1)
        return;
        count1++;
        grid[i][j]=1;
        traverse(grid,i-1,j,k);
        traverse(grid,i+1,j,k);
        traverse(grid,i,j-1,k);
        traverse(grid,i,j+1,k);    }
    public static boolean count(int m,int n,int k)
    {
        int sum=0;
        while(m>0)
        {
            sum=sum+m%10;
            m=m/10;

        }
        while(n>0)
        {
            sum=sum+n%10;
            n=n/10;

        }

        return sum<=k?true:false;

    }
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Queue<TreeNode> stack=new LinkedList();
            stack.add(root);
            StringBuilder s=new StringBuilder();
            s.append("[");
            while(!stack.isEmpty())
            {
                TreeNode node = stack.poll();
                if(node!=null)
                {
                    stack.add(node.left);
                    stack.add(node.right);
                    s.append(root.val+",");




                }
                else{
                    s.append("null"+",");
                }
            }
            s.deleteCharAt(s.length()-1);
            s.append("]");
            return s.toString();


        }



        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.substring(1, data.length() - 1).split(",");
            Queue<TreeNode> queue=new LinkedList<>();
            TreeNode node=new TreeNode(Integer.parseInt(split[0]));
            queue.add(node);int index=1;
            while (!queue.isEmpty())
            {
                TreeNode poll = queue.poll();
              if(split[index++]!=null) {
                  poll.left = new TreeNode(Integer.parseInt(split[index++]));
                  queue.add(poll.left);
              }
              if(split[index++]!=null) {
                  poll.right = new TreeNode(Integer.parseInt(split[index++]));
                  queue.add(poll.right);
              }
            }
            return node;

        }

    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode i=head;
        ListNode j=head;
        boolean isc=false;
        while(j.next!=null)
        {
            i=i.next;
            j=j.next.next;
            if(i==j)
            {
                isc=true;
            }
        }
       if(!isc) return null;
       ListNode tmp=head;
       while(tmp!=i)
       {
           tmp=tmp.next;
           i=i.next;
       }
       return i;
    }
    public boolean isPalindrome(String s) {
        if(s==null)
        {
            return false;
        }
        int i=0;
        int j=s.length()-1;
        while(i>j)
        {
           if(s.charAt(i)!=s.charAt(j))
               return false;
        }
        return  true;

    }
    public boolean isValidSudoku(char[][] board) {
        int[][] rows=new int[9][9];
        int[][] cloums=new int[9][9];
        int[][] block=new int[9][9];
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                int num=(i/3)*3+j/3;
                rows[i][board[i][j]-'0']+=1;
                cloums[i][board[i][j]-'0']+=1;
                block[num][board[i][j]-'0']+=1;
                if(rows[i][board[i][j]-'0']>1||cloums[i][board[i][j]-'0']>1||block[num][board[i][j]-'0']>1)
                    return false;

            }

        }
        return true;

    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

        }
        ListNode newhead = reverse(slow);
        while (newhead!=null)
        {
            if(head.val!=newhead.val)
                return false;
                head=head.next;
            newhead=newhead.next;
        }
        return true;


    }
    public ListNode reverse(ListNode node)
    {
        ListNode pre=null;
        ListNode next=null;
        ListNode cur=node;
        while(cur!=null)
        {
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
    //归并排序
    public static void mergesort(int[] arr,int begin,int end) {
        if(end-begin<1)
        {
            return;
        }
        int mid=begin+(end-begin)/2;
        mergesort(arr,begin,mid-1);
        mergesort(arr,mid,end);

    }
    public void twoto1(int[] arr,int begin,int end,int mid)
    {
        int[] a=new int[end-begin+1];
        int i=begin;int j=mid;int num=0;
        while(i<=mid&&j<=end)
        {
            if(arr[i]>arr[j])
            {
                a[num++]=arr[j++];
            }
            else{
                a[num++]=arr[i++];
            }

        }
        while(i<=mid){
            a[num++] = arr[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=end){
            a[num++] = arr[j++];
        }

        for (int i1 = 0; i1 < a.length; i1++, begin++) {
            arr[begin] = a[i1];

        }

    }

    }

