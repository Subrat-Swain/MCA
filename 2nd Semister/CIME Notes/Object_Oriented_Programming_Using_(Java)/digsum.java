import java.util.*;
class digsum
{
 public static void main(String[]d)
  {
    int[][] m=new int[3][3];
    int suml=0,sumr=0;
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter matrix elements");
    for(int r=0;r<m.length;r++)
      for(int c=0;c<m[0].length;c++)
        m[r][c]=sc.nextInt();

   for(int r=0;r<m.length;r++)
      {
       for(int c=0;c<m[0].length;c++)
        { 
         System.out.print(m[r][c]+" ");
         }
        System.out.println();
       }

   for(int r=0;r<m.length;r++)
      {
       for(int c=0;c<m[0].length;c++)
        {
          if(r==c)
            suml+=m[r][c];
}
           sumr+=m[r][m.length-(r+1)];
         
       }
      System.out.println("left sum is:"+suml);
      System.out.println("right sum is:"+sumr); 
  }
}
