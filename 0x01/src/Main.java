import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int[] a = new int[Integer.parseInt(st.nextToken())];
//        int[] b = new int[Integer.parseInt(st.nextToken())];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < a.length; i++) {
//            a[i] = Integer.parseInt(st.nextToken());
//        }
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < b.length; i++) {
//            b[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int aIdx = 0;
//        int bIdx = 0;
//
//
//        for (int i = 0; i < a.length + b.length; i++) {
//            if (aIdx == a.length) {
//                bw.write(b[bIdx++] + " ");
//            } else if (bIdx == b.length) {
//                bw.write(a[aIdx++] + " ");
//            } else if (a[aIdx] < b[bIdx]) {
//                bw.write(a[aIdx++] + " ");
//            } else {
//                bw.write(b[bIdx++] + " ");
//            }
//        }
//
//        bw.flush();
//        br.close();
//        bw.close();
        mergeSort m = new mergeSort();
    }

}

class mergeSort {
    int[] target = new int[]{5,8,3,1,2,3,4,9,5,4,6,8};
    int[] temp = new int[100];

    public mergeSort() {
        sort(target, 0, target.length - 1);
        for (int i : target) {
            System.out.printf("%d ",i);
        }
    }

    void sort(int[] t, int first, int end) {
        if (first == end) {
            return;
        }

        sort(t, first, (first + end) / 2);
        sort(t, (first + end) / 2 + 1, end);
        merge(t, first, end);
    }

    void merge(int[] t, int first, int end) {

        int mid = (first + end) / 2;
        int f = first;
        int e = mid + 1;
        for (int i = first; i < end + 1; i++) {
            if (f == mid + 1) {
                temp[i] = t[e++];
            } else if (e == end + 1) {
                temp[i] = t[f++];
            } else if (t[f] <= t[e]) {
                temp[i] = t[f++];
            } else {
                temp[i] = t[e++];
            }
        }

        for (int i = first; i < end + 1; i++) {
            t[i] = temp[i];
        }

    }

}
