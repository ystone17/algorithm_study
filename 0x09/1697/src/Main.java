import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] subinAndBrother = br.readLine().split(" ");

        int su = Integer.parseInt(subinAndBrother[0]);
        int bro = Integer.parseInt(subinAndBrother[1]);
        if(su == bro){
            System.out.println(0);
            return;
        }

        int[] dx = {1, -1, 0};
        int[] dist = new int[100001];
        Queue<Integer> q = new LinkedList<>();

        q.offer(su);

        while (!q.isEmpty()){
            int curr = q.poll();

            for (int i = 0; i < 3; i++) {
                int nx;
                if ( i == 2){
                    nx = curr * 2;
                } else{
                    nx = curr + dx[i];
                }
                if (nx == bro){
                    System.out.println(dist[curr] + 1 );
                    return;
                }


                if (nx < 0 || nx > 100000){
                    continue;
                }

                if (dist[nx] > 0){
                    continue;
                }

                dist[nx] = dist[curr] + 1;
                q.offer(nx);
            }
        }

    }
}
