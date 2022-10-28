import jdk.jshell.EvalException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static Map<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long key = Long.parseLong(br.readLine());
            Integer value = map.getOrDefault(key, 0);
            map.put(key, value + 1);
        }

        long res = 0;
        int cnt = 0;

        for (Long key : map.keySet()) {
            Integer value = map.get(key);

            if(value > cnt) {
                cnt = value;
                res = key;
            }

            if(value == cnt && key < res) {
                res = key;
            }
        }

        System.out.println(res);
    }
}
