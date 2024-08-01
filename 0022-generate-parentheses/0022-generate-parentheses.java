class Solution {
    public List<String> generateParenthesis(int n) {
        if(n == 1) {
            List<String> lis = new ArrayList<>();
            lis.add("()");
            return lis;
        }

        List<String> str= generateParenthesis(n-1);

        Set<String> res = new HashSet<>();

        for(String s : str){
            StringBuilder st = new StringBuilder(s);

            int ch = 1;
            for(int i = 1;i<=st.length();i++){
                if( i<st.length())
                ch += st.charAt(i) == ')'?-1:1;
                StringBuilder st2 = new StringBuilder(st);
                st2.insert(i,"()");
                res.add(st2.toString());
            }
            // StringBuilder t = new StringBuilder("(");
            // t.append(st.toString()).append(")");
            // res.add(t.toString());
            // st.append("()");
            // res.add(st.toString());
            

        }
        str.clear();
        str.addAll(res);
        return str;




        
    }
}