/**
 * 문제의 조건을 잘 파악하는 것이 중요
 * 그 예시를 잘 파악을 해야한다.
 * 이 문제는 그래프 이론 문제이지만
 * 
 * 아무데도 못가게 된다면 더 이상 가면 안된다. <- 놓친 부분
 * */
class Solution {
    int[][] dir = new int[][] {{1 , 0}, {-1 , 0}, {0 , 1}, {0 , -1}};
    int[][] a;
    boolean[][] visit;
    int N; int M;
    int[] answer;
    int cnt;
    public int[] solution(String[][] boards) {
        answer = new int[boards.length];

        for (String[] board : boards) {
            // 배열 구성하기
            N = board.length;
            M = board[0].length();

            a = new int[board.length][board[0].length()];
            visit = new boolean[board.length][board[0].length()];

            for (int i = 0; i < board.length; i++) {
                String s = board[i];
                for (int j = 0; j < s.length(); j++) {
                    a[i][j] = s.charAt(j) - '0';
                }
            }
            // dfs
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (a[i][j] == 2) {
                        dfs(i , j);
                    }
                }
            }

            // check
            int ans = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (a[i][j] == 1 || a[i][j] == 2) {
                        if (! visit[i][j]) {

                            // 하나라도 false 있다면
                            ans = 0;

                        }
                    }
                }
            }

            answer[cnt] = ans;
            cnt ++;
            System.out.println();
        }


        return answer;
    }

    public void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {

                if (visit[nx][ny]) continue;
                if (a[nx][ny] == 0 || a[nx][ny] == 2) continue;

                dfs(nx, ny);
            }
        }
    }
}