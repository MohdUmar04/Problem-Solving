import java.util.Arrays;
import java.util.Scanner;

public class ConversionPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();

        String[] res = new String[35];
        for(int i=2;i<= 36; i++){
            res[i-2] =Integer.toString(input1,i);
        }
        Arrays.sort(res);
        
        for(String s : res)
        System.out.print(s +" ");
        // System.out.println(res.length);

        sc.close();
    }
    
}
