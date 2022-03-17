import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] q = new int[100001];
    static int nodeNum = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int num;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(top()).append("\n");
                pop();
            } else {
                push(num);
            }
        }
        System.out.println(sb);
    }

    static void push(int x) {
        q[++nodeNum] = x;
        int now = nodeNum;
        int temp;
        while (now != 1) {
            int parent = now / 2;
            if (Math.abs(q[parent]) < Math.abs(q[now])) break;
            if (Math.abs(q[parent]) == Math.abs(q[now]) && q[parent] < q[now]) break;

            temp = q[now / 2];
            q[now / 2] = q[now];
            q[now] = temp;

            now /= 2;
        }
    }

    static int top() {
        return q[1];
    }


    static void pop() {
        int temp;
        int nowIdx = 1;

        q[1] = q[nodeNum];
        q[nodeNum] = 0;
        nodeNum--;
        if (nodeNum == -1) {
            nodeNum = 0;
            return;
        }
         while (nowIdx * 2 <= nodeNum) {

            int lNum = nowIdx * 2;
            int rNum = nowIdx * 2 + 1;
            int min = lNum;

            if (rNum <= nodeNum && Math.abs(q[lNum]) > Math.abs(q[rNum])) {
                min = rNum;
            }

            if (rNum <= nodeNum && Math.abs(q[lNum]) == Math.abs(q[rNum]) && q[lNum] > q[rNum]) {
                min = rNum;
            }

            temp = q[nowIdx];
            q[nowIdx] = q[min];
            q[min] = temp;

            nowIdx = min;
        }
    }
}
