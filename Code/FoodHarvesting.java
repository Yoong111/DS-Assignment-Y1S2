package assignment_ds;

import java.util.*;

public class FoodHarvesting {
    private Map<Integer, List<Integer>> adjacencyList;
    private boolean[] visited;
    private List<Integer> path;
    private int startNode;

    public FoodHarvesting() {
        // Initialize the instance variables with default values
        adjacencyList = new HashMap<>();
        startNode = 1;
        visited = new boolean[10 + 1]; // Add 1 for 0-based indexing
        path = new ArrayList<>();
    }

    public List<Integer> findPath(int currentNode, List<Integer> currentPath) {
        visited[currentNode] = true;

        List<Integer> neighbors = adjacencyList.get(currentNode);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    currentPath.add(neighbor);
                    findPath(neighbor, currentPath);
                    currentPath.remove(currentPath.size() - 1);
                }
            }
        }

        if (currentPath.size() > path.size()) {
            path = new ArrayList<>(currentPath);
        }

        visited[currentNode] = false;

        return path;
    }

    public void foodHarvestingSelection() {
        Scanner sc = new Scanner(System.in);

        // Example input: adjacency list and node without food
        adjacencyList.put(1, Arrays.asList(2, 3, 6, 10));
        adjacencyList.put(2, Arrays.asList(1, 4));
        adjacencyList.put(3, Arrays.asList(1, 4, 7));
        adjacencyList.put(4, Arrays.asList(2, 3, 5));
        adjacencyList.put(5, Arrays.asList(4, 6, 7));
        adjacencyList.put(6, Arrays.asList(1, 5, 7, 8));
        adjacencyList.put(7, Arrays.asList(3, 5, 6, 8, 9));
        adjacencyList.put(8, Arrays.asList(6, 7, 9, 10));
        adjacencyList.put(9, Arrays.asList(7, 8, 10));
        adjacencyList.put(10, Arrays.asList(1, 8, 9));

        System.out.print("Node Without Food: ");
        int nodeWithoutFood = sc.nextInt();

        path = new ArrayList<>();
        List<Integer> path = findPath(1, new ArrayList<>());

        // Remove the node without food if present
        if (path.contains(nodeWithoutFood)) {
            path.remove(Integer.valueOf(nodeWithoutFood));
        }

        // Print the path
        System.out.println("\nPath:");
        System.out.print(startNode + " ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.print(startNode+"\n");
    }

}
