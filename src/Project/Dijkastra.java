package Project;

import java.util.List;

public class Dijkastra {

    //LinkedList<Integer> path = new LinkedList<>();

    // The default value for a boolean (primitive) is false
    boolean[] visitedNode;
    //distance used to store the distance of vertex from a source
    double[] dist_from_source;

    /*
    void printLinkedList(LinkedList<Integer> ll){
        for (int i = 0; i < ll.size()-1; i++) {

            System.out.print(ll.get(i) +"-->");
        }
        System.out.print(ll.get(ll.size()-1));
        System.out.println();
    }
    */

    double visit(Graph graph, Graph_Node source, Graph_Node target){
        visitedNode = new boolean[1001];
        dist_from_source = new double[1001];
        Graph_Node[] nodes = graph.getNodes();
        for(int i =1;i<=1000;i++){
            nodes[i].setPath(new StringBuilder());
        }
        source.setPath(new StringBuilder( Integer.toString(source.getIndex())+"-->"));

        //Initialize all the distance to infinity
        for (int i = 0; i <1001 ; i++) {

            dist_from_source[i] = Double.MAX_VALUE;
        }
        dist_from_source[source.getIndex()] = 0.0;

        MinHeap pq = new MinHeap(1001);
        source.setPath(new StringBuilder( Integer.toString(source.getIndex())+"-->"));
        pq.insert(new Pair<Graph_Node,Double>(source,0.0));

        while(pq.size()>0){
            Pair<Graph_Node,Double> curr = pq.remove();
            Graph_Node currNode = curr.getNode();
            //System.out.println("*** The least dist node is "+ currNode.getIndex()+" *****");
            visitedNode[currNode.getIndex()] = true;
            //path.add(currNode.getIndex());

            if(currNode.getIndex()==target.getIndex()){
                int pathlength = currNode.getPath().length();
                System.out.println(currNode.getPath().delete(pathlength-3,pathlength));

                //printLinkedList(path);

                return dist_from_source[currNode.getIndex()];
            }

            List<Integer> currList= graph.get_linked()[currNode.getIndex()];

            for(int i = 0; i<currList.size(); i++) {
                int num_node = currList.get(i);
                //System.out.println("Node number is "+num_node +" is " + visitedNode[863]);
                //System.out.println("---"+ i +"---" + num_node);
                if (visitedNode[num_node] != true) {
                    //System.out.println("Node number is "+num_node +"The Node is visited? "+visitedNode[num_node]);

                    double new_dist = Tool.cal_distance(currNode, nodes[num_node]) + dist_from_source[currNode.getIndex()];
                    boolean first_visit;
                    if(dist_from_source[num_node]==Double.MAX_VALUE){
                        //System.out.println("first visit " + num_node + " is true");
                        first_visit = true;
                    }else{
                        //System.out.println("first visit " + num_node + " is false");
                        first_visit = false;
                    }
                    //System.out.println("new_dist: " + new_dist);
                    //System.out.println("dist_from_source: " + dist_from_source[num_node]);

                    if(new_dist<dist_from_source[num_node]){
                        //System.out.println("SHOULD HAVE SOMETHING HERE");

                        dist_from_source[num_node]= new_dist;
                        Pair<Graph_Node,Double> newPair = new Pair<>(nodes[num_node],dist_from_source[num_node]);

                        if(first_visit ==true){
                            //System.out.println("Node "+ num_node +"need to get INSERTED");
                            nodes[num_node].setPath((new StringBuilder(currNode.getPath())).append(Integer.toString(num_node) + "-->"));
                            pq.insert(newPair);
                            //System.out.println("Node "+ num_node +"is INSERTED");
                        }else{
                            //System.out.println("Node "+ num_node +"need to get UPDATED");
                            nodes[num_node].setPath((new StringBuilder(currNode.getPath())).append(Integer.toString(num_node) + "-->"));
                            pq.update(newPair.getNode().getIndex(),newPair.getDistance());
                            //System.out.println("Node "+ num_node +"is UPDATED");
                        }

                    }
                }
            }
        }



        return -1;
    }

}
