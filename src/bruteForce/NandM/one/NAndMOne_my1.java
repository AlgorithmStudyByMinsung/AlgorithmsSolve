package bruteForce.NandM.one;
// https://www.acmicpc.net/problem/15649
import java.io.*;
import java.util.StringTokenizer;

public class NAndMOne_my1 {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
    }

    static int N, M;
    static int[] selected;
    static void rec_fun( int k) {
        if (k == M+1){
            for (int i = 1; i <=M ; i++) sb.append(selected[i]).append(' ');

            sb.append('\n');
            return;
        }
        for (int i = 1; i <=N ; i++) {
            boolean isUsed = false;
            // --> 이부분에 대한 시간 복잡도??
            for (int j = 1; j <selected.length ; j++) if (selected[j] == i) isUsed = true;

            if (isUsed) continue;

            selected[k] = i;
            rec_fun(k+1);
            /**
             * 이게 static 으로 되어있는 매개 변수로 들어가 있던
             * 다시 돌아올 때 초기화를 시켜줘야한다.
             **/
            selected[k] = 0;
        }
    }
    public static void main(String[] args) {
        input();

        rec_fun(1);
        System.out.println(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
