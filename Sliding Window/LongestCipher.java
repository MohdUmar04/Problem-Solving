import java.util.Scanner;

public class LongestCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();

        int start = 0, end =0,res=0,flag=0, cap = 0;
        while(end<s.length()){

            if(Character.isDigit(s.charAt(end)) ){
                flag ++;
            }
            if(Character.isUpperCase(s.charAt(end)) ){
                cap++;
            }
            while(flag != 0 || cap > 1) {
                char c=s.charAt(start);
                if(Character.isDigit(c))
                 flag --;
                if(Character.isUpperCase(c))
                 cap--;
                 start++;
            }
            if(cap==1)
            res = Math.max(res, end-start+1);
            end++;

        }
        System.out.println(res);

        sc.close();
    }
    
}
