package Project;

import java.net.MalformedURLException;
import java.net.URL;

public class Execution {

    public static void main(String[] args){

        try {
            URL urlfile = new URL("https://www.cs.sfu.ca/~binay/2019/cmpt307/graph1000.txt");
            Graph graph = new Graph(urlfile);

            /**System.out.println("----------------PRINT DIJKSTRA PATH----------------");*/
            // Dijkastra dijkastra= new Dijkastra();
            // double shortestPath = dijkastra.visit(graph,source,target);
            // System.out.println("Distance = "+ Tool.df2.format(shortestPath));

            /**System.out.println("-------------------PRINT A* PATH-------------------");*/
            // Astar astar = new Astar();
            // System.out.println("Distance = "+ Tool.df2.format(astar.visit(graph,source,target)));


            /**System.out.println("---------------PRINT A* landmark PATH----------------");*/
            // AStarWithLandmark alandmark = new AStarWithLandmark();
            // System.out.println("Distance = "+ Tool.df2.format(alandmark.visit(graph,source,target)));


            /**generate 20 random test cases*/
            for(int i = 1; i<=20;i++){

                Graph_Node source = graph.getNodes()[(int)(Math.random()*1000+1)];
                Graph_Node target = graph.getNodes()[(int)(Math.random()*1000+1)];


                Dijkastra dijkastra= new Dijkastra();
                double d_shortestPath = dijkastra.visit(graph,source,target);
                Astar astar = new Astar();
                double a_shortestPath = astar.visit(graph,source,target);
                AStarWithLandmark alandmark = new AStarWithLandmark();
                double l_shortestPath = alandmark.visit(graph,source,target);


                //System.out.println("Round "+ i +" is "+ ((d_shortestPath==a_shortestPath)==(a_shortestPath==l_shortestPath)) );
                System.out.println("Dijkastra visited: "+dijkastra.visitedNodeCounter + " , Astar visited: "+astar.visitedNodeCounter +" , LandMark Visited "+alandmark.visitedNodeCounter);

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }



}
