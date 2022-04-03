import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        if(start == 1){
            for (int i = 0; i < 7; i++) {
                int next = Integer.parseInt(st.nextToken());
                if(next != ++start) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("ascending");
        } else if(start == 8){
            for (int i = 0; i < 7; i++) {
                int next = Integer.parseInt(st.nextToken());
                if(next != --start) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }
}
