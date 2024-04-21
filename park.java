package pattern;
import java.util.*;
public class park{
    public final static int d=256;

    static void search (String pat,String text,int q)
    {
    int M=pat.length();
    int N=text.length();
    int i,j;
    int p=0; // hash value of pattern
    int t=0; // hash value of text
    int h=1;
     // The value of h would be "pow(d, M-1)%q"
    for (i=0;i<M-1;i++){
        h=(h*d)%q;
    }
    
      //calculate the value if of pattern and first window of the text
        for (i=0;i<M;i++){
            p=(d*p+pat.charAt(i))%q;
            t=(d*t+text.charAt(i))%q;
        }
        //slide the pattern to next by one
        for (i=0;i<=N-M;i++){
            if (p==t){
                for (j=0;j<M;j++){
                    if(text.charAt(i+j)!=pat.charAt(j))
                    break;
                }
                if (j==M)
                System.out.println("pattern found at index "+i);
            }
            if (i<N-M){
                t= (d*(t-text.charAt(i)*h)+text.charAt(i+M))%q;
                if(t<0)
                t=(t+q);
            }
        }
    }

    public static void main (String args []){
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";
 
        // A prime number
        int q = 101;
 
        // Function Call
        search(pat, txt, q);
    }
}
