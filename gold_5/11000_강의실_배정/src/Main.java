import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static Class[] classes;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        classes = new Class[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            classes[i] = new Class(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(classes);

        int answer = 0;
        for (Class c : classes) {
           if(minHeap.isEmpty() || minHeap.peek() > c.s){
               answer++;
           } else{
               minHeap.poll();
           }
            minHeap.add(c.t);
        }

        System.out.println(answer);

    }

    static class Class implements Comparable<Class> {
        int s;
        int t;

        public Class(int s, int t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(Class o) {
            return Integer.compare(s, o.s);
        }
    }
}
