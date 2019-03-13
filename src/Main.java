public class Main {
        private static boolean isSafe(int[][] a, int row, int col) {
                for (int i = 0; i < col; i++) {
                        if (a[row][i] == 1) {
                                return false;
                        }
                }
                for (int i = row, j = col; i >= 0 && j >= 0; j--, i--)
                        if (a[i][j] == 1) {
                                return false;
                        }
                for (int i = row, j = col; j >= 0 && i < 4; i++, j--)
                        if (a[i][j] == 1)
                                return false;
                return true;
        }

        private static boolean solveNQ(int[][] a, int col) {
                if (col >= 4) {
                        return true;
                }
                for (int i = 0; i < 4; i++) {
                        if (isSafe(a, i, col)) {
                                a[i][col] = 1;
                                if (solveNQ(a, col + 1))
                                        return true;
                                a[i][col] = 0;
                        }
                }
                return false;
        }

        private static void print(int[][] a) {
                for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                                System.out.print(a[i][j] + "    ");
                        }
                        System.out.println("\n");
                }
        }

        public static void main(String... args) {
                int[][] a;
                a = new int[][]{{0, 0, 0, 0},
                                        {0, 0, 0, 0},
                                        {0, 0, 0, 0},
                                        {0, 0, 0, 0},
                };
                if (!solveNQ(a, 0)) {
                        System.out.println("Solution doesn't exist\n");
                }
                print(a);
        }
}
