package 回文字符串;
//给你一个字符串s，找到s中最长的回文子串
public class Solution {
    public String longestPalindrome(String s){
        //1.建立动态方程
        // dp[i][j]=True:dp[i+1][j-1] && s[i]==s[j]
        //dp[i][j]=false:others
        //2.确定初始状态
        //dp[i][i]=True
        // aba为回文串 aa为回文串，ab不为回文串 也就是 s[i]!=s[j] dp[i][j]=false
        //当前字串一共有两个状态1.是回文串，2.不是回文串

        //初始状态
        int length = s.length();
        boolean[][] dp = new boolean[length+1][length+1];
        for (int i=0;i<length+1;i++){
            dp[i][i]=true;
        }
        int maxLen=1;
        int begin=0;
        char[] chars = s.toCharArray();
        //递推
        //枚举字串长度
        for (int L=2;L<=length;L++){
            //枚举左边界
            for (int i =0;i<length;i++){
                //由L和i可以确定右边界，即j=L+i-1
                int j = L+i-1;
                //如果有边界越界，就可以退出当前循环
                if (j>=length){
                    break;
                }
                if (chars[i]!=chars[j]){
                        dp[i][j]=false;
                }else{
                    if (j-i<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }

                }
                if (dp[i][j]&&(j-i+1)>maxLen){
                    begin=i;
                    maxLen=j-i+1;
                }
            }

        }
        return s.substring(begin,begin+maxLen);
    }

    public static void main(String[] args) {
        String s="cbbd";
        Solution solution = new Solution();
        String s1 = solution.longestPalindrome(s);
        System.out.println(s1);
    }

}
