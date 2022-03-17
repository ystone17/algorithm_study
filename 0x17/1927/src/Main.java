import java.io.*;

public class Main {
    static int[] q = new int[100001];
    static int index = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int num = 0;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                int top = top();
                sb.append(top).append("\n");
                pop();
            } else {
                push(num);
            }
        }
        System.out.println(sb);
    }

    static void push(int x) {
        int temp = 0;
        int now = index;
        q[now] = x;


        while (q[now / 2] > q[now]) {
            temp = q[now / 2];
            q[now / 2] = q[now];
            q[now] = temp;

            now /= 2;
        }
        index++;
    }

    static int top() {
        return q[1];
    }


    static void pop() {
        // 빈 q
        if (index == 1) return;

        // 노드 하나
        if (index == 2) {
            q[1] = 0;
            index--;
            return;
        }

        // 노드 2개 이상
        int temp = 0;
        int nIdx = 0;
        int nowIdx = 1;
        q[1] = q[index - 1];
        q[--index] = 0;

        while (nowIdx * 2 + 1 < index) {
            nIdx = Integer.MAX_VALUE;
            if (q[nowIdx] > q[nowIdx * 2] && q[nowIdx * 2] != 0) {
                nIdx = nowIdx * 2;
            }

            if (q[nowIdx] > q[nowIdx * 2 + 1] && q[nowIdx * 2 + 1] != 0) {
                if(q[nowIdx * 2] > q[nowIdx * 2 + 1]){
                    nIdx = nowIdx * 2 + 1;
                }
            }

            if (nIdx == Integer.MAX_VALUE) break;

            temp = q[nowIdx];
            q[nowIdx] = q[nIdx];
            q[nIdx] = temp;

            nowIdx = nIdx;
        }
    }
}

