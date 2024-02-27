public class SurroundedRegions {
    

    private void check(int i, int j, char[][] board, boolean[][] vis){
        if(i<0 || j<0 || i==board.length || j == board[0].length || vis[i][j]) return ;

        vis[i][j] = true;
        if(i+1<board.length)
        if(board[i+1][j] == 'O') check( i+1,j,board,vis);
        if(i-1>-1)
        if(board[i-1][j] == 'O') check( i-1,j,board,vis);
        if(j+1<board[0].length)
        if(board[i][j+1] == 'O') check( i,j+1,board,vis);
        if(j-1>-1)
        if(board[i][j-1] == 'O') check( i,j-1,board,vis);
        
    }
    public void solve(char[][] board) {
        boolean[][] vis = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++)
        {    if(board[i][0] == 'O' && !vis[i][0])
             check(i,0,board,vis);

             if(board[i][board[0].length-1] == 'O' && !vis[i][board[0].length-1])
             check(i,board[0].length-1,board,vis);
             
        }
        for(int i=0;i<board[0].length;i++)
        {    if(board[0][i] == 'O' && !vis[0][i])
             check(0,i,board,vis);

             if(board[board.length-1][i] == 'O' && !vis[board.length-1][i])
             check(board.length-1,i,board,vis);
             
        }

        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(!vis[i][j]  && board[i][j]=='O')
                    board[i][j] = 'X';
             
        
    }
}
