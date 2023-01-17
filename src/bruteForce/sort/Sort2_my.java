package bruteForce.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/1015
public class Sort2_my {
    /**
     * 정렬 tip
     * 기존 인덱스를 가지고 간다.
     **/
    static class Elem implements Comparable<Elem>{
        int idx;
        int num;
        @Override
        public int compareTo(Elem o) {
            /**
             * java 의 object sort 는 stable sort 이기 때문에
             * idx 에 관해서는 따로 조건을 추가하지 않아도 된다.
             * 이유는 idx 는 어차피 오름차순으로 가고 그걸 유지 해준다.
             **/
            return num - o.num;
        }
    }
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Elem[] A;
    static int[] ans;
    static void input() {
        FastReader scan = new FastReader();

        N = scan.nextInt();
        A = new Elem[N];
        ans = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = new Elem();

            A[i].idx = i;
            A[i].num = scan.nextInt();
        }

    }

    static void sorting(){
        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            /**
             * 원래 index 에 바뀐 index 를 넣어놓는다.
             **/
            ans[A[i].idx] = i;
        }
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(' ');
        }
        System.out.println(sb.toString());

    }
    public static void main(String[] args) {
        input();

        sorting();
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
