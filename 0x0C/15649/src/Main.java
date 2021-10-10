import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] list;
    static int[] isUsed;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = sc.nextInt();
        M = sc.nextInt();
        list = new int[M];
        isUsed = new int[N + 1];

        bt(0);
        bw.flush();
        bw.close();
    }

    static void bt(int index) throws IOException {
        if (index == M) {
            for (int i : list) {
                bw.write(i + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isUsed[i] != 1) {
                list[index] = i;
                isUsed[i] = 1;
                bt(index + 1);
                isUsed[i] = 0;
            }

        }


    }
}
