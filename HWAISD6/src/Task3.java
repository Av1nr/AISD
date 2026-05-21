public class Task3 {
    static void main(String[] args) {

    }
    public static int maxUnidirectionalRoads(int[][] adjacencyMatrix) {
        int n = adjacencyMatrix.length;
        boolean[][] reachable = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                reachable[i][j] = (adjacencyMatrix[i][j] == 1);
            }
            reachable[i][i] = true;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    reachable[i][j] = reachable[i][j] || (reachable[i][k] && reachable[k][j]);
                }
            }
        }
        int count = 0;
        boolean[][] processed = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjacencyMatrix[i][j] == 1 && adjacencyMatrix[j][i] == 1) {
                    boolean hasAltPathIJ = false;
                    boolean hasAltPathJI = false;
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            if (reachable[i][k] && reachable[k][j] &&
                                    adjacencyMatrix[i][k] == 1 &&
                                    adjacencyMatrix[k][j] == 1) {
                                hasAltPathIJ = true;
                            }
                            if (reachable[j][k] && reachable[k][i] &&
                                    adjacencyMatrix[j][k] == 1 &&
                                    adjacencyMatrix[k][i] == 1) {
                                hasAltPathJI = true;
                            }
                        }
                    }
                    if (hasAltPathIJ || hasAltPathJI) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
