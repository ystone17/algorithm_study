import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] vm = new int[N][2];


        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            vm[n][1] = Integer.parseInt(st.nextToken());
            vm[n][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(vm, Comparator.comparingInt(a -> a[0]));

        TreeMap<Integer, Integer> bag = new TreeMap<>();

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            bag.merge(Integer.parseInt(st.nextToken()), 1, Integer::sum);
        }

        long res = 0;

        for (int i = vm.length - 1; i >= 0; i--) {
            Integer muge = bag.ceilingKey(vm[i][1]);
            if (muge == null) continue;

            if(bag.get(muge) == 1){
                bag.remove(muge);
            } else {
                bag.merge(muge, -1, Integer::sum);
            }

            res += vm[i][0];
        }

        System.out.println(res);


    }
}
