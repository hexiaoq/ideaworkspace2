package code;

import java.util.*;

public class code7 {
//    public static void main(String[] args) {
///**
// * 集齐7颗龙珠召唤神龙
// */
//// 召唤龙珠的线程
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
//            System.out.println("召唤神龙成功！");
//        });
//        for (int i = 1; i <=7 ; i++) {
//            final int temp = i;
//// lambda能操作到 i 吗
//            new Thread(()->{
//                System.out.println(Thread.currentThread().getName()+"收集"+temp+"个龙珠");
//                try {
//                    cyclicBarrier.await(); // 等待
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//        System.out.println(".....");
//    }
//public static void main(String[] args) throws InterruptedException {
// 总数是6，必须要执行任务的时候，再使用！
//    CountDownLatch countDownLatch = new CountDownLatch(6);
//    for (int i = 1; i <=6 ; i++) {
//
//            System.out.println(i+" Go out");
//            countDownLatch.countDown(); // 数量-1
//
//    }
//    countDownLatch.await(); // 等待计数器归零，然后再向下执行
//    System.out.println("Close Door");


//}
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1= nums1.length;int len2=nums2.length;
    int left=(len1+len2+1)/2;
    int right=(len1+len2+2)/2;
    return (findkth(nums1,0,len1-1,nums2,0,len2-1,left)+
            findkth(nums1,0,len1-1,nums2,0,len2-1,right))*0.5;

    }
    public  int findkth(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k)
    {
        int len1=end1-start1+1;int len2=end2-start2+1;
        if(len1>len2) return findkth(nums2,start2,end2,nums1,start1,end1,k);
        if(len1==0) return nums2[start2+k-1];

        if(k==1) return Math.min(nums1[start1+k-1],nums2[start2+k-1]);
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
         if(nums1[k]>nums2[k])
         {
             return findkth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));

         }
         else{
             return findkth(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
         }

    }
    public String replaceSpace(String s) {
        StringBuilder str=new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)==' ')
                str.append("%20");
            else
                str.append(s.charAt(i));
        }
        return str.toString();
    }
    public int fib(int n) {
    if(n==0||n==1)
    {
        return n;
    }
         int a=0;int b=1;
        for (int i = 2; i <n ; i++) {
            int tmp=a;
            a=b;
            b=tmp+b;


        }
        return b;

    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(f[i]));

        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
       double  i=3.2222;
       float j=2.1f;
       int z=3;
       float c=z+3;

        System.out.println(x);

    }
    public String sortString(String s)
    {
        int[] arr=new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        StringBuilder str=new StringBuilder();
        while(str.length()<s.length())
        {
            for (int i = 0; i <26; i++) {
                if(arr[i]>0)
                {
                    str.append((char)(arr[i]+'a'));
                }

            }
            for (int i = 25; i >= 0; i--) {
                if(arr[i]>0)
                {
                    str.append((char)(arr[i]+'a'));
                }

            }

        }
        return str.toString();

    }
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<Integer>((a,b)->{
            return b-a;
        });
        for (int i = 0; i <k ; i++) {
            integers.offer(arr[i]);

        }
        for (int i = k; i <arr.length ; i++) {
            if(integers.peek()>arr[i])
            {
                integers.poll();
                integers.offer(arr[i]);

            }

        }
        int[] arr1=new int[k];
        for (int i = 0; i <k; i++) {
            arr1[i]=integers.poll();
        }
        return arr1;

    }
    class MaxQueue {

        Queue<Integer> queue=new LinkedList<>();
        Deque<Integer> deque=new LinkedList<>();
        public MaxQueue() {

        }

        public int max_value() {
            return deque.peekFirst();

        }

        public void push_back(int value) {
            queue.offer(value);
            if(value>deque.peekLast())
            {
                deque.clear();
                deque.offer(value);
            }
            else
                deque.offer(value);
        }

        public int pop_front() {
            Integer poll = queue.poll();
            if(poll==deque.peekFirst())
            {
                deque.removeFirst();
            }
            return poll;


        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true){
            if (root.val > p.val && root.val > q.val) {
                 root=root.left;
            }
            else if(root.val<  p.val && root.val < q.val)
           {
                root=root.right;
            }
            else
                return root;
        }
    }
    public int[] searchRange(int[] nums, int target) {
        int i=0;
        int j=nums.length;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if(nums[mid]==target) break;
            if(nums[mid]<target) i=mid+1;
            else j=mid-1;
        }
        int[] ints = new int[2];
        if(nums[i]!=target){
            ints[0]=-1;
            ints[1]=-1;
            return ints;
        }
        for (int k = i; k>=0 ; k--) {
            if(nums[k]==target)
                ints[0]=k;
            else break;

        }
        for (int k = i; k <nums.length ; k++) {
            if(nums[k]==target)
                ints[1]=k;
            else break;;

        }
        return ints;


    }
    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> l= new ArrayList<>();
        if(strs==null||strs.length==0)
        {
            return l;
        }
        Map<char[], ArrayList<String>> map=new HashMap<>(
        );
        for (String str : strs) {
            char[] chars = str.toCharArray();
            String s=new String(chars);
            Arrays.sort(chars);
            ArrayList<String> list = map.getOrDefault(chars, new ArrayList<String>());

            list.add(s);
            map.put(chars,list);

        }

        Iterator<Map.Entry<char[], ArrayList<String>>> iterator = map.entrySet().iterator();
        while(iterator.hasNext())
        {
            l.add(iterator.next().getValue());
        }
        return l;


    }
 public ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null)
        {
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre.next;
 }
    public int longestValidParentheses(String s) {
        char[] c=s.toCharArray();
        int[] dp=new int[c.length];
        for (int i = 1; i <s.length() ; i++) {
            if(c[i]==')')
            {
                if(c[i-1]=='(')
                dp[i]=i>=2?dp[i-2]+2:2;
                else if(i-dp[i-1]-1>0&&c[i-dp[i-1]-1]=='(')
                {
                    dp[i]=dp[i-dp[i-1]-2]+
                }
            }
            System.out.println(Arrays.toString(dp));

        }

    }
    public void rotate(int[] nums, int k) {
        reverse(nums,0,nums.length);
        reverse(nums,0,(k%(n-1))-1);
        reverse(nums,k%(n-1),nums.length-1);

    }
    public void reverse(int[] nums,int start,int end)
    {
        int tmp=0;
        for (int i = start; i <end ; i++) {
            tmp=nums[start];
            nums[start]=nums[end];
            nums[end]=tmp;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         if(headA==null||headB==null)
             return null;
         while(headA!=headB)
         {
             headA=headA==null?headB:headA.next;
             headB=headB==null?headA:headB.next;
         }
         return headA;
    }


}



