import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] starFriends = star(sc.nextInt());
        for (char[] starFriend : starFriends) {
            System.out.println(new String(starFriend));
        }
    }

    static char[][] star(int n) {
        if (n == 3) {
            return new char[][]{
                    {'*', '*', '*'},
                    {'*', ' ', '*'},
                    {'*', '*', '*'}};
        }

        char[][] stars = new char[n][n];

        char[][] material = star(n / 3);

        fillStar(stars, material, n / 3, 0);
        fillStar(stars, material, n / 3, 1);
        fillStar(stars, material, n / 3, 2);

        return stars;
    }

    static void fillStar(char[][] stars, char[][] material, int size, int row) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size * 3; j++) {
                if (row == 1)
                    if (j >= size && j < size * 2) {
                        stars[i + row * size][j] = ' ';
                        continue;
                    }

                stars[i + row * size][j] = material[i][j % size];
            }
        }
    }
}
