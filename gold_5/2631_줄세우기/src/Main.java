import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] child, lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        child = new int[n];
        lis = new int[n];

        for (int i = 0; i < n; i++) {
            child[i] = Integer.parseInt(br.readLine());
        }

        int index = 0;
        lis[0] = child[0];

        for (int i = 1; i < n; i++) {
            if(lis[index] < child[i]) {
                lis[++index] = child[i];
            } else{
                lis[lower(child[i], index)] = child[i];
            }
        }

        System.out.println(n - (index + 1));
    }

    static int lower(int k, int index) {
        int left = 0;
        int right = index;

        while (left < right){
            int mid = (left + right) / 2;

            if(lis[mid] >=  k ){
                right = mid;
            } else{
                left = mid + 1;
            }
        }

        return left;
    }
}
