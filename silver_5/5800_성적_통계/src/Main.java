import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int number = 0; number < n; number++) {
            st = new StringTokenizer(br.readLine());
            int scoreNumber = Integer.parseInt(st.nextToken());
            int[] score = new int[scoreNumber];
            for (int i = 0; i < scoreNumber; i++) {
                score[i] = Integer.parseInt(st.nextToken());
            }
            Class c = new Class(number + 1, score);
            c.print();
        }

        System.out.println(sb);
    }

    static class Class {
        int number;
        int[] score;

        public Class(int number, int[] score) {
            this.number = number;
            this.score = score;

            Arrays.sort(score);
        }

        public void print() {
            sb.append("Class ").append(number).append("\n");
            sb.append("Max ").append(score[score.length-1]).append(", ");
            sb.append("Min ").append(score[0]).append(", ");
            sb.append("Largest gap ").append(getGap()).append("\n");
        }

        int getGap() {
            int gap = 0;
            for (int i = 1; i < score.length; i++) {
                gap = Math.max(gap, score[i] - score[i - 1]);
            }

            return gap;
        }
    }
}
