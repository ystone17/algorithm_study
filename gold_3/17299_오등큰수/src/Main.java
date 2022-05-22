import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] countSort = new int[1_000_000 + 1];
    static int[] A, NGF;
    static int n;

    public static void main(String[] args) throws IOException {
        read();
//        dp();
        stack();
        for (int i : NGF) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void dp() {
        NGF[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (countSort[A[i]] < countSort[A[i + 1]]) {
                NGF[i] = i + 1;
            } else if (countSort[A[i]] == countSort[A[i + 1]]) {
                NGF[i] = NGF[i + 1];
            } else{
                int next = NGF[i + 1];
                while (next != -1){
                    if (countSort[A[i]] < countSort[A[next]]) {
                        NGF[i] = next;
                        break;
                    } else if (countSort[A[i]] == countSort[A[next]]) {
                        NGF[i] = NGF[next];
                        break;
                    }
                    next = NGF[next];
                }
                if(NGF[i] == 0) NGF[i] = -1;
            }
        }

        for (int i = 0; i < NGF.length; i++) {
            if(NGF[i] != -1) {
                NGF[i] = A[NGF[i]];
            }
        }
    }

    private static void stack() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && countSort[A[i]] > countSort[A[stack.peek()]]){
                NGF[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            NGF[stack.pop()] = -1;
        }

    }

    private static void read() throws IOException {
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        NGF = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            countSort[num]++;
            A[i] = num;
        }
    }

    private static void printArr() {
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%d ", A[i]);
        }
        System.out.println(

        );

        for (int i = 0; i < A.length; i++) {
            System.out.printf("%d ", countSort[A[i]]);
        }
    }
}
