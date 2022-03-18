import javax.management.MBeanRegistrationException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int cassNum = 0;
        while (true) {
            cassNum++;

            Map<Integer, List<Integer>> graph = new HashMap<>();
            Map<Integer, Integer> outBound = new HashMap<>();
            Map<Integer, Integer> vertexMap = new HashMap<>();
            boolean isTree = true;
            int vNum, eNum = 0;
            while (true) {
                st = new StringTokenizer(br.readLine());
                int a = 0, b = 0;
                while (st.hasMoreTokens()) {
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    if (a == 0 && b == 0) break;
                    if (a == -1 && b == -1) {
                        bw.flush();
                        return;
                    }
                    List<Integer> orDefault = graph.getOrDefault(a, new ArrayList<>());
                    orDefault.add(b);
                    graph.put(a, orDefault);
                    eNum++;
                    vertexMap.put(a, 1);
                    vertexMap.put(b, 1);
                }
                if (a == 0 && b == 0) break;
            }

            if (graph.size() == 0) {
                bw.write(String.format("Case %d is a tree.\n", cassNum));
                st = new StringTokenizer(br.readLine());
                if (st.hasMoreTokens()) break;
                continue;
            }

            vNum = vertexMap.keySet().size();

            if (vNum == eNum + 1) {
                for (Integer a : graph.keySet()) {
                    for (Integer vertex : graph.get(a)) {
                        Integer outBoundNum = outBound.getOrDefault(vertex, 0);
                        if (++outBoundNum > 1) {
                            isTree = false;
                            break;
                        }
                        outBound.put(vertex, outBoundNum);
                    }
                    if (!isTree) {
                        break;
                    }
                }
            } else {
                isTree = false;
            }

            if (isTree) bw.write(String.format("Case %d is a tree.\n", cassNum));
            else bw.write(String.format("Case %d is not a tree.\n", cassNum));
            st = new StringTokenizer(br.readLine());
            if (st.hasMoreTokens()) break;

        }
        bw.flush();
        bw.close();
        br.close();


    }
}
