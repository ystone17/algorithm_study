import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static List<Opr> oprList;

    public static void main(String[] args) throws IOException {
        MyStack myStack = new MyStack();

        while (true) {
            oprList = new ArrayList<>();

            while (true) {
                Opr opr = new Opr(br.readLine());
                if (opr.opr.equals("QUIT")) {
                    System.out.println(sb);
                    return;
                } else if (opr.opr.equals("END")) {
                    break;
                }
                oprList.add(opr);
            }

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                int v = Integer.parseInt(br.readLine());
                myStack.init(v);
                boolean ok = true;
                for (Opr opr : oprList) {
                    switch (opr.opr) {
                        case "NUM":
                            ok = myStack.num(opr.num);
                            break;
                        case "POP":
                            ok = myStack.pop();
                            break;
                        case "INV":
                            ok = myStack.inv();
                            break;
                        case "DUP":
                            ok = myStack.dup();
                            break;
                        case "SWP":
                            ok = myStack.swp();
                            break;
                        case "ADD":
                            ok = myStack.add();
                            break;
                        case "SUB":
                            ok = myStack.sub();
                            break;
                        case "MUL":
                            ok = myStack.mul();
                            break;
                        case "DIV":
                            ok = myStack.div();
                            break;
                        case "MOD":
                            ok = myStack.mod();
                            break;
                    }

                    if (!ok) break;
                }

                if (!ok || myStack.size() != 1) {
                    sb.append("ERROR").append("\n");
                } else {
                    sb.append(myStack.stack.pop()).append("\n");
                }
            }

            br.readLine();
            sb.append("\n");
        }
    }

    static class MyStack {
        private Stack<Integer> stack;


        void init(int v) {
            stack = new Stack<>();
            stack.push(v);
        }

        int size() {
            return stack.size();
        }

        boolean num(int x) {
            stack.push(x);
            return true;
        }

        boolean pop() {
            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
            return true;
        }

        boolean inv() {
            if (stack.isEmpty()) {
                return false;
            }
            stack.push(stack.pop() * -1);
            return true;
        }

        boolean dup() {
            if (stack.isEmpty()) {
                return false;
            }
            stack.push(stack.peek());
            return true;
        }

        boolean swp() {
            if (stack.size() < 2) {
                return false;
            }
            int first = stack.pop();
            int second = stack.pop();
            stack.push(first);
            stack.push(second);
            return true;
        }

        boolean add() {
            if (stack.size() < 2) {
                return false;
            }
            int first = stack.pop();
            int second = stack.pop();

            int abs = Math.abs(first + second);
            if (abs > 1e9) {
                return false;
            }

            stack.push(first + second);
            return true;
        }

        boolean sub() {
            if (stack.size() < 2) {
                return false;
            }
            int first = stack.pop();
            int second = stack.pop();

            int abs = Math.abs(second - first);
            if (abs > 1e9) {
                return false;
            }

            stack.push(second - first);
            return true;
        }

        boolean mul() {
            if (stack.size() < 2) {
                return false;
            }
            long first = stack.pop();
            long second = stack.pop();

            long abs = Math.abs(first * second);

            if (abs > 1e9) {
                return false;
            }

            stack.push((int) (first * second));
            return true;
        }

        boolean div() {
            if (stack.size() < 2) {
                return false;
            }
            int first = stack.pop();
            int second = stack.pop();

            if (first == 0) {
                return false;
            }

            stack.push(second / first);
            return true;
        }

        boolean mod() {
            if (stack.size() < 2) {
                return false;
            }
            int first = stack.pop();
            int second = stack.pop();

            if (first == 0) {
                return false;
            }

            stack.push(second % first);
            return true;
        }
    }

    static class Opr {
        String opr;
        int num;

        public Opr(String s) {
            if (s.contains("NUM")) {
                String[] sArr = s.split(" ");
                opr = sArr[0];
                num = Integer.parseInt(sArr[1]);
            } else {
                opr = s;
            }
        }
    }
}

