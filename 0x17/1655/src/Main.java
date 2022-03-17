import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int num;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            if (maxHeap.isEmpty()) {
                maxHeap.add(num);
            } else if (minHeap.isEmpty()) {
                if(maxHeap.peek() > num) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            } else if(num <= maxHeap.peek()){
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            while (maxHeap.size() < minHeap.size()){
                maxHeap.add(minHeap.poll());
            }

            while (maxHeap.size() - minHeap.size() > 1){
                minHeap.add(maxHeap.poll());
            }

            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
