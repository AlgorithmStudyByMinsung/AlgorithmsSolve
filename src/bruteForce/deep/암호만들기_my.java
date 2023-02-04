package bruteForce.deep;
// https://www.acmicpc.net/problem/1759
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int L;
    static int C;
    static char[] a;
    static boolean[] selected;
    static ArrayList<Character> mos;

    static void input() {
        L = scan.nextInt();
        C = scan.nextInt();
        selected = new boolean[C];
        mos = new ArrayList<>();

        mos.add('a');
        mos.add('e');
        mos.add('i');
        mos.add('o');
        mos.add('u');

        a = new char[C];

        /**
         * Char 를 저장하기
         * - nextLine 으로 받아서 분할하고
         * - char 배열에 저장하기
         * */
        String[] token = scan.nextLine().split(" ");

        /**
         * charAt 을 통해서 한다.
         * */
        for (int i = 0; i < C; i++) a[i] = token[i].charAt(0);
    }

    static void rec_func(int index, int cnt) {
        if (cnt == L) {
            int mo = 0; int ja = 0;

            for (int i = 0; i < C; i++) {
                if (selected[i]) {
                    if (mos.contains(a[i])) {
                        mo +=1;
                    }else ja +=1;
                }
            }

            if (mo >= 1 && ja >= 2) {
                for (int i = 0; i < C; i++) {
                    if (selected[i]) {
                        sb.append(a[i]);
                    }
                }
                sb.append('\n');
            }
            return;
        }
        /**
         * 이게 여기있어야 됨
         * - index 가 C이고 cnt 가 L 인경우에는 이게 먼저나오면 안됨
         * */
        if (index == C) return;

        /**
         * 재귀가 2개가 돌아가고 있다면 증가시킨 index 가 밑에도 영향
         * 따라서 원점으로 돌려야 함
         * */

        selected[index] = true;
        index += 1; cnt += 1;
        rec_func(index, cnt);
        index -= 1; cnt -= 1;

        selected[index] = false;
        index += 1;
        rec_func(index, cnt);

    }

    static void pro() {
        Arrays.sort(a);
        rec_func(0, 0);
        System.out.println(sb);
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
