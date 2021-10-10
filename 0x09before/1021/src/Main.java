import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeAndNum = br.readLine().split(" ");
        int[] target = new int[Integer.parseInt(sizeAndNum[1])];
        int idx = 0;
        for(String s : br.readLine().split(" ")){
            target[idx++] = Integer.parseInt(s);
        }
        Deque<Integer> q = new LinkedList<>();

        for (int i = 1; i < Integer.parseInt(sizeAndNum[0]) + 1; i++) {
            q.offerLast(i);
        }

        int res = 0;

        for (int i = 0; i < Integer.parseInt(sizeAndNum[1]); i++) {
            int cnt = 0;
            while (q.peekFirst() != target[i]){
                    int temp = q.poll();
                    q.offer(temp);
                cnt++;
            }

            if(q.size() - cnt < cnt){
                cnt = q.size()-cnt;
            }
            res += cnt;
            q.pollFirst();
        }

        System.out.printf("%d",res);

    }
}
