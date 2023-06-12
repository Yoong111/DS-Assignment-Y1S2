package assignment_ds;

import java.text.DecimalFormat;
import java.util.*;

import static assignment_ds.AttackAdvanced.*;

public class AttackSimulation {

    public void attackSelection() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("<<< Enemy Attack Simulation >>>\n");
            System.out.print("\nWelcome to the Enemy Attack Simulation system!\n");
            System.out.print(
                            "Before the Battle of the Red Cliff, Cao Cao had also built a fortress on the battlefield as\n" +
                            "their headquarters. The path to the enemy fortress is full of mazes and impending danger.\n" +
                            "But with the correct strategy and algorithm, surely we can defeat CaoCao with no sweat.\n\n");

            System.out.print("1 [Normal version] Enemy Fortress Attack Simulation\n");
            System.out.print("    ~ Display all possible paths to reach enemy's camp (BFS algorithm)\n");
            System.out.print("    ~ Display the shortest path/s to reach enemy's camp\n\n");

            System.out.print("2 [Advanced version] Enemy Fortress Attack Simulation\n");
            System.out.print("    ~ Display the best path with shortest time to reach enemy's camp (Djikstra's algorithm)\n");
            System.out.print("    ~ Choose one from 3 generals to lead the troupe\n");
            System.out.print("    ~ Each general will have different speeds based on the road condition of the map\n\n");

            System.out.println("-1 Exit Page");
            System.out.print("\nPlease Select: ");

            String opt = sc.nextLine();

            System.out.println("\n--------------------------------------------------------\n");

            switch (opt) {
                case "1": //normal
                    System.out.print("<<<< [Normal] Enemy Fortress Attack Simulation >>>>\n");
                    System.out.print("~ Display all possible paths to reach enemy's camp (BFS algorithm)\n");
                    System.out.print("~ Display the shortest path/s to reach enemy's camp\n\n");
                    attackNormal();
                    System.out.print("\nEnter to go back to \"Attack Simulation\" page");
                    sc.nextLine();
                    System.out.print("\n--------------------------------------------------------\n\n");
                    break;

                case "2": //Advanced
                    System.out.print("<<<< [Advanced version] Enemy Fortress Attack Simulation >>>>\n");
                    System.out.print("~ Display the best path with shortest time to reach enemy's camp (Djikstra's algorithm)\n");
                    System.out.print("~ Choose one from 3 generals to lead the troupe\n");
                    System.out.print("~ Each general will have different speeds based on the road condition of the map\n\n");
                    attackAdvanced();
                    System.out.print("\nEnter to go back to \"Attack Simulation\" page");
                    sc.nextLine();
                    System.out.print("\n--------------------------------------------------------\n\n");
                    break;

                //Exit interface
                case "-1":
                    return;

                //invalid input
                default:
                    System.out.println("Unrecognized selection. Please key in again.\n");
            }

        }
    }

    public void attackNormal() {
        int V = 10; // number of nodes

        AttackNormal graph = new AttackNormal(V);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 6);
        graph.addEdge(1, 10);
        graph.addEdge(2, 4);
        graph.addEdge(2, 1);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 7);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 4);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 1);
        graph.addEdge(6, 5);
        graph.addEdge(6, 7);
        graph.addEdge(6, 8);
        graph.addEdge(7, 5);
        graph.addEdge(7, 6);
        graph.addEdge(7, 8);
        graph.addEdge(7, 9);
        graph.addEdge(8, 6);
        graph.addEdge(8, 7);
        graph.addEdge(8, 9);
        graph.addEdge(8, 10);
        graph.addEdge(9, 7);
        graph.addEdge(9, 8);
        graph.addEdge(9, 10);
        graph.addEdge(10, 1);
        graph.addEdge(10, 8);
        graph.addEdge(10, 9);

        System.out.println("Map: \n(The starting node is Node 1)");
        //create matrix to display the map
        int[][] matrix = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph.hasEdge(i + 1, j + 1)) {
                    matrix[i][j] = 1; // There is an edge between vertices (i+1) and (j+1)
                } else {
                    matrix[i][j] = 0; // There is no edge between vertices (i+1) and (j+1)
                }
            }
        }

        System.out.print("  ");
        for (int i = 1; i <= V; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < V; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < V; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        //user input for enemy node aka dest node
        Scanner sc = new Scanner(System.in);
        int src = 1; //starting node 1
        int dest = 0; //initialize enemy node
        while (true) {
            System.out.print("\nEnter the enemy node [-1 to exit]: ");
            try {
                dest = sc.nextInt();
                if ((dest < 2 || dest > 10) && dest != -1) {
                    throw new IllegalArgumentException("Invalid input. Allowed input:[-1],[2 ~ 10]");
                }
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Input must be an integer.");
                sc.next();
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        sc.nextLine(); // Avoid Scanner skipping line problem
        if (dest == -1) {
            attackSelection();
            return;
        }

        //find all possible paths
        System.out.print("\nAll the possible paths from Node 1 to " + dest + ": \n");
        List<List<Integer>> paths = graph.findPaths(src, dest);
        for (List<Integer> path : paths) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i != path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }

        //find the shortest path/s
        System.out.print("\nShortest path/s: \n");
        List<Integer> pathLengths = graph.getPathLengths(paths);
        int minPathLength = Collections.min(pathLengths);
        for (int i = 0; i < paths.size(); i++) {
            if (pathLengths.get(i) == minPathLength) {
                List<Integer> path = paths.get(i);
                for (int j = 0; j < path.size(); j++) {
                    System.out.print(path.get(j));
                    if (j != path.size() - 1) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }
        }
    }

    public void attackAdvanced() {

        Map<Integer, List<Combo>> adjacencyList = new HashMap<>();
        adjacencyList.put(1, Arrays.asList(new Combo(2, 10, "forest"), new Combo(3, 18, "flat"), new Combo(6, 20, "flat"), new Combo(10, 16, "flat")));
        adjacencyList.put(2, Arrays.asList(new Combo(1, 10, "forest"), new Combo(4, 10, "swamp")));
        adjacencyList.put(3, Arrays.asList(new Combo(1, 18, "flat"), new Combo(4, 12, "swamp"), new Combo(7, 28, "plank")));
        adjacencyList.put(4, Arrays.asList(new Combo(2, 10, "swamp"), new Combo(3, 12, "swamp"), new Combo(5, 12, "swamp")));
        adjacencyList.put(5, Arrays.asList(new Combo(4, 12, "swamp"), new Combo(6, 17, "flat"), new Combo(7, 10, "forest")));
        adjacencyList.put(6, Arrays.asList(new Combo(1, 20, "flat"), new Combo(5, 17, "flat"), new Combo(7, 23, "forest"), new Combo(8, 35, "plank")));
        adjacencyList.put(7, Arrays.asList(new Combo(5, 10, "forest"), new Combo(6, 23, "forest"), new Combo(8, 19, "flat"), new Combo(9, 17, "flat")));
        adjacencyList.put(8, Arrays.asList(new Combo(6, 35, "plank"), new Combo(7, 19, "flat"), new Combo(9, 7, "swamp"), new Combo(10, 12, "forest")));
        adjacencyList.put(9, Arrays.asList(new Combo(7, 17, "flat"), new Combo(8, 7, "swamp"), new Combo(10, 18, "flat")));
        adjacencyList.put(10, Arrays.asList(new Combo(1, 16, "flat"), new Combo(8, 12, "forest"), new Combo(9, 18, "flat")));

        //display map
        int[][] graphforPrint = createGraphForPrint(adjacencyList);
        System.out.print("Map: \n(The starting node is Node 1)\n");
        System.out.print("   ");
        for (int j = 1; j < graphforPrint[0].length; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int i = 1; i < graphforPrint.length; i++) {
            // Print row header
            System.out.print(i + "  ");

            for (int j = 1; j < graphforPrint[i].length; j++) {
                System.out.print(graphforPrint[i][j] + " ");
            }
            System.out.println();
        }

        //user input enemy node
        Scanner sc = new Scanner (System.in);
        int enemyNode = 0;
        while (true) {
            System.out.print("\nEnter Enemy Fortress Node [-1 to exit]: ");
            try {
                enemyNode = sc.nextInt();
                if ((enemyNode < 1 || enemyNode > 10) && enemyNode != -1) {
                    throw new IllegalArgumentException("Invalid input. Allowed input:[-1],[2 ~ 10]");
                }
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Input must be an integer.");
                // Clear the invalid input
                sc.next();
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        sc.nextLine(); // Avoid Scanner skipping line problem
        if (enemyNode == -1) {
            attackSelection();
            return;
        }

        //user input general type
        int generalType = 0;
        System.out.println();
        while (true) {
            System.out.print("Generals\n" +
                    "(1)Cavalry (Speed: 2km/h)\n" +
                    "\t Flat road - x3\n" +
                    "\t Forest - x0.8\n" +
                    "\t Swamp - x0.3\n" +
                    "\t Plank road - x0.5\n" +
                    "(2)Archer (Speed: 1km/h)\n" +
                    "\t Flat road - x2\n" +
                    "\t Forest - x1\n" +
                    "\t Swamp - x2.5\n" +
                    "\t Plank road - x0.5\n" +
                    "(3)Infantry (Speed: 1km/h)\n" +
                    "\t Flat road - x2\n" +
                    "\t Forest - x2.5\n" +
                    "\t Swamp - x1\n" +
                    "\t Plank road - x0.5\n" +
                    "\nSelect one general[-1 to exit]: "
            );
            try {
                generalType = sc.nextInt();
                if ((generalType < 1 || generalType > 3) && generalType != -1) {
                    throw new IllegalArgumentException("Invalid input. Allowed input:[-1],[1 ~ 3]\n");
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
        if (generalType == -1) {
            attackSelection();
            return;
        }
        int startNode = 1; // Starting node index
        AttackAdvanced.dijkstra(createGraph(adjacencyList, generalType), startNode, enemyNode, generalType);
    }
}

class AttackNormal { //BFS algorithm
    private final LinkedList<Integer>[] adjList;

    public AttackNormal(int v) {
        adjList = new LinkedList[v + 1];
        for (int i = 1; i <= v; i++) {
            adjList[i] = new LinkedList<>();
        }
        int[] parent = new int[v + 1];
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    public boolean hasEdge(int source, int destination) {
        List<Integer> neighbors = adjList[source];
        return neighbors.contains(destination);
    }

    public List<List<Integer>> findPaths(int src, int dest) {
        List<List<Integer>> paths = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> initialPath = new ArrayList<>();
        initialPath.add(src);
        queue.offer(initialPath);

        while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            int lastNode = currentPath.get(currentPath.size() - 1);

            if (lastNode == dest) {
                paths.add(currentPath);
            } else {
                LinkedList<Integer> neighbors = adjList[lastNode];
                for (Integer neighbor : neighbors) {
                    if (!currentPath.contains(neighbor)) {
                        List<Integer> newPath = new ArrayList<>(currentPath);
                        newPath.add(neighbor);
                        queue.offer(newPath);
                    }
                }
            }
        }

        return paths;
    }

    public List<Integer> getPathLengths(List<List<Integer>> paths) {
        List<Integer> lengths = new ArrayList<>();
        for (List<Integer> path : paths) {
            lengths.add(path.size());
        }
        return lengths;
    }
}

class AttackAdvanced { //Djikstra's algorithm
    private static final double INF = Double.POSITIVE_INFINITY;

    public static void dijkstra(double[][] graph, int startNode, int enemyNode, int generalType) {
        int n = graph.length;
        double[] time = new double[n];
        boolean[] visited = new boolean[n];
        int[] prev = new int[n];

        Arrays.fill(time, INF);
        Arrays.fill(prev, -1);
        time[startNode] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = (int) getMinTime(time, visited);
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && time[u] != INF
                        && time[u] + graph[u][v] < time[v]) {
                    time[v] = time[u] + graph[u][v];
                    prev[v] = u;
                }
            }
        }
        int current;
        List<Integer> path = new ArrayList<>();
        current = startNode;
        while (current != -1) {
            path.add(current);
            current = prev[current];
        }
        Collections.reverse(path);

        String generalTypeName = "  ";
        switch (generalType) {
            case 1 : generalTypeName = "Cavalry";
                break;
            case 2 : generalTypeName = "Archer";
                break;
            case 3 : generalTypeName = "Infantry";
        }

        //print general type, shortest path, total time taken
        System.out.println("\nGeneral Type: " + generalTypeName);
        printBestPaths(prev, startNode, enemyNode);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.print("\nTotal time taken: " + decimalFormat.format(time[enemyNode]) + " hours \n");
    }

    private static double getMinTime(double[] time, boolean[] visited) {
        double minTime = INF;
        int minIndex = -1;

        for (int i = 0; i < time.length; i++) {
            if (!visited[i] && time[i] <= minTime) {
                minTime = time[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static void printBestPaths(int[] prev, int startNode, int enemyNode) {
        List<Integer> path = new ArrayList<>();
        int current = enemyNode;
        while (current != -1) {
            path.add(current);
            current = prev[current];
        }
        Collections.reverse(path);

        if (path.get(0) == startNode) {
            System.out.print("Best path from " + startNode + " to " + enemyNode + ": ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i != path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
        } else {
            System.out.println("No path found from " + startNode + " to " + enemyNode);
        }
    }

    public static int[][] createGraphForPrint(Map<Integer, List<Combo>> adjacencyList) {
        int maxNode = adjacencyList.keySet().stream().max(Integer::compareTo).orElse(0);
        int[][] graphForPrint = new int[maxNode + 1][maxNode + 1];

        for (int i = 0; i <= maxNode; i++) {
            Arrays.fill(graphForPrint[i], 0);
        }

        for (int i = 1; i <= maxNode; i++) {
            List<Combo> combos = adjacencyList.getOrDefault(i, new ArrayList<>());

            for (Combo combo : combos) {
                int distance = combo.getDistance();
                int node = combo.getNode();

                graphForPrint[i][node] = distance; // distance from i to node
            }
        }
        return graphForPrint;
    }

    public static double[][] createGraph(Map<Integer, List<Combo>> adjacencyList, int generalType) {
        int maxNode = adjacencyList.keySet().stream().max(Integer::compareTo).orElse(0);
        double[][] graph = new double[maxNode + 1][maxNode + 1];

        for (int i = 0; i <= maxNode; i++) {
            Arrays.fill(graph[i], 0);
        }

        for (int i = 1; i <= maxNode; i++) {
            List<Combo> combos = adjacencyList.getOrDefault(i, new ArrayList<>());

            for (Combo combo : combos) {
                double time = 0;
                if (generalType == 1) { // cavalry
                    if (Objects.equals(combo.getType(), "flat")) {
                        time = (double) combo.getDistance() / (2 * 3);
                    } else if (Objects.equals(combo.getType(), "forest")) {
                        time = (double) combo.getDistance() / (2 * 0.8);
                    } else if (Objects.equals(combo.getType(), "swamp")) {
                        time = (double) combo.getDistance() / (2 * 0.3);
                    } else if (Objects.equals(combo.getType(), "plank")) {
                        time = (double) combo.getDistance() / (2 * 0.5);
                    }
                } else if (generalType == 2) { // archer
                    if (Objects.equals(combo.getType(), "flat")) {
                        time = (double) combo.getDistance() / (1 * 2);
                    } else if (Objects.equals(combo.getType(), "forest")) {
                        time = (double) combo.getDistance();
                    } else if (Objects.equals(combo.getType(), "swamp")) {
                        time = (double) combo.getDistance() / (1 * 2.5);
                    } else if (Objects.equals(combo.getType(), "plank")) {
                        time = (double) combo.getDistance() / (1 * 0.5);
                    }
                } else if (generalType == 3) { //infantry
                    if (Objects.equals(combo.getType(), "flat")) {
                        time = (double) combo.getDistance() / (1 * 2);
                    } else if (Objects.equals(combo.getType(), "forest")) {
                        time = (double) combo.getDistance() / (1 * 2.5);
                    } else if (Objects.equals(combo.getType(), "swamp")) {
                        time = (double) combo.getDistance();
                    } else if (Objects.equals(combo.getType(), "plank")) {
                        time = (double) combo.getDistance() / (1 * 0.5);
                    }
                }

                graph[i][combo.getNode()] = time; // time from i to node
            }
        }
        return graph;
    }
}

class Combo {

    private final int node;
    private final int distance;
    private final String type;

    public Combo(int node, int distance, String type) {
        this.node = node;
        this.distance = distance;
        this.type = type;
    }

    public int getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }

    public String getType() {
        return type;
    }
}
