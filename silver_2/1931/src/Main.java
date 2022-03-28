import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Ref> refList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            refList.add(new Ref(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(refList);

        int now = 0;
        int idx = 0;
        int res =0;
        while (idx < n) {
            if (refList.get(idx).st >= now) {
                now = refList.get(idx).et;
                res++;
            }
            idx++;
        }

        System.out.println(res);

    }
}

class Ref implements Comparable<Ref> {
    int st;
    int et;

    public Ref(int st, int et) {
        this.st = st;
        this.et = et;
    }

    @Override
    public int compareTo(Ref o) {
        if( et == o.et){
            return st - o.st;
        }
        return et - o.et;
    }
}
