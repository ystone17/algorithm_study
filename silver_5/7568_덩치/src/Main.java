import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Human[] hArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        hArr = new Human[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            hArr[i] = new Human(h, w);
        }

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n; j++) {
                if(j == i) continue;
                if(hArr[i].height < hArr[j].height && hArr[i].weight < hArr[j].weight) count++;
            }
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }

    static class Human {
        int height;
        int weight;

        public Human(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
}
