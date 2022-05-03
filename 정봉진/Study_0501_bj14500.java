package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Study_0501_bj14500 {
	static int M, N;
	static int arr[][];
	static boolean v[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int result;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String s = br.readLine();
		N = Integer.parseInt(s.split(" ")[0]);
		M = Integer.parseInt(s.split(" ")[1]);

		arr = new int[N][M];
		v = new boolean[N][M];
		result = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = true;
				find(i, j, 0, 0);
				v[i][j] = false;
				findT(i, j);
			}
		}

		System.out.println(result);

	}

	static void findT(int x, int y) {
		int sum = 0;
		// ㅏ
		if (x >= 0 && x < N - 2 && y >= 0 && y < M - 1) {
			sum = arr[x][y] + arr[x + 1][y] + arr[x + 2][y] + arr[x + 1][y + 1];
			result = Math.max(sum, result);
		}
		// ㅓ
		if (x >= 0 && x < N - 2 && y > 0 && y < M) {
			sum = arr[x][y] + arr[x + 1][y] + arr[x + 2][y] + arr[x + 1][y - 1];
			result = Math.max(sum, result);
		}
		// ㅗ
		if (x >= 0 && x < N - 1 && y > 0 && y < M - 1) {
			sum = arr[x][y] + arr[x + 1][y] + arr[x + 1][y - 1] + arr[x + 1][y + 1];
			result = Math.max(sum, result);
		}
		// ㅜ
		if (x >= 0 && x < N - 1 && y >= 0 && y < M - 2) {
			sum = arr[x][y] + arr[x][y + 1] + arr[x][y + 2] + arr[x + 1][y + 1];
			result = Math.max(sum, result);
		}

	}

	static void find(int x, int y, int len, int sum) {
		if (len >= 4) {
			result = Math.max(result, sum);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}

			if (!v[nx][ny]) {
				v[nx][ny] = true;
				find(nx, ny, len + 1, sum + arr[nx][ny]);
				v[nx][ny] = false;
			}
		}

	}

}
