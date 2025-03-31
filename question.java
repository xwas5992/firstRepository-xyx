import java.io.*;

public class question {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
   static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),true);
   public static int nextInt() throws Exception{
      st.nextToken();
      return (int)st.nval;
   }
   public static String nextLine() throws Exception{
      return br.readLine();
   }
   public static void main(String[] args) throws Exception{
      //典中典01背包问题
      //总共可用时间
      int timeTo = nextInt();
      //草药数
      int num = nextInt();
      //草药时间和价值
      int[] time = new int[num+1];
      for(int i = 1;i <= num;i++)
      {
         time[i] = nextInt();
      }
      //构建dp数组,以横坐标为时间，纵坐标为草药标号
      int[][] dp = new int[num+1][timeTo+1];
      for(int i = 1;i <= num;i++)
      {
         for(int j = 1;j <= timeTo;j++)
         {
            if(time[i] > j){
               dp[i][j] = dp[i-1][j];
            }else{
               dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-time[i]]+time[i]);
            }
         }
      }
      pw.println(timeTo-dp[num][timeTo]);
      pw.close();
      br.close();
   }
}