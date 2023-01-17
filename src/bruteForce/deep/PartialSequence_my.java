package bruteForce.deep;
// https://www.acmicpc.net/problem/1182
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PartialSequence_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int S;
    static int[]numbers;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();

        numbers = new int[N+1];
        for (int i = 1; i <= N ; i++) numbers[i] = scan.nextInt();
    }
    static int ans;
    static boolean sum(List<Integer> sel){
        int sum = 0;
        if (sel.size() == 0) return false;
        for (Integer integer : sel) sum += integer;

        return sum == S;
    }
    static void rec_func(int k, List<Integer> sel) {
        if (k == N+1) {
            if (sum(sel)) ans++;
            return;
        }
//        if (sum(sel)) ans++; --> 이렇게 하면 틀림
        // 부분 수열을 다 구하고 계산을 해야지 중간에 하면 안된다.

        /**
         * 부분 수열을 구하는 문제 : 둘 중 하나만 선택하게 된다.
         * 밑에 방식으로 진행 근데 교안이 더 좋음
         **/
        sel.add(numbers[k]);
        rec_func(k+1, sel);
        sel.remove(sel.size()-1);

        rec_func(k+1, sel);

    }
    public static void main(String[] args) {
        input();

        ArrayList<Integer> arrayList = new ArrayList<>();
        rec_func(1, arrayList);

        System.out.println(ans);
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
