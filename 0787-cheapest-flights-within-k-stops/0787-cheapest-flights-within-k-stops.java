class Pair {
    int node, distance;
    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
class Node {
    int node, distance, stops;
    public Node(int node, int distance, int stops) {
        this.node = node;
        this.distance = distance;
        this.stops = stops;
    }
}
class Solution {
    private List<List<Pair>> buildGraph(int[][] flights, int n) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] flight : flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        return graph;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = buildGraph(flights, n);
        int[] distance = new int[n];
        int[] stops = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<Node> minHeap = new PriorityQueue<>((node1, node2) -> node1.distance - node2.distance);

        distance[src] = 0;
        stops[src] = 0;
        minHeap.add(new Node(src, distance[src], stops[src]));

        while(!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            int currNode = curr.node;
            int currDistance = curr.distance;
            int currStops = curr.stops;

            if(currNode == dst) return currDistance;

            if(currStops == k + 1) continue;

            for(Pair pair : graph.get(currNode)) {
                int nbrNode = pair.node;
                int nbrDistance = pair.distance;
                if((currDistance + nbrDistance) < distance[nbrNode]) {
                    distance[nbrNode] = currDistance + nbrDistance;
                    stops[nbrNode] = currStops + 1;
                    minHeap.add(new Node(nbrNode, distance[nbrNode], stops[nbrNode]));
                } else if((currStops + 1) < stops[nbrNode]) {
                    minHeap.add(new Node(nbrNode, currDistance + nbrDistance, currStops + 1));
                }
            }
        }
        return -1;
    }
}
