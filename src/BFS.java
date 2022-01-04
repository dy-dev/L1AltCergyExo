import java.util.*;

import static java.util.Map.entry;

public class BFS {
    public static void checkGraph() {

        //Graph given as input datas
        Map<String, List<String>> g = Map.ofEntries(
                entry("a", Arrays.asList("b", "c")),
                entry("b", Arrays.asList("a", "e", "d")),
                entry("c", Arrays.asList("a", "d")),
                entry("d", Arrays.asList("b", "c", "e")),
                entry("e", Arrays.asList("b", "d", "f")),
                entry("f", Arrays.asList("e", "g")),
                entry("g", Arrays.asList("e", "f", "h")),
                entry("h", List.of("g")));

        for(String vertex : g.keySet()) {
            //Map containing as key a vertex as value its parent
            Map<String, String> p = new HashMap<>();

            //Queue containing vertex not yet completely visited
            //Queue is emptied one by one once a vertex has all its children discovered
            Queue<String> q = new ArrayDeque<>();

            //Contains all vertices that have been discovered
            //This list is never emptied and the algorithm know it has finished when it contains
            //all graph's keys
            List<String> discovered = new ArrayList<>();

            //Vertices that have been completely visited
            List<String> closed = new ArrayList<>();

            p.put(vertex, "None");
            discovered.add(vertex);
            search(g, vertex, p, q, discovered, closed);
            System.out.println(p);
        }
    }

    private static void search(Map<String, List<String>> myGraph,
                               String vertex,
                               Map<String, String> p,
                               Queue<String> q,
                               List<String> discovered,
                               List<String> closed) {

        //Get all related vertices
        List<String> values = myGraph.get(vertex);

        //Each vertex not yet discovered will be added to lists(discovered, parents, queue)
        for (String value: values) {
            if(!discovered.contains(value)) {
                p.put(value, vertex);
                q.add(value);
                discovered.add(value);
            }
        }

        //Vertex has been totally studied, can be discarded
        closed.add(vertex);

        //If there are still vertices to study call search recursively
        while(!q.isEmpty()){
            //Remove the next vertex to study from the queue
            String vert = q.poll();
            search(myGraph,vert,p,q,discovered,closed);
        }

    }
}
