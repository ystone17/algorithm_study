import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, size;
    static String s;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        size = Integer.parseInt(br.readLine());

        s = br.readLine();

        int idx = 0;
        int pNum = 0;
        int res = 0;
        while (idx <= s.length() - 3) {
            if(s.startsWith("IOI", idx)){
                pNum++;
                idx += 2;
            } else{
                if(pNum >= n){
                    res += pNum - n + 1;
                }
                pNum = 0;
                idx++;
            }
        }

        if(pNum >= n){
            res += pNum - n + 1;
        }

        System.out.println(res);

    }

}
