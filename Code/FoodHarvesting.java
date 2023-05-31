package assignment_ds;

import java.util.*;

public class FoodHarvesting {

    private Map<Integer, List<Integer>> adjacencyList;
    private boolean[] visited;
    private List<List<Integer>> longestPaths;

    public FoodHarvesting() {
        // Initialize the instance variables with default values
        adjacencyList = new HashMap<>();
        visited = new boolean[10 + 1]; // Add 1 for 0-based indexing [0 - 10]
        longestPaths = new ArrayList<>();
    }

    public List<List<Integer>> findPaths(Map<Integer, List<Integer>> adjacencyList_temp, int currentNode, List<Integer> currentPath, int nodeWithoutFood) {
        visited[currentNode] = true;

        List<Integer> neighbors = adjacencyList_temp.get(currentNode); // = get value = get neighbours list
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!visited[neighbor] && neighbor != nodeWithoutFood) {
                    currentPath.add(neighbor);
                    findPaths(adjacencyList_temp, neighbor, currentPath, nodeWithoutFood);
                    currentPath.remove(currentPath.size() - 1);
                }
            }
        }

        visited[currentNode] = false;
        
        // Add possible path to longestPaths
        if (neighbors != null) {
            // normal case ~ node without food cant be passed through
            if (nodeWithoutFood >= 2 && nodeWithoutFood <= 9) {
                if (currentPath.size() == 8 && neighbors.contains(1)) { // Ensure the last node is connected to 1
                    longestPaths.add(new ArrayList<>(currentPath));
                }
            // special case ~ all nodes includes node without food have to be passed through
            } else {
                if (currentPath.size() == 9 && neighbors.contains(1)) { // Ensure the last node is connected to 1
                    longestPaths.add(new ArrayList<>(currentPath));
                }
            }
        }

        return longestPaths;
    }

    public void foodHarvestingSelection() {
        Scanner sc = new Scanner(System.in);

        adjacencyList.put(1, Arrays.asList(2, 3, 6, 10));
        adjacencyList.put(2, Arrays.asList(1, 4));
        adjacencyList.put(3, Arrays.asList(1, 4, 7));
        adjacencyList.put(4, Arrays.asList(2, 3, 5));
        adjacencyList.put(5, Arrays.asList(4, 6, 7));
        adjacencyList.put(6, Arrays.asList(1, 5, 7, 8));
        adjacencyList.put(7, Arrays.asList(5, 6, 8, 9));
        adjacencyList.put(8, Arrays.asList(6, 7, 9, 10));
        adjacencyList.put(9, Arrays.asList(7, 8, 10));
        adjacencyList.put(10, Arrays.asList(1, 8, 9));

        System.out.println("<<< Food Harvesting >>>\n");
        System.out.println("We need to depart from Sun Wu’s camp (Node 1) and harvest all of the food on each\n"
                + "node and back to Sun Wu’s camp without passing through a node twice.\n"
                + "This system will show the path.");
        System.out.println("\n--------------------------------------------------------\n");

        int nodeWithoutFood = 0;

        while (true) {

            System.out.print("Enter Node Without Food [-1 to exit]: ");

            try {
                nodeWithoutFood = sc.nextInt();
                if ((nodeWithoutFood < 2 || nodeWithoutFood > 10) && nodeWithoutFood != -1) {
                    throw new IllegalArgumentException("Invalid input. Allowed input:[-1],[2 ~ 10]\n");
                }
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Input must be an integer.\n");
                // Clear the invalid input
                sc.next();
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        sc.nextLine(); // Avoid Scanner skipping line problem

        if (nodeWithoutFood == -1) {
            return;
        }

        // Create a copy of adjacencyList to remain the original adjacencyList which will be used in special case
        Map<Integer, List<Integer>> adjacencyList_temp = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            Integer node = entry.getKey();
            List<Integer> neighbors = entry.getValue();

            List<Integer> neighborsCopy = new ArrayList<>(neighbors);
            adjacencyList_temp.put(node, neighborsCopy);
        }

        // Iterate over the entries of the HashMap of copy of adjacencyList
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList_temp.entrySet()) {
            List<Integer> list = new ArrayList<>(entry.getValue());

            // Check if the last contains the number to remove
            if (list.contains(nodeWithoutFood)) {
                // Remove the number from the list
                list.remove(Integer.valueOf(nodeWithoutFood));
            }

            // Update the value in the HashMap
            entry.setValue(list);
        }

        longestPaths.clear();
        
        // Find all possible paths
        List<List<Integer>> paths = findPaths(adjacencyList_temp, 1, new ArrayList<>(), nodeWithoutFood);

        // Special case ~ all nodes includes node without food have to be passed through
        if (paths.size() == 0) {
            System.out.println("\nPath must pass through Node " + nodeWithoutFood + " to harvest all the food.");
            // Replace nodeWithoutFood with number other than [1~10], so that no node will be removed
            // Use the original adjacencyList
            paths = findPaths(adjacencyList, 1, new ArrayList<>(), 11);
        }

        // Add node 1 to the beginning and end of each path
        for (List<Integer> path : paths) {
            path.add(0, 1);
            path.add(1);
        }

        // Print the paths
        System.out.println("\nPaths:");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

        System.out.println("\n--------------------------------------------------------\n");

        System.out.println("Enter to go back to Main Panel");
        sc.nextLine();
    }
}
