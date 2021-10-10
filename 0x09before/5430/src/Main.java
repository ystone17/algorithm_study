import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testNum = Integer.parseInt(br.readLine());
        Deque<String> q = new LinkedList<>();
        boolean isReversed;
        boolean errFlag;
        for (int i = 0; i < testNum; i++) {
            q.clear();
            isReversed = false;
            errFlag = false;

            String[] func = br.readLine().split("");
            int arrSize = Integer.parseInt(br.readLine());
            String temp = br.readLine().replace("[", "").replace("]", "");
            String[] arr = temp.split(",");

            if (arrSize != 0){
                for (String a : arr) {
                    q.offer(a);
                }
            }

            for (String f : func) {
                if (f.equals("D")) {
                    if (q.isEmpty()) {
                        errFlag = true;
                        break;
                    } else {
                        Main.Poll(q, isReversed);
                    }
                } else {
                    isReversed = !isReversed;
                }
            }
            if (errFlag) {
                System.out.print("error\n");
                sb.setLength(0);
            } else {
                Main.Print(q, isReversed, sb);
                sb.setLength(0);
            }
        }
    }

    static String Poll(Deque<String> q, boolean isReversed) {
        if (isReversed) {
            return q.pollLast();
        } else {
            return q.poll();
        }
    }

    static void Print(Deque<String> q, boolean isReversed, StringBuilder sb) {
        sb.append("[");
        String[] ele = new String[q.size()];
        int i = 0;
        while (!q.isEmpty()) {
            ele[i] = Main.Poll(q,isReversed);
            i++;
        }
        sb.append(String.join(",",ele));
//        sb.deleteCharAt(sb.toString().length() - 1);
        sb.append("]").append("\n");
        System.out.printf("%s", sb.toString());
        sb.setLength(0);
    }


}
