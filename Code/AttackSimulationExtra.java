package assignment_ds;
import java.util.*;

public class AttackSimulationExtra {
    private static final int INF = Integer.MAX_VALUE;
    public static void dijkstra(int[][] graph, int startNode, int enemyNode, int generalType) {
        int n = graph.length;
        int[] time = new int[n]; // to store the shortest time
        boolean[] visited = new boolean[n]; // to track visited nodes
        int[] prev = new int[n];

        // Initialize the time array with infinity and mark start node as 0
        Arrays.fill(time, INF);
        Arrays.fill(prev, -1);
        time[startNode] = 0;

        // Run Dijkstra's algorithm
        for (int count = 0; count < n - 1; count++) {
            int u = getMinTime(time, visited); // Find the node with the minimum time
            visited[u] = true; // Mark the node as visited

            // Update the time of the neighboring nodes
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && time[u] != INF &&
                        time[u] + graph[u][v] < time[v]) {
                    time[v] = time[u] + graph[u][v];
                    prev[v] = u;
                }
            }
        }
        //calculate the total time of shortest path
        int totalTime = time[enemyNode];
        int current = enemyNode;


        // Reconstruct the shortest path
        List<Integer> path = new ArrayList<>();
        current = startNode;
        while (current != -1) {
            path.add(current);
            current = prev[current];
        }
        Collections.reverse(path);

        // Convert the path to an array
        int[] shortestPath = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            shortestPath[i] = path.get(i);
        }

        String generalTypeName = switch (generalType) {
            case 1 -> "Cavalry";
            case 2 -> "Archer";
            case 3 -> "Infantry";
            default -> " ";
        };
        System.out.println("\nGeneral Type: " + generalTypeName);
        // Print the shortest paths
        printShortestPaths(prev, startNode, enemyNode);
        System.out.print("\nTotal time taken: " + totalTime + "hours \n");
    }

    private static int getMinTime(int[] time, boolean[] visited) {
        int minTime = INF;
        int minIndex = -1;

        for (int i = 0; i < time.length; i++) {
            if (!visited[i] && time[i] <= minTime) {
                minTime = time[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
    private static void printShortestPaths(int[] prev, int startNode, int enemyNode) {
        List<Integer> path = new ArrayList<>();
        int current = enemyNode;
        while (current != -1) {
            path.add(current);
            current = prev[current];
        }
        Collections.reverse(path);

        if (path.get(0) == startNode) {
            System.out.print("Shortest path from " + startNode + " to " + enemyNode + ": \n");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i != path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        } else {
            System.out.println("No path found from " + startNode + " to " + enemyNode);
        }
    }
    public void attackSelection() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                <<< Enemy Attack Simulation (Extra Algorithm) >>>\s
                The road to defeat the enemy is not a bed of roses, in fact, it is full of different geographical conditions\s
                that can affect the time to reach the enemy greatly.
                But with the correct general to lead, surely we can defeat the enemy with no sweat.""");
        System.out.println("\n\nThis system will show the path with the shortest time from base to the enemy fortress.\n");
        System.out.println("--------------------------------------------------------\n");

        Map<Integer, List<Combo>> adjacencyList = new HashMap<>();
        adjacencyList.put(1, Arrays.asList(new Combo<>(2, 10,"forest"), new Combo<>(3, 18, "flat"), new Combo<>(6, 20, "flat"), new Combo<>(10, 16, "flat")));
        adjacencyList.put(2, Arrays.asList(new Combo<>(1, 10,"forest"), new Combo<>(4, 10,"swamp")));
        adjacencyList.put(3, Arrays.asList(new Combo<>(1, 18, "swamp"), new Combo<>(4, 12, "swamp"), new Combo<>(7, 28, "plank")));
        adjacencyList.put(4, Arrays.asList(new Combo<>(2, 10, "swamp"), new Combo<>(3, 12,"swamp"), new Combo<>(5, 12,"swamp")));
        adjacencyList.put(5, Arrays.asList(new Combo<>(4, 12,"swamp"), new Combo<>(6, 17,"flat"), new Combo<>(7, 10,"forest")));
        adjacencyList.put(6, Arrays.asList(new Combo<>(1, 20,"flat"), new Combo<>(5, 17, "flat"), new Combo<>(7, 23,"forest"), new Combo<>(8, 35,"plank")));
        adjacencyList.put(7, Arrays.asList(new Combo<>(5, 10,"forest"), new Combo<>(6, 23,"forest"), new Combo<>(8, 19,"flat"), new Combo<>(9, 17,"flat")));
        adjacencyList.put(8, Arrays.asList(new Combo<>(6, 35, "plank"), new Combo<>(7, 19,"flat"), new Combo<>(9, 7,"swamp"), new Combo<>(10, 12,"forest")));
        adjacencyList.put(9, Arrays.asList(new Combo<>(7, 17,"flat"), new Combo<>(8, 7,"swamp"), new Combo<>(10, 18,"flat")));
        adjacencyList.put(10, Arrays.asList(new Combo<>(1, 16,"flat"), new Combo<>(8, 12,"forest"), new Combo<>(9, 18,"flat")));

        // Create the ori graph
        int[][] graphforPrint = createGraph(adjacencyList);

        // Print the graph
        System.out.println("Map with weights: ");
        for (int i = 1; i < graphforPrint.length; i++) {
            for (int j = 1; j < graphforPrint[i].length; j++) {
                System.out.print(graphforPrint[i][j] + " ");
            }
            System.out.println();
        }

        int enemyNode = 0;
        while (true) {
            System.out.print("\nEnter Enemy Fortress Node [-1 to exit]: ");

            try {
                enemyNode = sc.nextInt();
                if ((enemyNode < 2 || enemyNode > 10) && enemyNode != -1) {
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

        int generalType=0;

        while(true){
            System.out.print("""
                    General Type\s
                    (1)Cavalry (Speed: 2km/h)
                    \t Flat road - x3
                    \t Forest - x0.8
                    \t Swamp - x0.3
                    \t Plank road - x0.5
                    (2)Archer (Speed: 1km/h)
                    \t Flat road - x2
                    \t Forest - x1
                    \t Swamp - x2.5
                    \t Plank road - x0.5
                    (3)Infantry (Speed: 1km/h)
                    \t Flat road - x2
                    \t Forest - x2.5
                    \t Swamp - x1
                    \t Plank road - x0.5
                    Select one general[-1 to exit]:""");
            try{
                generalType = sc.nextInt();
                if ((generalType < 1 || generalType > 3) && enemyNode != -1) {
                    throw new IllegalArgumentException("Invalid input. Allowed input:[-1],[1 ~ 3]\n");
                }
                break;

            }catch (InputMismatchException ex) {
                System.out.println("Invalid input. Input must be an integer.\n");
                // Clear the invalid input
                sc.next();
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        int startNode = 1; // Starting node index
        int[][] graph = createGraphExtra(adjacencyList, generalType);

        System.out.println("\nMap of time taken: ");
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        dijkstra(createGraphExtra(adjacencyList, generalType), startNode, enemyNode, generalType);
        System.out.println("\n--------------------------------------------------------\n");
    }

    public static int[][] createGraph(Map<Integer, List<Combo>> adjacencyList) {
        // Find the maximum node number
        int maxNode = adjacencyList.keySet().stream().max(Integer::compareTo).orElse(0);

        // Create a 2D array for the graph
        int[][] graphforPrint = new int[maxNode + 1][maxNode + 1];

        // Initialize the graph with 0 distance
        for (int i = 0; i <= maxNode; i++) {
            Arrays.fill(graphforPrint[i], 0);
        }

        // Populate the graph with distances from the adjacency list
        for (int i = 1; i <= maxNode; i++) {
            List<Combo> combos = adjacencyList.getOrDefault(i, new ArrayList<>());
            for (Combo combo : combos) {
                int node = combo.getNode();
                int distance = combo.getDistance();
                graphforPrint[i][node] = distance;
            }
        }

        return graphforPrint;
    }

    //createGraphExtra creates graphs with the general and the roadType speed
    public static int[][] createGraphExtra(Map<Integer, List<Combo>> adjacencyList, int generalType) {
        // Find the maximum node number
        int maxNode = adjacencyList.keySet().stream().max(Integer::compareTo).orElse(0);

        // Create a 2D array for the graph
        int[][] graph = new int[maxNode + 1][maxNode + 1];

        // Initialize the graph with 0 distance
        for (int i = 0; i <= maxNode; i++) {
            Arrays.fill(graph[i], 0);
        }


        // Populate the graph with distances from the adjacency list
        for (int i = 1; i <= maxNode; i++) {
            List<Combo> combos = adjacencyList.getOrDefault(i, new ArrayList<>());

            for (Combo combo : combos) {
                double time = 0;
                //String type = combo.getType();
                //int distance = combo.getDistance();
                if(generalType == 1){ //cavalry
                    if(Objects.equals(combo.getType(), "flat")){ time = (double) combo.getDistance()/(2 * 3);}
                    if(Objects.equals(combo.getType(), "forest")){ time = (double) combo.getDistance()/(2*0.8);}
                    if(Objects.equals(combo.getType(), "swamp")){ time = (double) combo.getDistance()/( 2*0.3);}
                    if(Objects.equals(combo.getType(), "plank")) {time = (double) combo.getDistance()/( 2*0.5);}

                }
                else if(generalType==2){ //archer
                    if(Objects.equals(combo.getType(), "flat")) {time = (double) combo.getDistance()/( 1*2);}
                    if(Objects.equals(combo.getType(), "forest")){ time = (double) combo.getDistance();}
                    if(Objects.equals(combo.getType(), "swamp")) {time = (double) combo.getDistance()/(1*2.5);}
                    if(Objects.equals(combo.getType(), "plank")) {time = (double) combo.getDistance()/(1*0.5);}
                }
                else if(generalType==3){
                    if(Objects.equals(combo.getType(), "flat")) {time = (double) combo.getDistance()/(1*2);}
                    if(Objects.equals(combo.getType(), "forest")) {time = (double)combo.getDistance()/(1*2.5);}
                    if(Objects.equals(combo.getType(), "swamp")) {time = (double) combo.getDistance()/(1*2.5);}
                    if(Objects.equals(combo.getType(), "plank")) {time = (double) combo.getDistance()/(1*0.5);}
                }
                int node = combo.getNode();


                double speed = 1;

                graph[i][node] = (int) time; //time taken from i to node
            }
        }

        return graph;
    }
}

class Combo<T> {
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
