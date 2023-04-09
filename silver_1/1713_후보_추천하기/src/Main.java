import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int picNumber, likeNumber, picListSize;
    static int[] likeSeq, candidatePos;
    static Pic[] picList;


    public static void main(String[] args) throws IOException {
        picNumber = Integer.parseInt(br.readLine());
        likeNumber = Integer.parseInt(br.readLine());

        likeSeq = new int[likeNumber];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < likeNumber; i++) {
            likeSeq[i] = Integer.parseInt(st.nextToken());
        }

        candidatePos = new int[101];
        Arrays.fill(candidatePos, -1);
        picList = new Pic[picNumber];

        for (int time = 0; time < likeSeq.length; time++) {
            int candidate = likeSeq[time];

            if (candidatePos[candidate] != -1) {
                picList[candidatePos[candidate]].like++;
                continue;
            }

            if (picListSize < picNumber) {
                for (int i = 0; i < picList.length; i++) {
                    if (picList[i] == null) {
                        picList[i] = new Pic(candidate, 0, time);
                        candidatePos[candidate] = i;
                        picListSize++;
                        break;
                    }
                }
            } else {
                Pic base = picList[0];
                int changeNum = 0;

                for (int i = 0; i < picList.length; i++) {
                    if (base.like > picList[i].like || (base.like == picList[i].like) && base.time > picList[i].time) {
                        base = picList[i];
                        changeNum = i;
                    }
                }

                picList[changeNum] = new Pic(candidate, 0, time);
                candidatePos[candidate] = changeNum;
                candidatePos[base.candidate] = -1;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Pic pic : picList) {
            if (pic == null) continue;
            pq.add(pic.candidate);
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }

        System.out.println(sb);


    }

    static class Pic {
        int candidate;
        int like;
        int time;

        public Pic(int candidate, int like, int time) {
            this.candidate = candidate;
            this.like = like;
            this.time = time;
        }
    }
}
