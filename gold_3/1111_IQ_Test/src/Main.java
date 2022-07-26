import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(n == 1){
            sb.append("A");
            System.out.println(sb);
            return;
        }

        Set<Integer> set = new HashSet<>();

        for (int a = -200; a <= 200; a++) {
            int b = arr[1] - arr[0] * a;
            boolean ok = true;
            for (int i = 2; i < arr.length; i++) {
                if (b != arr[i] - arr[i - 1] * a) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                set.add(arr[n - 1] * a + b);
            }
        }

        if(set.size() == 0){
            sb.append("B");
        } else if(set.size() == 1){
            sb.append(set.toArray()[0]);
        } else{
            sb.append("A");
        }

        System.out.println(sb);
    }
}
