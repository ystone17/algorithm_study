import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            TreeMap<Integer, Integer> tree = new TreeMap<>();

            int K = Integer.parseInt(br.readLine());

            for (int k = 0; k < K; k++) {

                st = new StringTokenizer(br.readLine());

                if (st.nextToken().equals("I")) {
                    int input = Integer.parseInt(st.nextToken());
                    tree.put(input, tree.getOrDefault(input, 0) + 1);
                    continue;
                }

                if (tree.isEmpty()) continue;

                int key;
                switch (st.nextToken()) {
                    case "1":
                        key = tree.lastKey();
                        if (tree.get(key) == 1) {
                            tree.remove(key);
                        } else {
                            tree.put(key, tree.get(key) - 1);
                        }
                        break;
                    case "-1":
                        key = tree.firstKey();
                        if (tree.get(key) == 1) {
                            tree.remove(key);
                        } else {
                            tree.put(key, tree.get(key) - 1);
                        }
                        break;
                }


            }

            if (tree.isEmpty()) {
                bw.write("EMPTY");
                bw.newLine();
            } else {
                bw.write(tree.lastKey() + " " + tree.firstKey());
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
