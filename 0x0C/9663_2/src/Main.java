import java.util.Scanner;

public class Main {
    static int res = 0, n;
    static int[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        used = new int[n + 1];
        queen(1);
        System.out.println(res);
    }

    static void queen(int rowNum) {
        if (rowNum == n + 1) {
            res++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i] == 0) {
                used[i] = rowNum;
                boolean ok = true;
                for (int j = 1; j <= n; j++) {
                    if (j != i && used[j] != 0) {
                        if (used[j] + j == used[i] + i || used[j] - j == used[i] - i) {
                            ok = false;
                            break;

                        }
                    }
                }
                if (ok) {
                    queen(rowNum + 1);
                }
                used[i] = 0;


            }
        }


    }

}

/*
 static void queen(int rowNum) {
        if (rowNum == n) {
            for (int i = 0; i < n; i++) {
                if (used[i] != 0 && rowNum - i == used[i] - i && rowNum + i == used[i] + i) {
                    res++;
                    return;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (used[i] == 0 ) {
                for (int j = 0; j < n; j++) {
                    if( rowNum - i != used[i] - i && rowNum + i != used[i] + i){

                    }
                }
                used[i] = rowNum;
                queen(rowNum + 1);
                used[i] = 0;
            }
        }
    }
 */