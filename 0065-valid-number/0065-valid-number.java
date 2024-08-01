class Solution {
    boolean flag;
    private boolean solve(String s, int i, int c, int d,int p) {
        System.out.println(i);
        if( i == s.length() ){
            if(s.charAt(i-1) == '+' || s.charAt(i-1) == '-') return false;
            if(s.charAt(i-1) == '.') return true;
            return s.charAt(i-1) != 'E' && s.charAt(i-1) != 'e' ? true: false;
            }
        if(!flag){
            if(s.charAt(i) =='+' || s.charAt(i) =='-'){
                if(p == 1) return false;
                return solve(s,i+1,c,d,1);
            } 
        }else{
            if((s.charAt(i) =='+' || s.charAt(i) =='-') && (s.charAt(i-1) == 'e' || s.charAt(i-1) == 'e')){
                // if(p == 1) return false;
                return solve(s,i+1,c,d,1);
            } 
        }
        if( s.charAt(i) == 'e' || s.charAt(i) == 'E' )
        {
            if(c == 1 || !flag) return false;
            return solve(s, i+1,c+1,d,p);
        }
        if(s.charAt(i) == '.') {
            if(c == 1) return false;
            // System.out.println(d);
            if(d == 1) return false;
            return solve(s,i+1,c,d+1,p);
        }
        if(!Character.isDigit(s.charAt(i)) ){
            if(!flag) return false;
            if((s.charAt(i-1) == 'E' || s.charAt(i-1) == 'e') && (s.charAt(i) == '+' || s.charAt(i) =='-') )
            return solve(s,i+1,c,d,p);
            return false;
            }
        flag = true;
        return solve(s,i+1,c,d,p); 
    }
    public boolean isNumber(String s) {
        flag = false;
        // if(s.charAt(s.length()-1) == '.') 
        //     s=s.substring(0,s.length()-1);
        // if(s.length() == 0) return false;
        // if(s.charAt(0) == 'i') return false;
        return solve(s,0,0, 0,0) && flag;
        
    }
}