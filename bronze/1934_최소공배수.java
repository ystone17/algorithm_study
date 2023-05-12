import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

     public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            System.out.println(lcm(a, b, gcd(a, b)));
        }
        
     }
     
    static int lcm(int a, int b, int gcd){
        return a * b / gcd;
    }
     
     static int gcd(int a, int b) {
         if( a < b) {
             int temp = a;
             a = b;
             b = temp;
         }
         
         
         while(b != 0) {
             int r = a % b;
             a = b;
             b = r;
         }
         
         return a;
     }
}
