package Laicode.Algorithm.CrossTrainningII;

/*
* Make a deep copy of an undirected graph, there could be cycles in the original graph.

Assumptions

The given graph is not null
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepCopyUndirectedGraph {
    public List<GraphNode> copy(List<GraphNode> graph) {
        // Write your solution here.
        if (graph == null) {
            return null;
        }

        Map<GraphNode, GraphNode> map = new HashMap<>();
        for (GraphNode node :
                graph) {
            if (!map.containsKey(node)) {
                map.put(node, new GraphNode(node.key));
                DFS(node, map);
            }
        }
        return new ArrayList<GraphNode>(map.values());
    }

    private void DFS(GraphNode seed, Map<GraphNode, GraphNode> map) {
        GraphNode copy = map.get(seed);
        for (GraphNode nei :
                seed.neighbors) {
            if (!map.containsKey(seed.neighbors)) {
                map.put(nei, new GraphNode(nei.key));
                DFS(nei, map);
            }
            copy.neighbors.add(map.get(nei));
        }
    }
    //TC: O(|E| + |V|)
    //SC: O(|E| + |V|)

}
