package assignment_ds;

import java.util.*;

public class EngagingCaoCao {

    private static final int[][] MAZE = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {2, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 3},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    private static final int ROWS = MAZE.length;
    private static final int COLS = MAZE[0].length;
    private static final int START = 2;
    private static final int EXIT = 3;

    private static List<Integer> path;

    public void engagingCCSelection() {
        path = findPath();
        displayPath();
    }

    private static List<Integer> findPath() {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        boolean[][] visited = new boolean[ROWS][COLS];

        int startRow = -1, startCol = -1;

        // Find the starting position
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (MAZE[row][col] == START) {
                    startRow = row;
                    startCol = col;
                    break;
                }
            }
        }

        if (startRow == -1 || startCol == -1) {
            return new ArrayList<>(); // No valid starting position found
        }

        // Perform BFS
        queue.offer(startRow * COLS + startCol);
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int currentPosition = queue.poll();
            int row = currentPosition / COLS;
            int col = currentPosition % COLS;

            // Check if the current position is the exit
            if (MAZE[row][col] == EXIT) {
                // Reconstruct the path from the exit to the starting position
                List<Integer> path = new ArrayList<>();
                int current = currentPosition;
                while (current != startRow * COLS + startCol) {
                    path.add(current);
                    current = parentMap.get(current);
                }
                path.add(startRow * COLS + startCol);
                Collections.reverse(path);
                return path;
            }

            // Explore adjacent positions
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];
                int newPosition = newRow * COLS + newCol;

                if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS && MAZE[newRow][newCol] != 1
                        && !visited[newRow][newCol]) {
                    queue.offer(newPosition);
                    visited[newRow][newCol] = true;
                    parentMap.put(newPosition, currentPosition);
                }
            }
        }

        return new ArrayList<>(); // No path found
    }

    private static void displayPath() {
        int[][] pathMatrix = new int[ROWS][COLS];

        // Initialize pathMatrix with the maze
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                pathMatrix[row][col] = MAZE[row][col];
            }
        }

        // Mark the path in pathMatrix
        for (int position : path) {
            int row = position / COLS;
            int col = position % COLS;
            pathMatrix[row][col] = 9; // Mark as path
        }

        // Display the path matrix
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(pathMatrix[row][col] + " ");
            }
            System.out.println("9 is the path");
        }
    }
}