import java.util.Scanner;

public class Main {

    static int N;
    static int[] isUsed;
    static int[] isUsed1;
    static int[] isUsed2;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        isUsed = new int[N];
        isUsed1 = new int[N * 2 -1];
        isUsed2 = new int[N * 2 -1];
        NQueen(0);
        System.out.println(cnt);
    }

    static void NQueen(int x){
        if(x == N){
            cnt++;
            return;
        }

        for (int y = 0; y < N; y++) {
            if(isUsed[y] !=1 && isUsed1[x+y] != 1 && isUsed2[x-y+N-1] != 1){
                isUsed[y] = 1;
                isUsed1[x+y] = 1;
                isUsed2[x-y+N-1] = 1;
                NQueen(x+1);
                isUsed[y] = 0;
                isUsed1[x+y] = 0;
                isUsed2[x-y+N-1] = 0;
            }
        }

    }
}
