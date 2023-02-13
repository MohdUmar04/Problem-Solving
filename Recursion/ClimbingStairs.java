import java.util.*;
public class ClimbingStairs {
    public static int solve(int n,int current) {
        if(current==n) return 1;
        if(current>n) return 0;
        int left=solve(n, current+1);
        int right=solve(n, current+2);
        return left+right;
    }

    public static int find(int n)
    {
        return solve(n,0);
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(find(n));
        sc.close();
    }
}
