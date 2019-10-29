package Project;

import java.net.MalformedURLException;
import java.net.URL;

public class Execution {
    public static void main(String[] args){
        try {
            URL urlfile = new URL("https://www.cs.sfu.ca/~binay/2019/cmpt307/graph1000.txt");
            Graph graph = new Graph(urlfile);

            /**RUNNING DIJKSTRA ALGOTIRHM **/
            //Dijkastra dijkastra= new Dijkastra();
            //System.out.println("Distance = "+ dijkastra.visit(graph.getNodes()[1],graph.getNodes()[5],graph));


            //graph.testMinHeap();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }



}
