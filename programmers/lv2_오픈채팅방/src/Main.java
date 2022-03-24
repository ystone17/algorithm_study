import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] answer = solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
        String[] answer = solution.solution(new String[]{
                "Change uid1234 Muzi",
                "Change uid4567 Prodo",
                "Change uid1234 Prodo",
                "Change uid1234 Prodo",
                "Change uid4567 Ryan",
                "Enter uid4567 Ryan"});

        for (String s : answer) {
            System.out.println("s = " + s);
        }
    }
}

class Solution {
    Map<String, String> nickById = new HashMap<>();
    String[][] chat;

    public String[] solution(String[] record) {
        chat = new String[record.length][2];
        StringTokenizer st;
        int chatIdx = 0;

        for (String s : record) {
            st = new StringTokenizer(s);
            String oper = st.nextToken();
            String id = st.nextToken();

            if (oper.equals("Enter")) {
                chat[chatIdx][0] = oper;
                chat[chatIdx][1] = id;
                nickById.put(id, st.nextToken());
                chatIdx++;
            } else if (oper.equals("Leave")) {
                chat[chatIdx][0] = oper;
                chat[chatIdx][1] = id;
                chatIdx++;
            } else {
                nickById.put(id, st.nextToken());
            }
        }

        String[] answer = new String[chatIdx];
        for (int i = 0; i < chatIdx; i++) {
            if (chat[i][0].equals("Enter")) {
                answer[i] = String.format("%s님이 들어왔습니다.", nickById.get(chat[i][1]));
            } else {
                answer[i] = String.format("%s님이 나갔습니다.", nickById.get(chat[i][1]));
            }
        }
        return answer;
    }
}