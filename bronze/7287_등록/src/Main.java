import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException, InterruptedException {
//        URL url = new URL("https://www.acmicpc.net/user/ystone17");
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//
//        con.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36");
//        con.setRequestMethod("GET");
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//        String inputLine;
//
//        while ((inputLine = in.readLine()) != null) {
//            if (inputLine.contains("맞았습니다")) {
//                break;
//            }
//        }
//
//
//        inputLine = inputLine.substring(inputLine.indexOf("맞았습니다"));
//        inputLine = inputLine.substring(0, inputLine.indexOf("</span>"));
//        inputLine = inputLine.substring(inputLine.lastIndexOf(">") + 1);
//
//        System.out.println(inputLine);
//        System.out.println("ystone17");
//
//
//        in.close();
//        con.disconnect();

        System.out.println("775");
        System.out.println("ystone17");
    }
}
