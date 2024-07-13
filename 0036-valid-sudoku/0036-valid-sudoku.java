class Solution {
    public Boolean inrow(char[][] b,int a,int r)
    {
        int f=0;
        for(int i=0;i<9;i++)
        {
            if(b[r][i]==a)
            f++;
        }
        return f==1?true:false;
    }
    public Boolean incol(char[][] b,int a,int c)
    {
        int f=0;
        for(int i=0;i<9;i++)
        {
            if(b[i][c]==a)
            f++;
        }
        return f==1?true:false;
    }
    public boolean inblock(char[][] b,char a,int r,int c){
        int i,j;
        if(r<=2){
        i=0;
        r=2;}
        else if(r<=5){
        r=5;
        i=3;}
        else{
        r=8;
        i=6;}
        if(c<=2){
        c=2;
        j=0;}
        else if(c<=5){
        c=5;
        j=3;}
        else{
        c=8;
        j=6;}
        int k=j;
        int f=0;
        for(;i<=r;i++)
        {
            for(j=k;j<=c;j++)
            {
                if(b[i][j]==a)
                f++;
            }
        }
        return f==1?true:false;

    }
    public boolean isValidSudoku(char[][] board){
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                continue;
                if(inrow(board,board[i][j],i)==false||incol(board,board[i][j],j)==false||inblock(board,board[i][j],i,j)==false)
                return false;
            }
        }
        return true;
    }
}