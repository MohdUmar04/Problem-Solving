class Solution {
    char[][] board;
    String word;
    private boolean check(int i,int j,boolean[][] vis,int id){
        if(vis[i][j]) return false;
        if(id==word.length()) return true;
        boolean res=false;
        vis[i][j]=true;

        if(i+1<vis.length && board[i+1][j] == word.charAt(id) ){
            res=res||check(i+1,j,vis,id+1);
        }
        if(j+1<vis[0].length && board[i][j+1] == word.charAt(id) ){
            res=res||check(i,j+1,vis,id+1);
        }
        if(i-1>=0 && board[i-1][j] == word.charAt(id) ){
            res=res||check(i-1,j,vis,id+1);
        }
        if(j-1>=0 && board[i][j-1] == word.charAt(id) ){
            res=res||check(i,j-1,vis,id+1);
        }

        vis[i][j]=false;
        return res;

    }
    public boolean exist(char[][] board, String word) {
        
        this.board=board;
        this.word=word;
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board[0].length;j++) {
                if(board[i][j] == word.charAt(0)){
                    if (check(i,j,vis,1)) return true;
                }
            }
        }
        return false;
    }
}