import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[123456 * 2 + 1];
        arr[1] = 0;
        arr[2] = 1;

        for (int i = 3; i < arr.length; i++) {
            if(i % 2 ==0 || !isPrime(i)) arr[i] = arr[i - 1];
            else arr[i] = arr[i - 1] + 1;
        }

        while (true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            sb.append(arr[2 * n] - arr[n]).append("\n");
        }
        System.out.println(sb);

    }

    static boolean isPrime(int k){
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if(k % i == 0) return false;
        }
        return true;
    }

}
