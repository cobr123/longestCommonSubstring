import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public final class LCS {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		// for(int i = 0; i < 100000; ++i){
		test();
		// }
	}

	private static void log(Object obj) {
		System.out.println(obj);
	}

	private static void test() {
		String line;
		String firstLine = null;
		try (final BufferedReader br = new BufferedReader(new FileReader(
				"data2.txt"))) {
			int cnt = Integer.valueOf(br.readLine());
			for (int i = 0; i < cnt; ++i) {
				if ((line = br.readLine()) != null) {
					if (firstLine != null) {
						//final long startTime = System.nanoTime();
						firstLine = longestCommonSubstring(firstLine, line);
						//final long endTime = System.nanoTime();

						//final long duration = endTime - startTime;
						//log(duration);
					} else {
						firstLine = line;
					}
				}
			}
			log("longestCommonSubstring: '" + firstLine + "'");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String longestCommonSubstring(final String s1, final String s2) {
		final int[][] a = new int[s1.length() + 1][s2.length() + 1];
		int u = 0, v = 0;

		for (int i = 0; i < s1.length(); i++)
			for (int j = 0; j < s2.length(); j++)
				if (s1.charAt(i) == s2.charAt(j)) {
					a[i + 1][j + 1] = a[i][j] + 1;
					if (a[i + 1][j + 1] > a[u][v]) {
						u = i + 1;
						v = j + 1;
					}
				}
		return s1.substring(u - a[u][v], u);
	}
}