public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution("a");
        System.out.println("answer = " + answer);
    }
}

class Solution {
    public int solution(String s) {
        if(s.length() == 1) return 1;

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            int j;
            int count = 1;
            String store = "";
            for (j = 0; j + i <= s.length(); j += i) {
                String substring = s.substring(j, j + i);
                if (store.equals("")) {
                    store = substring;
                } else if (store.equals(substring)) {
                    count++;
                } else {
                    if (count == 1) {
                        sb.append(store);
                    } else {
                        sb.append(count).append(store);
                    }

                    store = substring;
                    count = 1;
                }
            }
            if (count == 1) {
                sb.append(store);
            } else {
                sb.append(count).append(store);
            }

            if (j != s.length()) {
                sb.append(s.substring(j));
            }
            answer = Math.min(answer, sb.toString().length());
        }

        return answer;
    }
}
