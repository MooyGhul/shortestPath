package Project;

import java.net.MalformedURLException;
import java.net.URL;

public class Execution {



    public static void main(String[] args){




        try {
            URL urlfile = new URL("https://www.cs.sfu.ca/~binay/2019/cmpt307/graph1000.txt");
            Graph graph = new Graph(urlfile);

            Graph_Node source = graph.getNodes()[1];
            Graph_Node target = graph.getNodes()[5];

            System.out.println("---------------- DIJKSTRA ----------------");
            Dijkastra dijkastra= new Dijkastra();

            double shortestPath = dijkastra.visit(graph,source,target);
            System.out.println("Distance = "+ Tool.df2.format(shortestPath));
            /*
            System.out.println("Node 864: " + dijkastra.dist_from_source[864]);
            System.out.println("Node 863: " + dijkastra.dist_from_source[863]);
            System.out.println("Node 856: " + dijkastra.dist_from_source[856]);
            System.out.println("Node 862: " + dijkastra.dist_from_source[862]);
            System.out.println("Node 15: " + dijkastra.dist_from_source[15]);
            System.out.println("Node 388: " + dijkastra.dist_from_source[388]);
            System.out.println("Node 480: " + dijkastra.dist_from_source[480]);
            */
    //        System.out.println("Node 388: " + dijkastra.dist_from_source[388]);
    //        System.out.println("Node 384: " + dijkastra.dist_from_source[384]);
            /*

            System.out.println("Node 414: " + dijkastra.dist_from_source[414]);
            System.out.println("Node 415: " + dijkastra.dist_from_source[415]);
            System.out.println("Node 604: " + dijkastra.dist_from_source[604]);
            System.out.println("Node 739: " + dijkastra.dist_from_source[739]);
            System.out.println("Node 416: " + dijkastra.dist_from_source[416]);
            System.out.println("Node 412: " + dijkastra.dist_from_source[412]);
            System.out.println("Node 413: " + dijkastra.dist_from_source[413]);
            System.out.println("Node 411: " + dijkastra.dist_from_source[411]);
            System.out.println("Node 410: " + dijkastra.dist_from_source[410]);
            System.out.println("Node 398: " + dijkastra.dist_from_source[398]);
            System.out.println("Node 480: " + dijkastra.dist_from_source[480]);
            */


            System.out.println("------------------- A* -------------------");

            Astar astar = new Astar();
            System.out.println("Distance = "+ Tool.df2.format(astar.visit(graph,source,target)));


            System.out.println("--------------- A* landmark ----------------");

            AStarWithLandmark alandmark = new AStarWithLandmark();
            System.out.println("Distance = "+ Tool.df2.format(alandmark.visit(graph,source,target)));
            /*
            System.out.println("Node 864: " + astar.dist_from_source[864]);
            System.out.println("Node 863: " + astar.dist_from_source[863]);
            System.out.println("Node 856: " + astar.dist_from_source[856]);
            System.out.println("Node 862: " + astar.dist_from_source[862]);
            System.out.println("Node 15: " + astar.dist_from_source[15]);
            */

    //        System.out.println("Node 388: " + astar.dist_from_source[388]);
            //System.out.println("Node 480: " + astar.dist_from_source[480]);


            /*
            System.out.println("Distance of 856: " + Tool.df2.format(astar.dist_from_source[856]));

            double dist856_862=Graph.cal_distance(graph.nodes[856],graph.nodes[862]);
            double dist862_5=Graph.cal_distance(graph.nodes[862],graph.nodes[5]);
            double sum1 = dist856_862+dist862_5;
            System.out.println("856-862  : "+Tool.df2.format(dist856_862));
            System.out.println("862-5    : "+Tool.df2.format(dist862_5));
            System.out.println("------SUM : "+ Tool.df2.format(sum1));


            double dist856_859=Graph.cal_distance(graph.nodes[856],graph.nodes[859]);
            double dist859_5=Graph.cal_distance(graph.nodes[859],graph.nodes[5]);
            double sum2 = dist856_859+dist859_5;
            System.out.println("856-959  : "+Tool.df2.format(dist856_859));
            System.out.println("959-5    : "+Tool.df2.format(dist859_5));
            System.out.println("------SUM : "+ Tool.df2.format(sum2));

            double dist856_1000=Graph.cal_distance(graph.nodes[856],graph.nodes[1000]);
            double dist1000_5=Graph.cal_distance(graph.nodes[1000],graph.nodes[5]);
            double sum3 = dist856_1000+dist1000_5;
            System.out.println("856-1000 : "+Tool.df2.format(dist856_1000));
            System.out.println("1000-5   : "+Tool.df2.format(dist1000_5));
            System.out.println("------SUM : "+ Tool.df2.format(sum3));

            double distance856 = astar.dist_from_source[856];
            System.out.println("Distance[856]= " + Tool.df2.format(distance856));
            System.out.println("Distance[862]= " + Tool.df2.format(astar.dist_from_source[862]));
            System.out.println("Differ by= " + Tool.df2.format((astar.dist_from_source[862]-distance856)));

            System.out.println("Distance[959]= " + Tool.df2.format(astar.dist_from_source[959]));
            System.out.println("Differ by= " + Tool.df2.format((astar.dist_from_source[959]-distance856)));

            System.out.println("Distance[1000]= " + Tool.df2.format(astar.dist_from_source[1000]));
            System.out.println("Differ by= " + Tool.df2.format((astar.dist_from_source[1000]-distance856)));
            */
            //System.out.println("862 Path: "+graph.nodes[862].getPath());
            //System.out.println("959 Path: "+graph.nodes[959].getPath());
            /*
            System.out.println("480 Path: "+graph.nodes[480].getPath() +"~~~"+ astar.dist_from_source[480]);
            System.out.println("384 Path: "+graph.nodes[384].getPath() +"~~~"+ astar.dist_from_source[384]);

            System.out.println("Weight at 480 is " + (astar.dist_from_source[480] +Graph.cal_distance(graph.nodes[480],target)));
            System.out.println("Weight at 384 is " + (astar.dist_from_source[384] +Graph.cal_distance(graph.nodes[384],target)));
            System.out.println("Weight at 388 is " + (astar.dist_from_source[388] +Graph.cal_distance(graph.nodes[388],target)));
            System.out.println("Distance from 384 to 480 is" + (Graph.cal_distance(graph.nodes[384],target)));
            System.out.println("Distance from source at 388 is " + astar.dist_from_source[388]);
            */




            //graph.testMinHeap();

            /*
            System.out.println("1  -864: "+Tool.df2.format(Graph.cal_distance(source, graph.getNodes()[864])));
            System.out.println("864-863: "+Tool.df2.format(Graph.cal_distance(graph.getNodes()[864], graph.getNodes()[863])));
            System.out.println("863-856: "+Tool.df2.format(Graph.cal_distance(graph.getNodes()[863], graph.getNodes()[856])));

            System.out.println("1  -863: "+Tool.df2.format(Graph.cal_distance(source, graph.getNodes()[863])));

            System.out.println("864-856: "+Tool.df2.format(Graph.cal_distance(graph.getNodes()[864], graph.getNodes()[856])));
            */

    /*        double edge1=Graph.cal_distance(graph.getNodes()[1], graph.getNodes()[864]);
            double edge2=Graph.cal_distance(graph.getNodes()[864], graph.getNodes()[863]);
            double edge3=Graph.cal_distance(graph.getNodes()[863], graph.getNodes()[856]);
            double edge4=Graph.cal_distance(graph.getNodes()[856], graph.getNodes()[862]);
            double edge5=Graph.cal_distance(graph.getNodes()[862], graph.getNodes()[15]);
            double edge6=Graph.cal_distance(graph.getNodes()[15], graph.getNodes()[388]);
            double edge7=Graph.cal_distance(graph.getNodes()[388], graph.getNodes()[384]);
            double edge8=Graph.cal_distance(graph.getNodes()[384], graph.getNodes()[414]);
            double edge9=Graph.cal_distance(graph.getNodes()[414], graph.getNodes()[415]);
            double edge10=Graph.cal_distance(graph.getNodes()[415], graph.getNodes()[604]);
            double edge11=Graph.cal_distance(graph.getNodes()[604], graph.getNodes()[739]);
            double edge12=Graph.cal_distance(graph.getNodes()[739], graph.getNodes()[416]);
            double edge13=Graph.cal_distance(graph.getNodes()[416], graph.getNodes()[412]);
            double edge14=Graph.cal_distance(graph.getNodes()[412], graph.getNodes()[413]);
            double edge15=Graph.cal_distance(graph.getNodes()[413], graph.getNodes()[411]);
            double edge16=Graph.cal_distance(graph.getNodes()[411], graph.getNodes()[410]);
            double edge17=Graph.cal_distance(graph.getNodes()[410], graph.getNodes()[398]);
            double edge18=Graph.cal_distance(graph.getNodes()[398], graph.getNodes()[480]);

            System.out.println("edge1="+Tool.df2.format(edge1));
            System.out.println("edge2="+Tool.df2.format(edge2));
            System.out.println("edge3="+Tool.df2.format(edge3));
            System.out.println("edge4="+Tool.df2.format(edge4));
            System.out.println("edge5="+Tool.df2.format(edge5));
            System.out.println("edge6="+Tool.df2.format(edge6));
            System.out.println("edge7="+Tool.df2.format(edge7));
            System.out.println("edge8="+Tool.df2.format(edge8));
            System.out.println("edge9="+Tool.df2.format(edge9));
            System.out.println("edge10="+Tool.df2.format(edge10));
            System.out.println("edge11="+Tool.df2.format(edge11));
            System.out.println("edge12="+Tool.df2.format(edge12));
            System.out.println("edge13="+Tool.df2.format(edge13));
            System.out.println("edge14="+Tool.df2.format(edge14));
            System.out.println("edge15="+Tool.df2.format(edge15));
            System.out.println("edge16="+Tool.df2.format(edge16));
            System.out.println("edge17="+Tool.df2.format(edge17));
            System.out.println("edge18="+Tool.df2.format(edge18));

            double sum = edge1+edge2+edge3+edge4+edge5+edge6+edge7+edge8+edge9+edge10+edge11+edge12+edge13+edge14+edge15+edge16+edge17+edge18;
            System.out.println("SUM EDGE="+sum);
            System.out.println(sum==shortestPath);

    */



            /*  //four extreme nodes
            System.out.println("low lat: "+landmark.getNode_low_lat().getLat()+ ", " +landmark.getNode_low_lat().getLon() );
            System.out.println("high lat: "+landmark.getNode_high_lat().getLat()+ ", " + landmark.getNode_high_lat().getLon());
            System.out.println("low lon: "+landmark.getNode_low_lon().getLat()+ ", " + landmark.getNode_low_lon().getLon());
            System.out.println("high lon: "+landmark.getNode_high_lon().getLat()+ ", " + landmark.getNode_high_lon().getLon());
            */


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }



}
