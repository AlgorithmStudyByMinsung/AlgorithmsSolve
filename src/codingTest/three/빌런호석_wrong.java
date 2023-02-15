package codingTest.three;
// https://www.acmicpc.net/problem/22251
// 난 무조건 부르트 포스를 순열이나 조합으로만 풀어야 한다고 생각을 했다.
// 하지만 아니다.
/**
 * 조합이 여러개 --> 조합을 여러번 돌리는게 아니라 2의 n 승이다.
 * */
import java.io.*;
import java.util.StringTokenizer;

public class 빌런호석_wrong {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class edge {
        public int x;
        public int y;

        public edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int K;
    static int P;
    static String X;
    static boolean[][] target;
    static int ans;
    static boolean[][] numbers =
            {
                    {true, true, true, false, true, true, true} // 0
                    , {false, false, true, false, false, false, true} // 1
                    , {false, true, true, true, true, true, false} // 2
                    , {false, true, true, true, false, true, true} // 3
                    , {true, false, true, true, false, false, true} // 4
                    , {true, true, false, true, false, true, true} // 5
                    , {true, false, false, true, true, true, true} // 6
                    , {true, true, true, false, false, false, true} // 7
                    , {true, true, true, true, true, true, true} // 8
                    , {true, true, true, true, false, false, true} // 9
    };
    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        P = scan.nextInt();
        X = scan.next();

        target = new boolean[X.length()][7];
        for (int i = 0; i < X.length(); i++) {
            target[i] = numbers[X.charAt(i) - '0'];
        }
    }
    static void bruteForce(int x, int y, edge[] sel, int cnt, int max) {
        if (max == cnt) {
            boolean[][] tmp = new boolean[X.length()][7];
            for (edge edge : sel) {
                tmp[edge.x] = target[edge.x];
                tmp[edge.x][edge.y] = !target[edge.x][edge.y];
            }
            int res = -1;
            for (boolean[] tar : tmp) {
                if (! check(tar)) res = 1;
            }
            if (res == -1) ans ++;
            return;
        }
        if (cnt > max) return;

        for (int i = x; i < X.length(); i++) {
            for (int j = (i == x) ? y : 0 ; j <= 6; j++) {
                sel[cnt] = new edge(x, y);

                cnt ++;
                bruteForce(i, j, sel, cnt, max);
                cnt --;
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= P ; i++) {
            edge[] sel = new edge[i];

            bruteForce(0, 0, sel, 0, i);
        }

        System.out.println(ans);
    }


    static boolean check(boolean[] chk) {
        for (int i = 0; i < 10; i++) {
            int cnt = -1;
            for (int j = 0; j <= 6; j++) {
                if (numbers[i][j] != chk[j]) cnt = 1;
            }
            if (cnt == -1) return true;
        }
        return false;
    }



    public static void main(String[] args) {
        input();
        pro();
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
