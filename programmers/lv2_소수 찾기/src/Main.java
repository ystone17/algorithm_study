import java.util.HashMap;
import java.util.Map;

class Solution {
    char[] num;
    int[] visited;
    Map<Integer, Integer> used = new HashMap<>();
    int answer;

    public int solution(String numbers) {
        num = numbers.toCharArray();
        visited = new int[num.length];

        int size = num.length;
        while (size >=1){
            find(0, "", size--);
        }

        return answer;
    }

    void find(int depth, String total, int maxSize) {
        if (depth == maxSize) {
            int totalNum = Integer.parseInt(total);
            if(totalNum <= 1) return;
            for (int i = 2; i <= Math.sqrt(totalNum); i++) {
                if(totalNum % i == 0) return;
            }

            if( used.get(totalNum) == null){
                System.out.println("totalNum = " + totalNum);
                answer++;
                used.put(totalNum, 1);
            } else {
                System.out.println("totalNum[fault] = " + totalNum);
            }

            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            find(depth + 1, total + num[i], maxSize);
            visited[i] = 0;
        }
    }

}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int solution1 = solution.solution("0032");
        System.out.println("solution1 = " + solution1);
    }
}
