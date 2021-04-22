package test;

import java.util.Arrays;


public class Solution {
    //最长回文字符串暴力法
    public String longestPalindrome(String s) {
        if(s.length()<2)
            return s;
        int maxlen=1;
        int begin=0;
        char[] chars=s.toCharArray();
        for (int i = 0; i <chars.length-1 ; i++)
            for (int j = i+1; j <chars.length-1 ; j++) {
                if(j-i+1>maxlen&&ispalindrome(chars,i,j))
                {
                    maxlen=j-i+1;
                    begin=i;
                }


            }
        return s.substring(begin,begin+maxlen);



    }
    //动态规划法
    public boolean ispalindrome(char[] chars,int left,int right) {
        while (left< right)
        {if(chars[left]!=chars[right])
            return false;
        left++;
        right--;

        }
        return true;
    }
    public String longestPalindrome2(String s) {
        int len=s.length();
        if(s.length()<2)
            return s;
        char[] chars=s.toCharArray();
        int maxlen=1;
        int begin=0;
//表
        boolean[][] is=new boolean[len][len];
        //填表时,要满足需要被参考的条件先填入
        for (int j = 1; j <len ; j++) {
            for (int i = 0; i <j ; i++) {
                if(chars[i]!=chars[j])
                    is[i][j]=false;
                else{
                    //边界条件,即无需状态转移
                    if(j-i<3)
                        is[i][j]=true;
                    else
                        //状态转移方程式
                        is[i][j]=(chars[i+1]==chars[j-1]);

                }
                if(j-i+1>maxlen&&is[i][j]==true)
                {
                    begin=i;
                    maxlen=j-i+1;
                }



            }


        }
        return s.substring(begin,begin+maxlen);
    }

//416 动态规划
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0)
        {
            return  false
                    ;
        }

        int sum1=0;
        for (int num : nums) {
            sum1=sum1+num;
        }
        if((sum1&1)==1)
        {
            return false;

        }
        int sum=sum1/2;
        boolean[][] map=new boolean[len][sum+1];


        for (int i = 0; i <len; i++) {
            map[i][0]=true;

        }
        if(nums[0]<=sum)
        {
            map[0][nums[0]]=true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <sum+1 ; j++) {
                map[i][j]=map[i-1][j];
                if(nums[i]<j)
                {
                    map[i][j]=map[i-1][j]||map[i-1][j-nums[i]];
                }

            }
            if(map[i][sum]==true)
                return true;

        }
        return false;



    }

    //474 0和1问题  二维动态规划
    public int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        int[][][] dp=new int[len+1][m+1][n+1];
        for (int i = 1; i <len+1 ; i++) {
            String s=strs[i-1];
            int[] oneandzero=countzeroanone(s);
            for (int j = 0; j <m+1 ; j++) {
                for (int k = 0; k <n+1 ; k++) {
                    dp[i][j][k]=dp[i-1][j][k];
                    int zero=oneandzero[0];
                    int one=oneandzero[1];
                    if(j>=zero&&k>=one)
                    {
                        dp[i][j][k]=Math.max(dp[i-1][j][k],dp[i-1][j-zero][k-one]+1);
                    }

                }

            }

        }
        return dp[len][m][n];

    }
    //优化为一维动态规划  滚动数组+从前往后赋值
    public int findMaxForm2(String[] strs, int m, int n)
    {
        int  len=strs.length;
        int[][] dp=new int[m+1][n+1];

        for (String str : strs) {
            int[] oneandzero=countzeroanone(str);
            for (int j = m+1; j <m+1 ; j--) {

                for (int k = n+1; k <n+1 ; k--) {

                    int zero=oneandzero[0];
                    int one=oneandzero[1];
                    if(j>=zero&&k>=one)
                    {
                        dp[j][k]=Math.max(dp[j][k],dp[j-zero][k-one]+1);
                    }

                }

            }

        }
        return dp[m][n];


    }
    public static int[] countzeroanone(String s)
    {
        char[] chars=s.toCharArray();
        int countzero=0;
        for (char aChar : chars) {
            if(aChar=='0')
            {
                countzero++;
            }
        }
        int[] counts=new int[2];
        counts[0]=countzero;
        counts[1]=chars.length-countzero;
        return counts;

    }

    //494 目标和
    public int findTargetSumWays(int[] nums, int S) {
        int len=nums.length;
        int[][] dp=new int[len][2001];

        dp[0][nums[0]+1000]=1;
        dp[0][1000-nums[0]]=1;
        for (int i = 1; i <nums.length ; i++) {
            for (int j = -1000; j <1001 ; j++) {
                if(dp[i-1][j+1000]>0)
                {
                    dp[i][j+1000]=dp[i-1][j-nums[i]]+dp[i-1][j+nums[i]];
                }

            }
            
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];


    }

}
