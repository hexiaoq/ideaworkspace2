package code;

import org.junit.Test;

import java.lang.annotation.Target;
import java.util.*;

public class code4 {
//买卖股票的最佳时机
public int maxProfit(int prices[]) {
    int minprice = Integer.MAX_VALUE;
    int maxprofit = 0;
    for (int i = 0; i < prices.length; i++) {
        if (prices[i] < minprice) {
            minprice = prices[i];
        } else
        {maxprofit=prices[i]-minprice>maxprofit?prices[i]-minprice:maxprofit;}
    }
    return maxprofit;
}
    List<List<Integer>> list= new ArrayList<List<Integer>>();
    ArrayList<Integer> integers = new ArrayList<>();
    public List<List<Integer>> FindPath(TreeNode root, int target) {

         isright(root,target);
         return list;




    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if(B==null) return true;
        if(A==null)
            return false;
        return equals(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);

    }
    public boolean equals(TreeNode a,TreeNode b)
    {
        if(b==null) return true;
        if(a==null||a.val!=b.val) return false;
        return equals(a.left,b.left)&&equals(a.right,b.right);
    }
    static int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSum(root);
        return max;



    }
    public int  solve(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int val=root.val+root.left.val+root.right.val;
        int left=Math.max(solve(root.left),0);
        int right= Math.max(solve(root.right),0);
        int help=Math.max(left+root.val,right+solve(root.right));
        max= Math.max(max,val);
        return help;


    }
    List<List<Integer>>  list1=new ArrayList<>();
    ArrayList<Integer> l=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null||candidates.length==0)
            return list1;
        Arrays.sort(candidates);
            solve(candidates,target,0);
            return list1;
    }
    public void solve(int[] can,int target,int k)
    {
        if(target<0)
        {
            return;
        }
        if(target==0)
        {
            list1.add(new ArrayList<>(l));
            return;
        }
        for (int i = k; i <can.length; i++) {
            if(i>k&&can[i]==can[i-1]) continue;
           if(target-can[i]<0) break;
            l.add(can[i]);
            solve(can,target-can[i],i+1);
            l.remove(l.size()-1);

        }
    }
    public String addBinary(String a, String b) {
        if(a==null||b==null)
            return a==null?b:a;
        int i=a.length(),j=b.length();
        StringBuilder s=new StringBuilder();
        int carry=0;
        while(i>=0||j>=0)
        {
            int n1=i>=0?a.charAt(i):0;
            int n2=j>=0?b.charAt(j):0;
            int num=(n1+n2+carry)==2?0:n1+n2;
            carry=(n1+n2+carry)==2?1:0;
            s.append(num);

        }
        return s.reverse().toString();


    }
    public int mySqrt(int x) {
        int i=0;
        int j=x/2;
        while (i<=j)
        {
            int mid=i+(j-i)/2;
            if(mid==x/mid)
                return mid;
            if(mid<x/mid)
                i=mid+1;
            else
                j=mid-1;

        }
        return i;


    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve3(nums,0,nums.length-1);


    }

    public TreeNode solve3(int[] nums,int s,int end)
    {
        int mid=s+(end-s)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left=solve3(nums,s,mid-1);
        treeNode.right=solve3(nums,mid+1,end);
        return treeNode;


    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode mid = findmid(head);
        TreeNode treeNode = new TreeNode(mid.val);

        ListNode next=mid.next;
        mid.next=null;
        treeNode.left=sortedListToBST(head);
        treeNode.right=sortedListToBST(next);
        return treeNode;




    }

    public ListNode findmid(ListNode head){
        ListNode fast=head.next.next;
      ListNode slow=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        for (int i = len-1; i <=0 ; i++) {
            digits[i]++;
            int num = digits[i] % 10;
            digits[i]=num;
            if(digits[i]!=0) return digits;
        }
        int[] ints = new int[len + 1];
        ints[0]=1;
        return ints;

    }
    public void isright(TreeNode root, int target)
    {
        if(root==null)
            return;

        int target1=target-root.val;

        integers.add(root.val);
        if(target1==0) {
            list.add(integers);
            return;
        }
        if(target1<0) {
            integers.remove(root.val);

            return;
        }
        else {
            isright(root.left, target1);
            isright(root.right, target1);
        }
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
    int size=0;


    public int[] LRU (int[][] operators, int k) {
        // write code here
        LinkedList<Integer> list= new LinkedList();
        HashMap<Integer,Integer> map=new HashMap();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i <operators.length ; i++) {


            for (int j = 0; j < operators[i].length; i++) {
                if(operators[i][j]==1)
                {
                    set(i,j,list,map,k);

                }
                else
                    integers.add(get(i,list,map));

            }
        }
        Object[] objects = integers.toArray();
        int a[]=new int[objects.length];
        for (int i = 0; i <objects.length ; i++) {
            a[i]=(int)objects[i];
        }

        return a;


    }
    public void set(int i,int j,LinkedList<Integer> list,HashMap<Integer,Integer> map,int k)
    {
        Integer o = map.get(i);

        if(o==null) {
            map.put(i, j);
            list.add(i);
        }
        else {
            list.remove(i);
            list.add(i);
        }
        size++;
        if(size>k)
        {
            Integer last = list.getLast();
            list.removeLast();
            map.remove(last);
            size--;
        }

    }
    public int get(int i,LinkedList<Integer> list,HashMap<Integer,Integer> map)
    {
        Integer integer = map.get(i);
        if(integer!=null) {
            list.remove(i);
            list.add(i);
            return integer;
        }
        else
            return -1;


    }

}
class LRUCache extends LinkedHashMap<Integer,Integer> {
    private int capcity;

    public LRUCache(int capacity) {
        super(capacity,0.75F);
        this.capcity=capacity;

    }

    public int get(int key) {
        return  super.getOrDefault(key,-1);

    }

    public void put(int key, int value) {
        super.put(key,value);

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capcity;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
