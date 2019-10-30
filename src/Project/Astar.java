package Project;

import java.util.LinkedList;
import java.util.List;

public class Astar {


    int counter =1;
    LinkedList<Integer> path = new LinkedList<>();
    // The default value for a boolean (primitive) is false
    boolean[] pathNode;
    boolean[] visitedNode;
    //distance used to store the distance of vertex from a source
    double[] dist_from_source;

    void printLinkedList(LinkedList<Integer> ll){
        for (int i = 0; i < ll.size()-1; i++) {

            System.out.print(ll.get(i) +"-->");
        }
        System.out.print(ll.get(ll.size()-1));
        System.out.println();
    }


    double visit(Graph graph, Graph_Node source, Graph_Node dest){
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

        // Graph_Node[] nodes;
        // List<Integer>[] adjacent_List;
        /**----------------------------------------------------**/
        // pq have items: Pair<Graph_Node,Double Distance>
        // Graph_node: getIndex, getLon, getLat;

        MinHeap pq = new MinHeap(1001);
        source.setPath(new StringBuilder( Integer.toString(source.getIndex())+"-->"));
        pq.insert(new Pair<>(source, Graph.cal_distance(source, dest)));


        while(pq.size()>0){
            // curr_pair
            //System.out.println("The size of the pq now is "+ pq.size());
            Pair<Graph_Node,Double> curr_pair = pq.remove();

            int index_curr = curr_pair.getNode().getIndex();


    /*        if(index_curr==388 ){
                System.out.println(index_curr + " is successfully popped");
                //System.out.println("Weight of "+ index_curr +" is "+ curr_pair.getDistance());
                //System.out.println("Distance from source of "+ index_curr +" is "+ dist_from_source[index_curr]);

                System.out.print("388 CONNECT TO: ");
                for(int i = 0; i<graph.get_linked()[index_curr].size();i++){
                    System.out.print(graph.get_linked()[index_curr].get(i)+" ");
                }
                System.out.println();
            }
    */
            //System.out.println("Here is the Node : " + index_curr + " with distance " + Tool.df2.format(curr_pair.getDistance()));

            if(index_curr==dest.getIndex()){
                int pathlength = curr_pair.getNode().getPath().length();
                System.out.println(curr_pair.getNode().getPath().delete(pathlength-3,pathlength));
                return dist_from_source[index_curr];
            }
            //System.out.println("The node ** "+ index_curr + " ** is removed from pq");
            Graph_Node currNode = curr_pair.getNode();
            pathNode[index_curr]=true;

            List<Integer> currList= graph.get_linked()[index_curr];

            //System.out.println("~~~~~~~"+index_curr+"~~~~~~~");

            for(int i = 0; i<currList.size(); i++) {

                int num_node = currList.get(i);
    /*
                if(index_curr==388) {
                    System.out.println("______" + num_node + "______");
                }
    */            /*
                if(index_curr == 388){
                    System.out.println("From 388 we traverse node "+ num_node);
                }
                if(num_node==480){
                    System.out.println("What we get before 480? It is " +index_curr);
                    System.out.println("We get 480");
                }
                */


                if (pathNode[num_node] != true && visitedNode[num_node]!= true) {
                    visitedNode[num_node]= true;
                    /*
                    if (num_node == 480) {
                        System.out.println("visitedNode[480]="+visitedNode[480]);
                        System.out.println("pathNode[480]="+pathNode[480]);
                    }
                    */
                    double the_dist = Graph.cal_distance(currNode, nodes[num_node]) + dist_from_source[currNode.getIndex()];
        /*
                    if(index_curr==388) {
                        System.out.println("visitedNode[num_node]!= true");
                        System.out.println("388 from source"+dist_from_source[currNode.getIndex()]);
                        System.out.println("1->"+ num_node +" : " + the_dist);
                        System.out.println(num_node +"->480 : " + Graph.cal_distance(nodes[num_node], dest));

                    }
        */
                    dist_from_source[num_node]=the_dist;

                    Double dist_from_target= Graph.cal_distance(nodes[num_node], dest);

                    //System.out.println("DISTANCE BTW "+ currNode.getIndex() +" AND "+ num_node +" is "+ Tool.df2.format(the_dist));
                    //System.out.println("DISTANCE BTW "+ dest.getIndex() +" AND "+ num_node +" is "+ Tool.df2.format(dist_from_target));
                    double overall_distance = dist_from_source[num_node] + dist_from_target;
                    //System.out.println("OVERALL DIST "+ Tool.df2.format(overall_distance));
                    //System.out.println();
                    nodes[num_node].setPath((new StringBuilder(curr_pair.getNode().getPath())).append(Integer.toString(num_node) + "-->"));
                    Pair<Graph_Node,Double> newPair = new Pair<>(nodes[num_node],overall_distance);
                    pq.insert(newPair);
                }else if(pathNode[num_node] != true){

                    if(index_curr==388) {
                        System.out.println("visitedNode[num_node]== true");
                    }

                    double the_dist = Graph.cal_distance(currNode, nodes[num_node]) + dist_from_source[currNode.getIndex()];
                    if (the_dist<dist_from_source[num_node]){
                        dist_from_source[num_node]=the_dist;
                        Double dist_from_target= Graph.cal_distance(nodes[num_node], dest);
                        double overall_distance = dist_from_source[num_node] + dist_from_target;
                        /*
                        if(num_node==480){
                            System.out.println(counter+" time to see 480");
                            counter++;
                        }
                        */
                        nodes[num_node].setPath((new StringBuilder(curr_pair.getNode().getPath())).append(Integer.toString(num_node) + "-->"));
                        pq.update(num_node,overall_distance);
                    }
                }



            }
        }
        return -1.0;
    }
}
