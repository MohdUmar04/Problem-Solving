import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConversionPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();

        List<String> res = new ArrayList<>();
        for(int i=2;i<= 36; i++){
            res.add( Integer.toString(input1,i));
        }
        Collections.sort(res);

        System.out.println(res);
    }
    
}
