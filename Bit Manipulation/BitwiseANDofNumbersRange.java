
public class BitwiseANDofNumbersRange {
    public static int rangeBitwiseAnd(int left, int right) {
        int c=0;
        while(left != right) {
            left = left>>1;
            right = right>>1;
            c++;
        }
        while(c-->0) left=left<<1;
        return left;
    }
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
    }
    
}
