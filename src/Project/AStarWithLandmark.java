package Project;

import java.util.LinkedList;
import java.util.List;

public class AStarWithLandmark {


    int counter =1;
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] pathNode;
    boolean[] visitedNode;
    double[] dist_from_source;
    int visitedNodeCounter=1;

    double visit(Graph graph, Graph_Node source, Graph_Node dest){
        Landmark landmark = new Landmark(graph.nodes, graph);

        pathNode = new boolean[1001];
        dist_from_source = new double[1001];
        visitedNode = new boolean[1001];

        Graph_Node[] nodes = graph.getNodes();

        for(int i =1;i<=1000;i++){
            nodes[i].setPath(new StringBuilder());
        }

        for (int i = 0; i <1001 ; i++) {
            dist_from_source[i] = Double.MAX_VALUE;
        }
        dist_from_source[source.getIndex()] = 0.0;


        MinHeap pq = new MinHeap(1001);
        source.setPath(new StringBuilder( Integer.toString(source.getIndex())+"-->"));
        pq.insert(new Pair<>(source, landmark.cal_distance(source, dest)));


        while(pq.size()>0){

            Pair<Graph_Node,Double> curr_pair = pq.remove();

            int index_curr = curr_pair.getNode().getIndex();

            if(index_curr==dest.getIndex()){
                int pathlength = curr_pair.getNode().getPath().length();
//                System.out.println(curr_pair.getNode().getPath().delete(pathlength-3,pathlength));
                return dist_from_source[index_curr];
            }
            Graph_Node currNode = curr_pair.getNode();
            pathNode[index_curr]=true;

            List<Integer> currList= graph.get_linked()[index_curr];

            for(int i = 0; i<currList.size(); i++) {

                int num_node = currList.get(i);

                if (pathNode[num_node] != true && visitedNode[num_node]!= true) {
                    visitedNode[num_node]= true;


                    double the_dist = Tool.cal_distance(currNode, nodes[num_node]) + dist_from_source[currNode.getIndex()];

                    dist_from_source[num_node]=the_dist;

                    Double dist_from_target= landmark.cal_distance(nodes[num_node], dest);

                    double overall_distance = dist_from_source[num_node] + dist_from_target;

                    nodes[num_node].setPath((new StringBuilder(curr_pair.getNode().getPath())).append(Integer.toString(num_node) + "-->"));
                    Pair<Graph_Node,Double> newPair = new Pair<>(nodes[num_node],overall_distance);
                    pq.insert(newPair);
                    visitedNodeCounter++;
                }else if(pathNode[num_node] != true){

                    double the_dist = Tool.cal_distance(currNode, nodes[num_node]) + dist_from_source[currNode.getIndex()];
                    if (the_dist<dist_from_source[num_node]){
                        dist_from_source[num_node]=the_dist;
                        Double dist_from_target= landmark.cal_distance(nodes[num_node], dest);
                        double overall_distance = dist_from_source[num_node] + dist_from_target;

                        nodes[num_node].setPath((new StringBuilder(curr_pair.getNode().getPath())).append(Integer.toString(num_node) + "-->"));
                        pq.update(num_node,overall_distance);
                    }
                }
            }
        }
        return -1.0;
    }
}
