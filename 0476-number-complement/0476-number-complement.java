class Solution {
    public int findComplement(int num) {
        String s1 = Integer.toBinaryString(num);
        StringBuilder s = new StringBuilder();
        for(int i=0; i < s1.length() ;i++){
            char ch = s1.charAt(i);
            switch(ch) {
                case '0':
                    s.append("1");
                    break;
                case '1':
                    s.append("0");
            }
        }
        return Integer.parseInt(s.toString(),2);
    }
}