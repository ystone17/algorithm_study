import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static List<Integer> copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        copy = new ArrayList<>(set);
        Collections.sort(copy);

        for (int j : arr) {
            sb.append(lower(j)).append(" ");
        }
        System.out.println(sb);
    }

    static int lower(int num) {

        int left = 0;
        int right = copy.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (copy.get(mid) >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return left;
    }

}
