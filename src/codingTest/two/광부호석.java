package codingTest.two;
// https://fastcampus.co.kr/courses/203934/clips/
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 투 포인터 문제
 *
 * 투포인터로 문제를 풀어서 투포인터의 시간 복잡도는 O(X + Y) 이다.
 *
 * 그리고 돌 때마다 한줄씩 확인을 해줘야 하는데 이건 다 합쳐서 o(N) 이다.
 * 그래서 O(X + Y) + o(N) 이다.
 * */
public class 광부호석 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Stone {
        public int to;
        public int weight;

        public Stone(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int N;
    static int C;
    static ArrayList<Stone>[] x;
    static ArrayList<Stone>[] y;

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();

        x = new ArrayList[100005];
        y = new ArrayList[100005];

        for (int i = 0; i <= 100001; i++) {
            x[i] = new ArrayList<>();
            y[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int v1 = scan.nextInt();

            x[x1].add(new Stone(y1, v1));
            y[y1].add(new Stone(x1, v1));
        }
    }
    static long max = Integer.MIN_VALUE;
    static int cnt = 0;
    static long current = 0;
    static int w = 0;
    static void twoPointer () {
        for (int h = 100000; h >= 1 ; h--) {
            if (cnt == C) max = Math.max(max , current);

            del(w, h);

            while (w <= 100000) {
                if (cnt >= C) break;
                    w ++;
                    add(w, h);
            }
        }
    }

    static void del(int x1, int y1) {
        for (Stone stone : y[y1]) {
            if (stone.to <= x1) {
                cnt --;
                current -= stone.weight;
            }
        }
    }

    static void add (int x1, int y1) {
        for (Stone stone : x[x1]) {
            if (stone.to <= y1) {
                cnt ++;
                current += stone.weight;
            }
        }
    }


    public static void main(String[] args) {
        input();
        twoPointer();
        System.out.println(max);
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
