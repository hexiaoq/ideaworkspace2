package code;




import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.*;


public class code3 {
  class TreeNode {
        int val;
     TreeNode left;
  TreeNode right;
        TreeNode(int x) { val = x; }
    }
   List list= new ArrayList<Integer>();
   static int i=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
        {
            list.add(-1);
        }
        list.add(root.val);
        serialize(root.left);
        serialize(root.right);
        String replace = list.toString().replace("-1", null);
        return replace;



    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        char[] chars = data.toCharArray();
        return deserialize1(chars);


    }
    public TreeNode deserialize1(char[] chars)
    {
        TreeNode treeNode = new TreeNode(chars[i++]);
        treeNode.left=deserialize1(chars);
        treeNode.right=deserialize1(chars);
        return treeNode;



    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseList(ListNode head) {
        //头结点值不为空的情况
        if(head==null||head.next==null)
            return head;
        ListNode tem = head.next;
        head.next=null;
        ListNode help =null;
        while(tem!=null)
        {help=tem.next;
        tem.next=head;
        head=tem;
        tem=help;
        }
        return head;


    //头结点为空的情况
//     if(head.next==null||head.next.next==null)
//            return head;
//    ListNode tem = head.next;
//    head.next=null;
//    ListNode help =null;
//        while(tem!=null)
//    {help=tem.next;
//        tem.next=head.next;
//        head.next=tem;
//        tem=help;
//    }
//    head=tem;
//        return head;
//
//
//}
    }
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> objects = new HashSet<>();
        for (int num : nums) {
            if(!objects.add(num))
                return num;

        }
        return -1;

    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if(twomid(ints,target,0,ints.length-1));
            return true;
        }
        return false;

    }
    public boolean twomid(int[] ints,int target,int beging,int end)
    {
        if(end<=beging)
            return false;
        int mid=(end+beging)/2+1;
        if(ints[mid]==target)
            return true;
        if(ints[mid]>target)
        return twomid(ints,target,beging,mid-1);
        else
            return twomid(ints,target,mid+1,end);

    }
    public int[] reversePrint(ListNode head) {
        int[] a=new int[0];
        if(head==null)
            return null;
        ListNode tem=head.next;
        LinkedList<Integer> integers = new LinkedList<>();
        integers.push(head.val);


        while (tem!=null)
        {
            integers.push(tem.val);
            tem=tem.next;

        }
        Object[] objects = integers.toArray();
        for (int i1 = 0; i1 < objects.length; i1++) {
            a[i1]=(int)objects[i1];
        }

        return a;




    }
    public int minArray(int[] numbers) {
        int min=Integer.MAX_VALUE;
        for (int i1 = 0; i1 < numbers.length; i1++) {
            if(numbers[i1]<min)
                min=numbers[i1];
        }
        return min;

    }
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(dfs(board,chars,i,j,0))
                    return true;
            }
        }
        return false;

    }
    public boolean dfs(char[][] board,char[] words,int i,int j,int k)
    {
        if(i<0||i>board.length-1||j<0||j>board[0].length-1||words[k]!=board[i][j])
            return false;
        board[i][j]='\0';
        if(k==words.length-1) return true;
        boolean res=dfs(board,words,i+1,j,k+1)||dfs(board,words,i-1,j,k+1)||dfs(board,words,i,j+1,k+1)||dfs(board,words,i,j-1,k+1);
        board[i][j]=words[k];
        return res;


    }
    public int[] exchange(int[] nums) {
        //双指针
//        int i=0;int j=nums.length-1;
//        int tem;
//        while(i<=j)
//        {
//            if(!is2(nums[i])) {
//                i++;
//                continue;
//            }
//            if(is2(nums[j])) {
//                j--;
//                continue;
//            }
//            tem=nums[i];
//            nums[i]=nums[j];
//            nums[j]=i;
//            i++;
//            j--;
//
//
//
//        }
//        return nums;
        //快慢指针
        int fast=0,low=0;
        while (fast>nums.length-1) {
            if (is2(nums[fast])) {
                fast++;
                continue;
            }
            nums[low]=nums[fast];
            low++;
            fast++;
        }
        return nums;



    }
    public boolean is2(int sum)
    {
        if((sum&1)==1)
            return false;
        return true;
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tem=head;
        for (int j = 0; tem!=null ; j++) {
            tem=tem.next;

        }
        int index=i-k;
        tem=head;
        for (int j = 0; i<=index ; j++) {
            tem=tem.next;

        }
        return tem;


    }
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> HashMap = new HashMap<>();
        int tmp;
        int[] dp = new int[s.length()];
        dp[0]=1;
        for (int i = 1; i < dp.length-1; i++) {
            Integer j = HashMap.getOrDefault(chars[i], -1);
            HashMap.put(chars[i],i);
            dp[i]=dp[i-1]>i-j?dp[i-1]:dp[i-1]+1;


        }
        return dp[chars.length-1];

    }

    //最长公共子串
    public int LCS (String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int l1=chars1.length;
        int l2=chars2.length;
        int res=0;
        for (int j = 0; j <l1 ; j++) {
            int len=Math.min(l1-j,l2);
            res=Math.max(maxlenth(chars1,chars2,j,len),res);
        }
        for (int j = 0; j <l2 ; j++) {
            int len=Math.min(l1,l2-j);
            res=Math.max(maxlenth(chars2,chars1,j,len),res);
        }
        return res;

    }
    public int maxlenth(char[] a,char[] b,int al,int len)
    {
        int res=0;int k=0;
        for (int j = 0; j <len ; j++) {
            if(a[al+j]==b[j])
            {
                k++;

            }
            else k=0;
            res=Math.max(res,k);
        }
        return res;

    }

    //最长公共子序列
    public String LCS2 (String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        int[][] dp=new int[m+1][n+1];
        //初始化
        Arrays.fill(dp[0],0);
        for (int j = 0; j <m+1; j++) {
            dp[j][0]=0;
        }
        for (int j = 1; j <m ; j++) {
            for (int k = 1; k <n ; k++) {
                if(s1.charAt(j-1)==s2.charAt(k-1))
                    dp[j][k]=dp[j-1][k-1]+1;
                else dp[j][k]=Math.max(dp[j-1][k],dp[j][k-1]);

            }

        }
        //倒序构建最长公共子序列
        StringBuilder sb = new StringBuilder();
        while (m>0&&n>0)
        {
            if(s1.charAt(m-1)==s2.charAt(n-1))
            {
                m--;n--;
                sb.append(s1.charAt(m));
            }
            else if
                (dp[m-1][n]>dp[m][n-1])
                m--;
            else n--;
        }
        return sb.reverse().toString();




    }

    //k个一组翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        //定义一个假的节点。
        ListNode dummy=new ListNode(0);
        //假节点的next指向head。
        // dummy->1->2->3->4->5
        dummy.next=head;
        //初始化pre和end都指向dummy。pre指每次要翻转的链表的头结点的上一个节点。end指每次要翻转的链表的尾节点
        ListNode pre=dummy;
        ListNode end=dummy;

        while(end.next!=null){
            //循环k次，找到需要翻转的链表的结尾,这里每次循环要判断end是否等于空,因为如果为空，end.next会报空指针异常。
            //dummy->1->2->3->4->5 若k为2，循环2次，end指向2
            for(int i=0;i<k&&end != null;i++){
                end=end.next;
            }
            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if(end==null){
                break;
            }
            //先记录下end.next,方便后面链接链表
            ListNode next=end.next;
            //然后断开链表
            end.next=null;
            //记录下要翻转链表的头节点
            ListNode start=pre.next;
            //翻转链表,pre.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
            pre.next=reverse(start);
            //翻转后头节点变到最后。通过.next把断开的链表重新链接。
            start.next=next;
            //将pre换成下次要翻转的链表的头结点的上一个节点。即start
            pre=start;
            //翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
            end=start;
        }
        return dummy.next;



    }
    public ListNode reverse(ListNode head)
    {
        ListNode tem=head.next;
        head.next=null;
        ListNode record=null;
        while(tem!=null)
        {
            record=tem.next;
            tem.next=head;
            head=tem;
            tem=record;
        }
        return head;


    }




}
