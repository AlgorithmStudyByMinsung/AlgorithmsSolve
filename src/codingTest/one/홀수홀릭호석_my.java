package codingTest.one;
// https://www.acmicpc.net/problem/20164
// 문제 시간 : 1시간 8분
// 점수 : 102/102
// 내가 푼 유형 : 브루트 포스 / 순열
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 완전 탐색이라도 순열로 푼다면 가능성이 있음
 * 이걸 시간복잡도를 계산하기는 어렵지만
 * 순열로 푸는 거기에 대충 계산하면 1초는 안됨
 * */
public class 홀수홀릭호석_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static String N;

    static void input() {
        N = scan.nextLine();
    }

    static int[] sel = new int[2];

    static Integer split(String n) {
        int sum = 0;

        String substring = n.substring(0, sel[0] + 1);
        String substring1 = n.substring(sel[0] + 1, sel[1] + 1);
        String substring2 = n.substring(sel[1] + 1, n.length());

        sum += Integer.parseInt(substring);
        sum += Integer.parseInt(substring1);
        sum += Integer.parseInt(substring2);

        return sum;
    }

    static void child(String n, int cnt, int select, List<Integer> sum) {
        if (cnt == 2) {
            sum.add(split(n));
            return;
        }
        for (int i = select + 1 ; i < n.length() - 1; i++) {
           sel[cnt] = i; cnt += 1;
           child(n, cnt, i, sum);
           cnt -= 1;
           sel[cnt] = 0;
        }
    }
    static Integer check(String n) {
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            if ((n.charAt(i) - 48) % 2 != 0) sum ++;
        }
        return sum;
    }
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static void pro(String n, int res) {
        if (n.length() == 1) {
            res += check(n);
            if (max < res) max = res;
            if (min > res) min = res;

        } else if (n.length() == 2) {
            res += check(n);
            int sum = (n.charAt(0) - 48) + (n.charAt(1) - 48);
            pro(Integer.toString(sum), res);

        } else if (n.length() > 2) {
            res += check(n);
            List<Integer> list = new ArrayList<>();

            child(n, 0, -1, list);

            for (Integer integer : list) {
                pro(Integer.toString(integer), res);
            }
        }
    }

    public static void main(String[] args) {
//        input();
//        pro(N, 0);
//        sb.append(min).append(' ').append(max);
//
//        System.out.println(sb);
//        
        int i = Integer.parseInt(String.valueOf('1'));
        System.out.println("i = " + i);
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
