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
                if (nodeWithoutFood < 2 && nodeWithoutFood != -1 || nodeWithoutFood > 10 && nodeWithoutFood != -1) {
                    throw new IllegalArgumentException("Invalid input. Allowed input:[2 ~ 10]\n");
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
        sc.nextLine( );//avoid Scanner skipping line problem

        if (nodeWithoutFood == -1) {
            return;
        }

        path = new ArrayList<>();
        List<Integer> path = findPath(1, new ArrayList<>());

        int[] nodeCannotWithout = {4,8,6,10};

        // Remove the node without food if present
        boolean canRemove= true;
        for(int i = 0; i<nodeCannotWithout.length;i++){
            if (nodeCannotWithout[i]==nodeWithoutFood) {
                canRemove= false;
            }
        }
        if(canRemove){
            path.remove(Integer.valueOf(nodeWithoutFood));
        }
        else{
            System.out.println("Path must contain Node "+nodeWithoutFood+" to connect all the food.");
        }

        // Print the path
        System.out.println("\nPath:");
        System.out.print(startNode + " -> ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.print(startNode + "\n");

        System.out.println("\n--------------------------------------------------------\n");

        System.out.println("Enter to go back to Main Panel");
        sc.nextLine();
    }

}
