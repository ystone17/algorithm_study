import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Node[] arr = new Node[8];
    static int[] number = new int[5];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 8; i++) {
            arr[i] = new Node(i + 1, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr);

        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += arr[i].result;
            number[i] = arr[i].n;
        }

        Arrays.sort(number);

        System.out.println(total);
        for (int i : number) {
            System.out.printf("%d ", i);
        }
    }

    static class Node implements Comparable<Node> {
        int n;
        int result;

        public Node(int n, int result) {
            this.n = n;
            this.result = result;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.result, result);
        }
    }
}
