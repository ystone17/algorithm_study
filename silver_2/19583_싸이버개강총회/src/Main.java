import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Time startTime, endTime, streamEndTime;
    static Set<String> readyMember = new HashSet<>();
    static Set<String> endMember = new HashSet<>();
    static int n;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        startTime = new Time(st.nextToken());
        endTime = new Time(st.nextToken());
        streamEndTime = new Time(st.nextToken());

        var s = "";
        while ((s = br.readLine()) != null) {
            st = new StringTokenizer(s);
            var t = new Time(st.nextToken());
            var name = st.nextToken();

            if (t.before(startTime)) {
                readyMember.add(name);
                continue;
            }

            if (t.after(endTime) && t.before(streamEndTime)) {
                endMember.add(name);
            }
        }

        for (String name : endMember) {
            if (readyMember.contains(name)) {
                n++;
            }
        }

        System.out.println(n);
    }

    static class Time {
        int h;
        int m;

        public Time(String timeStr) {
            var split = timeStr.split(":");
            h = Integer.parseInt(split[0]);
            m = Integer.parseInt(split[1]);
        }

        public boolean before(Time t) {
            if (this.h < t.h) {
                return true;
            }

            return this.h == t.h && this.m <= t.m;
        }

        public boolean after(Time t) {
            if (this.h > t.h) {
                return true;
            }

            return this.h == t.h && this.m >= t.m;
        }
    }
}
