import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class VirusSpread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];

        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        arr[i][j] = sc.nextInt();
        

        Queue<int[]> que = new LinkedList<>();
        int res = 0;

        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++){
            if(arr[i][j] == 2){
                que.add(new int[]{i,j});
            }
        }

        while( !que.isEmpty()) {
            int s = que.size();
            
            System.out.println(s);
            while(s>0){
                int[] node = que.poll();
                int a=node[0];
                int b=node[1];
                s--;
                res++;
            if(a+1 <m  && arr[a+1][b]==1){
                arr[a+1][b]=2;
                
                
                que.add(new int[]{a+1, b });
            }
            if(b+1 <n  && arr[a][b+1]==1){
                arr[a][b+1]=2;
                
                que.add(new int[]{a, b+1 });
            }
            if(a >0   && arr[a-1][b]==1){
                arr[a-1][b]=2;
                
                que.add(new int[]{a-1, b });
            }
            if(b >0  && arr[a][b-1]==1){
                arr[a][b-1]=2;
                
                que.add(new int[]{a, b-1 });
            }}
        }
        return res-1;
        System.out.println(res-1);

    }
    
}
