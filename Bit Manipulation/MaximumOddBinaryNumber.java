public class MaximumOddBinaryNumber {

    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        int count2 = 0;
        for(char c : s.toCharArray()){
            if(c == '1')
                count++;
            else
                count2++;
        }
        StringBuilder str = new StringBuilder();
        for(;count-->1;)
            str.append("1");
        for(;count2-->0;)
            str.append("0");
        str.append("1");
        return str.toString();
    }
}
