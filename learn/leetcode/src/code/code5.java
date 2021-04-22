package code;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class code5 {
   static HashMap map=new HashMap();
 public static void main(String[] args) throws ExecutionException, InterruptedException {
  Scanner s=new Scanner(System.in);
  int n=s.nextInt();
  List<Integer> list=new ArrayList<>(n);
  while(n-->0) {
   list.add(s.nextInt());

  }
  System.out.println(list);
 }

 public void code1() {
  System.out.println(12);
  try {
   Thread.sleep(5000);
  } catch (InterruptedException e) {
   e.printStackTrace();
  }
 }

 public synchronized void code2() {
  System.out.println(14);
  try {
   Thread.sleep(50000);
  } catch (InterruptedException e) {
   e.printStackTrace();
  }
 }
    public ListNode deleteDuplicates(ListNode head) {
     if(head==null)
         return head;
    ListNode cur=head;
    while (cur.next!=null)
    {
        if (cur.val==cur.next.val)
        {
            cur.next=cur.next.next;
        }
        else{
            cur=cur.next;
        }
    }
    return cur;

    }
 public ListNode sortList(ListNode head) {
  if(head==null||head.next==null)
  {
   return head;
  }
  ListNode next = findmid(head);
  ListNode righthead= next.next;
  next.next=null;
  ListNode listNode = sortList(head);
  ListNode listNode1 = sortList(righthead);
  return merge(listNode,listNode1);



 }
 public  ListNode findmid(ListNode head){
  ListNode fast=head.next.next;
  ListNode slow=head;
  while(fast!=null&&fast.next!=null)
  {
   slow=slow.next;
   fast=fast.next.next;
  }
  return slow;
 }
 public ListNode merge(ListNode l1,ListNode l2)
 {
  ListNode dummy=new ListNode();
  ListNode cur=dummy;
  while(l1!=null&&l2!=null)
  {
   if(l1.val>l2.val)
   {
    cur.next=l2;
    l2=l2.next;
    cur=cur.next;
   }
   else{
    cur.next=l1;
    l1=l1.next;
    cur=cur.next;
   }
  }
  cur.next=l1==null?l2:l1;
  return dummy.next;
 }
 public int removeDuplicates(int[] nums) {
    int i=2;
  for (int j = 2; j <nums.length ; j++) {
   if(nums[i-2]==nums[j])
   {
    nums[i]=nums[j];
    i++;
   }

  }
  return i+1;

 }
    public ListNode deleteDuplicates2(ListNode head) {
        if(head==null)
            return head;
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode cur=dummy;
        while(cur.next!=null&&cur.next.next!=null)
        {
            if(cur.next.val==cur.next.next.val)
            {int x=cur.next.val;
            while (cur.next!=null&&cur.next.val==x)
                cur.next=cur.next.next;
            }
            else {
                cur=cur.next;
            }
        }
        return dummy.next;



    }

 public String minWindow(String s, String t) {
  int[] need = new int[128];
  for (int i = 0; i < t.length(); i++) {
   need[t.charAt(i)]++;

  }
  int left = 0;
  int right = 0, count = t.length(), size = Integer.MAX_VALUE, start = 0;
  while (right < s.length()) {
   char c = s.charAt(right);
   if (need[c] > 0) {
    count--;
   }
   need[c]--;
   if (count == 0) {
    while (left < right && need[s.charAt(left)] <= 0) {
     need[s.charAt(left)]++;
     left++;
    }
    size = right - left + 1;
    start = left;
    need[s.charAt(left)]++;
    left++;
    count++;
   }
   right++;


  }
  return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
 }

 public class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
   this.val = val;
  }

  ListNode(int val, ListNode next) {
   this.val = val;
   this.next = next;
  }
 }

 public ListNode partition(ListNode head, int x) {
  ListNode dummy = new ListNode();
  ListNode cur = dummy;
  ListNode dummylarge = new ListNode();
  ListNode curlarge = dummylarge;
  while (head != null) {
   if (head.val < x) {
    dummy.next = head;
    dummy = dummy.next;

   } else {
    dummylarge.next = head;
    dummylarge = dummylarge.next;
   }
   head = head.next;
  }
  cur.next = dummylarge.next;
  return dummy.next;
 }

 public void reverseString(char[] s) {
  if (s.length == 0 || s == null) {
   return;
  }
  int i = 0;
  int j = s.length - 1;
  char tmp = ' ';
  while (i < j) {
   tmp = s[i];
   s[i] = s[j];
   s[j] = tmp;


  }

 }

 public ListNode removeNthFromEnd(ListNode head, int n) {
  ListNode fast = head;
  for (int i = 0; i < n; i++) {
   fast = fast.next;
  }
  ListNode slow = head;
  ListNode pre = slow;
  while (fast != null) {
   fast = fast.next;
   pre = slow;
   slow = slow.next;
  }
  pre.next = slow.next;
  return head;

 }

 public int[] intersect(int[] nums1, int[] nums2) {
  Arrays.sort(nums1);
  Arrays.sort(nums2);
  int i = 0, j = 0;
  ArrayList<Integer> list = new ArrayList<>();
  while (i < nums1.length && j < nums2.length) {
   if (nums1[i] == nums2[j]) {
    list.add(nums1[i])
    ;
    i++;
    j++;

   } else if (nums1[i] < nums2[j]) {
    i++;
   } else {
    j++;
   }
  }
int[] res=new int[list.size()];
  for (int k = 0; k <list.size() ; k++) {
    res[i]=list.get(i);
  }
  return res;


 }
 ArrayList list=new ArrayList<Integer>();
 static  int count;
 public int numSubarrayProductLessThanK(int[] nums, int k) {
  count=-1;int j=0;
  solve(nums,k,j);
  return count;


 }
 public void solve(int[] nums,int k,int j)
 {
  if(!is(list,k)||j>=nums.length)
  {
   return;
  }
  count++;
  for (int i = j; i <nums.length ; i++) {
   list.add(nums[i]);
   System.out.println(list);
   solve(nums,k,i+1);
   list.remove(list.size()-1);
  }

 }
 public boolean is(ArrayList<Integer> list,int target)
 {
  int sum=1;
  for (int i = 0; i <list.size() ; i++) {
   sum*=list.get(i);
  }
  if(sum<target)
   return true;
  else return  false;


 }
 @Test
 public void test()
 {
  int[] num=new int[]{10,5,2,6};
  System.out.println(numSubarrayProductLessThanK(num, 100));
 }
 List<List<Integer>> lists=new ArrayList<>();
 ArrayList<Integer> l=new ArrayList<>();
 public List<List<Integer>> combinationSum3(int k, int n) {
     combinationSum3(k,n);
     return lists;
 }
 public void solve(int k,int n,int num,int sum,int th)
 {
  if(num==k&&sum==0)
  {
   lists.add(new ArrayList<>(l));
  }
  for (int i = th; i <9 ; i++) {
   l.add(i);
   solve(k,n,num+1,sum-i,i);
   l.remove(l.size()-1);

  }

 }
 public double myPow(double x, int n) {
     long a=n;
     double res=1.0;
     if(a<0)
     {
         x=1/x;
         a=-a;
     }
     while (a>0)
     {
         if((a&1)==1)  res*=x;
         x*=x;
         a>>=1;
     }
     return res;

    }

}
