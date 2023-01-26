package graph;
// https://www.acmicpc.net/problem/2667
import java.io.*;
import java.util.*;

public class Two_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem {
        int x;
        int y;

        public Elem(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static String[] homes;
    static boolean visited[][];
    static void input() {
        N = scan.nextInt();
        homes = new String[N];
        visited = new boolean[N][N];

        for (int i = 0; i < N ; i++) {
            homes[i] = scan.next();
        }

    }
    static List<Elem> getDegree(Elem elem) {
        List<Elem> degree = new ArrayList<>();

        int x = elem.x;
        int y = elem.y;

        if (x-1 >=0 && y >=0 && x -1 <N && y <N ){
            if (homes[x -1].charAt(y) == '1') degree.add(new Elem(x -1, y));
        }
        if (x+1 >=0 && y >=0 && x +1 <N && y <N){
            if (homes[x +1].charAt(y) == '1') degree.add(new Elem(x +1, y));
        }
        if (x >=0 && y -1>=0 && x <N && y -1 <N){
            if (homes[x].charAt(y -1) == '1') degree.add(new Elem(x, y -1));
        }
        if (x >=0 && y +1>=0 && x <N && y +1 <N){
            if (homes[x].charAt(y +1) == '1') degree.add(new Elem(x, y +1));
        }

        return degree;
    }
    static void pro() {
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();

        Queue<Elem> queue = new LinkedList<>();

        for (int i = 0; i <N ; i++) {
            String home = homes[i];

            for (int j = 0; j < home.length() ; j++) {
                char charAt = home.charAt(j);

                if (visited[i][j]) continue;
                if (charAt == '0') continue;

                queue.add(new Elem(i, j));
                visited[i][j] = true; // 처음 visit check!!

                int sum =0;

                while (!queue.isEmpty()) {

                    Elem poll = queue.poll();

                    for (Elem elem : getDegree(poll)) {
                        if (visited[elem.x][elem.y]) continue;

                        queue.add(new Elem(elem.x, elem.y));
                        visited[elem.x][elem.y] = true; // 자식들 visit check !!
                    }
                    sum ++;
                }
                cnt ++;
                ans.add(sum);
            }

        }
        sb.append(cnt).append('\n');

        Collections.sort(ans);
        for (Integer integer : ans) {
            sb.append(integer).append('\n');
        }
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
