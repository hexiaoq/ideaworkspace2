package code;

import java.util.Arrays;
import java.util.concurrent.ForkJoinTask;

public class code {
    //300.最长上升子序列
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] max = new int[len];
        Arrays.fill(max, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    max[i] = Math.max(max[i], max[j] + 1);
            }

        }
        Arrays.sort(max);
        return max[len - 1];

    }

    //978. 最长湍流子数组
    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        //1记录n作为上升的长度,0记录n作为下降的长度
        int[][] dp = new int[2][n];

        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if (A[i] < A[i - 1])
                dp[0][i] = dp[0][i - 1] + 1;
            else
                dp[1][i] = dp[1][i - 1] + 1;


        }
        Arrays.sort(dp[0]);
        Arrays.sort(dp[1]);
        return dp[0][n - 1] > dp[1][n - 1] ? dp[0][n - 1] : dp[1][n - 1];

    }

    //787,k站内中转价格最低航班
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //定义状态 dp为经过k次中转到达n的价格
        int[][] dp = new int[n][n];


        for (int i = 0; i < n; i++) {
            //先给所有位置填充一个最大值
            Arrays.fill(dp[i], 100000);
            //自己到自己永远为0元
            dp[i][src] = 0;

        }
        for (int[] flight : flights) {
            //航班初始地为src,均初始为直达的价格
            if (flight[0] == src) {
                dp[0][flight[1]] = flight[2];
            }
        }
        //先更新每一行,即最多经过i次到达各地的最低价格
        for (int i = 1; i < n; i++) {
            for (int[] flight : flights) {
                //已知航班ab间的价格,只要src能到a,则src到b的价格则可能更新为 src到a+ab
                if (dp[i - 1][flight[0]] != 100000)
                    dp[i][flight[1]] = Math.min(dp[i][flight[1]], dp[i - 1][flight[0]] + flight[2]);

            }
        }
        int min = 1000000;
        for (int j = 0; j <= K; j++) {
            if (dp[j][dst] < min)
                min = dp[j][dst];

        }
        if (min == 100000)
            min = -1;
        return min;


    }

    //32:最长有效括号
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] == ')') {//)前面是(的情况
                if (chars[i - 1] == '(')
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                    //)前面是)的情况
                else if (i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '(')
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] + 2 : 2);
                max = Math.max(max, dp[i]);

            }

        }
        return max;

    }

    //174 地下城游戏
    public int calculateMinimumHP(int[][] dungeon) {
        int i = dungeon.length;
        int j = dungeon[0].length;
        int[][] dp = new int[i + 1][j + 1];
        for (int i1 = 0; i1 <= dp.length; i1++) {
            Arrays.fill(dp[i1], Integer.MAX_VALUE);

        }
        dp[i][j - 1] = dp[i - 1][j] = 1;
        for (int k = i - 1; k >= 0; k--) {
            for (int l = j - 1; l >= 0; l--) {
                dp[i][j] = Math.max(Math.min(dp[k + 1][l], dp[k][l + 1]) - dungeon[k][l], 1);

            }


        }
        return dp[0][0];

    }
    //62.不同路径
    public int uniquePaths(int m, int n) {
        if(m<=0||n<=0)
            return 0;
        int[][] dp=new int[m][n];
       Arrays.fill(dp[0],1);
        for (int i = 0; i <m ; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <n ; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }

        }
        return dp[m-1][n-1];

    }
    //滚动数组
    public int uniquePaths2(int m, int n) {
        if(m<=0||n<=0)
            return 0;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <n ; j++) {
               dp[j]=dp[j]+dp[j-1];
            }

        }
        return dp[n-1];

    }
    //64.最小路径和
    public int minPathSum(int[][] grid) {
        int i=grid.length;
        int j=grid[1].length;
        if(i<=0||j<=0)
        {
            return 0;
        }
        int[][] dp=new int[i][j];
        dp[0][0]=grid[0][0];
        for (int k = 1; k < j; k++) {
            dp[0][k]=dp[0][k-1]+grid[0][k];

        }
        for (int k = 1; k <i ; k++) {
            dp[k][0]=dp[k-1][0]+grid[k][0];

        }
        for (int k = 1; k <i ; k++) {
            for (int l = 1; l < j; l++) {
                dp[k][l]=Math.min(dp[k-1][l],dp[k][l-1])+grid[k][l];

            }

        }
        return dp[i-1][j-1];






    }
//    public int minPathSum2(int[][] grid) {
//        int i=grid.length;
//        int j=grid[0].length;
//
//        int[] dp=new int[j];
//        dp[0]=grid[0][0];
//
//        for (int k = 0; k <i ; k++) {
//            if(k==0)
//            {
//                dp[k]=dp[k]+
//            }
//            for (int l = 1; l < j; l++) {
//                dp[k][l]=Math.min(dp[k-1][l],dp[k][l-1])+grid[k][l];
//
//            }
//
//        }
//        return dp[i-1][j-1];
//
//
//
//
//
//
//    }
    }
















