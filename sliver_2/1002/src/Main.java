import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int[] input = new int[6];
            for (int i = 0; i < 6; i++) input[i] = Integer.parseInt(st.nextToken());

            double dist =  Math.sqrt((int)Math.pow(input[0] - input[3], 2) + (int)Math.pow(input[1] - input[4], 2));

            if (dist == 0) {
                if (input[2] == input[5]) sb.append(-1).append("\n");
                else sb.append(0).append("\n");
                continue;
            }

            int rSub = Math.abs(input[2] - input[5]);
            int rSum = Math.abs(input[2] + input[5]);

            if(rSum == dist || rSub == dist) {
                sb.append(1).append("\n");
            } else if (rSub < dist && dist < rSum) {
                sb.append(2).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
