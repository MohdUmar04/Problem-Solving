import java.util.*;

import javax.lang.model.util.ElementScanner6;
class Node{
    int val;
    Node left,right;
    Node(int v)
    {
        val=v;
        left=null;
        right=null;
    }
}
public class designbst{
    static Scanner sc=new Scanner(System.in);
    static void addvalue(int a,Node root){
        if(root==null){
            Node n=new Node(a);
            root=n;
        }
        else{
            if(root.val==a){
            System.out.print("Invalid value\n");
            return;
        }
            if(root.val>a){
                if(root.left==null)
                {
                    Node n=new Node(a);
                    root.left=n;
                }
                else
                addvalue(a, root.left);}
            else{
                if(root.right==null)
                {
                    Node n=new Node(a);
                    root.right=n;
                }
                else
                addvalue(a, root.right);}
        }
    }
    static void PreOrder(Node root)
    {
        if(root==null)
        return ;
        else
        {
            System.out.print(root.val+" ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }
    static void InOrder(Node root)
    {
        if(root==null)
        return ;
        else
        {
            InOrder(root.left);
            System.out.print(root.val+" ");
            InOrder(root.right);
        }
    }
    static void PostOrder(Node root)
    {
        if(root==null)
        return ;
        else
        {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.val+" ");
        }
    }
    public static void main(String args[]) {
        Node root=null;
        Node temp=root;
        System.out.println("1-Add value to BST");
        System.out.println("2-Delete value from BST");
        System.out.println("3-Traversal in BST");
        System.out.println("0-Terminate\n\n");
        int c=1,i=0;
        while(c!=0){
            System.out.println("Enter choice");
            c=sc.nextInt();
            switch(c){
                case 1:
                System.out.print("Enter Value - ");
                int a=sc.nextInt();
                i++;
                if(i==1)
                {
                    Node r=new Node(a);
                    root=r;
                }
                else
                addvalue(a,temp);
                break;
                case 2:
                System.out.println("Error 404");
                break;
                case 3:
                System.out.println("a-PreOrder Traversal");
                System.out.println("b-Inorder Traversal");
                System.out.println("c-PostOrder Traversal");
                String t=sc.next();
                if(t.equals("a"))
                PreOrder(root);
                else if(t.equals("b"))
                InOrder(root);
                else if(t.equals("c"))
                PostOrder(root);
                else
                System.out.println("Invalid Traversal");
                System.out.println();
                break;
                case 0:
                System.out.print("Terminated");
                break;
                default:
                System.out.print("Invalid");
                System.out.println();
            }
            System.out.println();
            temp=root;
        }
        sc.close();
    }
    
}
