import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] card, input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        card = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        input = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        for (int i = 0; i < m; i++) {
            sb.append(upper(input[i]) - lower(input[i])).append(" ");
        }

        System.out.println(sb);

    }

    static int upper(int k){
        int min = 0;
        int max = card.length;
        while (min < max){
            int mid = (min + max) / 2;

            if(card[mid] <=k){
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    static int lower(int k){
        int min = 0;
        int max = card.length;
        while (min < max){
            int mid = (min + max) / 2;

            if(card[mid] >=k){
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
    
}
