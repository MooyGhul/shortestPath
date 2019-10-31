package Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    Graph_Node[] nodes;

    List<Integer>[] adjacent_List;

    /** this part is for test **/
    public Graph(){
        nodes = new Graph_Node[1001];
        adjacent_List= new List[1001];
    }

    public Graph(URL urlfile){
        nodes = new Graph_Node[1001];
        adjacent_List= new List[1001];
        import_data(urlfile);
    }

    public Graph_Node[] getNodes() {
        return nodes;
    }

    public List<Integer>[] get_linked() {
        return adjacent_List;
    }

    void import_data(URL urlfile){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(urlfile.openStream()))){

            String line = null;
            int counter = 1;

            while ((line = br.readLine()) != null) {
                if (counter <= 1000) {
                    String[] line_words = line.split(" ");
                    Graph_Node currNode = new Graph_Node();
                    String lat = line_words[2].substring(0, line_words[2].length() - 1);
                    String lon = line_words[3];

                    currNode.setIndex(counter);
                    currNode.setLat(Double.valueOf(lat));
                    currNode.setLon(Double.valueOf(lon));
                    this.nodes[counter] = currNode;
                }
                else if (counter > 1001) {
                    adjacent_List[counter-1001]=new LinkedList<>();
                    String[] line_words = line.split(" ");
                    for(int i = 2; i<line_words.length; i++) {
                        String pure_num = line_words[i].substring(0, line_words[i].length() - 1);
                        adjacent_List[counter - 1001].add(Integer.valueOf(pure_num));
                    }
                }
                /***************************DEBUG 1 ****************************************/
                counter++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /***************************DEBUG 2 ****************************************/




    /*
    static double cal_distance(Graph_Node g1, Graph_Node g2){
        double dlat = 2 * Math.PI * (g2.getLat() - g1.getLat()) / 360.0;
        double mlat = 2 * Math.PI * (g1.getLat() + g2.getLat()) / 2.0 / 360;
        double dlon = 2 * Math.PI * (g2.getLon() - g1.getLon()) / 360.0;
        //mlat= Math.toRadians(mlat);
        return 6371009 * Math.pow(Math.pow(dlat,2) + Math.pow((Math.cos(mlat) * dlon),2),0.5);
    }
    */



}









                /******************************DEBUG 1 input process**********************************
                if(counter==2001){
                    int NodeNum1 =1;
                    int NodeNum2 =1000;

                    System.out.println("Node[" + NodeNum1 +"]: lat ="+ nodes[NodeNum1].getLat()+"AND lon ="+ nodes[NodeNum1].getLon());
                    System.out.println("Node[" + NodeNum2 +"]: lat ="+ nodes[NodeNum2].getLat()+"AND lon ="+ nodes[NodeNum2].getLon());

                    List list1 = adjacent_List[1];
                    int i = 0;
                    System.out.print("1: ");
                    while(i<list1.size()){
                        System.out.print(list1.get(i)+" ");
                        i++;
                    }
                    System.out.println();

                    List list2 = adjacent_List[1000];
                    int j = 0;
                    System.out.print("1000: ");
                    while(j<list2.size()){
                        System.out.print(list2.get(j)+" ");
                        j++;
                    }
                    System.out.println();
                }
                //*******************************END***************************************/


                /******************************DEBUG 2 Minheap implementation**********************************
                 void testMinHeap(){
                     MinHeap pq = new MinHeap(12);
                     for(int i =10; i>0; i--){
                         Pair<Graph_Node,Double> cur_pair = new Pair<>(nodes[i],nodes[i].getLat());
                         pq.insert(cur_pair);
                     }
                     while(pq.size()>0){
                         Pair<Graph_Node,Double> rem_pair = pq.remove();
                         System.out.print( rem_pair.getNode().getIndex() +"{"+ rem_pair.getNode().getLat() +"}-->");
                     }
                 }
                //*******************************END***************************************/
