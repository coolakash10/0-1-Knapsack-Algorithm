/*********************************************************************************************************************
     **
     **  Knapsack Algorithm
     **  Problem : https://www.hackerrank.com/challenges/unbounded-knapsack/problem?h_r=internal-search
     **  Input in the form of array
     **  Output is maximum sum
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/

//import package
import java.io.*;
import java.math.*;
import java.util.*;

public class Main 
{

    static int Knapsack(int k, int[] a) 
    {
        //sort input array
        Arrays.sort(a);
     
		//dp array of size
        int[][]dp=new int[a.length][k+1];
        
		//loop for 1st element
        for(int i=1;i<=k;i++)
        {
            if(i<a[0])
                dp[0][i]=0;
            else
            {
				//condition which depend on problem
                int p=i/a[0];
                p=p*a[0];
                dp[0][i]=p;    
            }
            
        }
        
		//loop for other element
        for(int i=1;i<a.length;i++)
        {
            for(int j=1;j<=k;j++)
            {
                if(a[i]<=j)
                {
					//condition which depend on problem
                    dp[i][j]=Math.max(a[i]+dp[i][j-a[i]],dp[i-1][j]);
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
		//return right most bottom element which is answer
        return dp[a.length-1][k];

    }

    

    public static void main(String[] args) throws IOException 
    {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        
        while(t-->0)
        {
            String[] nk = br.readLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] arr = new int[n];

            String[] arrItems = br.readLine().split(" ");
    
            for (int i = 0; i < n; i++) 
            {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = Knapsack(k, arr);

            System.out.println(result);
        }
      
    }
    
}
