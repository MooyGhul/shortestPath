package Project;

public class Landmark {
    private Graph_Node node_low_lon;
    private Graph_Node node_high_lon;
    private Graph_Node node_low_lat;
    private Graph_Node node_high_lat;
    private Graph_Node[] nodes;

    private double[] point1 = new double[1001];
    private double[] point2 = new double[1001];
    private double[] point3 = new double[1001];
    private double[] point4 = new double[1001];


    Landmark(Graph_Node[] nodes,Graph graph){
        this.nodes = nodes;
        double low_lon = Double.MAX_VALUE;
        //Double.MIN_VALUE is positive number
        double high_lon = -Double.MAX_VALUE;
        double low_lat  = Double.MAX_VALUE;
        double high_lat = -Double.MAX_VALUE;

        for(int i = 1; i<=1000; i++){
            Graph_Node curr = nodes[i];
            if(curr.getLon()<low_lon){
                low_lon=curr.getLon();
                node_low_lon=curr;
            }
            if(curr.getLon()>high_lon){
                high_lon=curr.getLon();
                node_high_lon=curr;
            }
            if(curr.getLat()<low_lat){
                low_lat=curr.getLat();
                node_low_lat=curr;
            }
            if(curr.getLat()>high_lat){
                high_lat=curr.getLat();
                node_high_lat=curr;
            }
        }
        set_distances(graph);
    }

    void set_distances(Graph graph){
        Dijkastra dijkastra = new Dijkastra();
        for(int i = 1; i<=1000; i++){
            Graph_Node curr = nodes[i];
            point1[i]=dijkastra.visit(graph,curr, node_high_lat);
            point2[i]=dijkastra.visit(graph,curr, node_high_lon);
            point3[i]=dijkastra.visit(graph,curr, node_low_lat);
            point4[i]=dijkastra.visit(graph,curr, node_low_lon);
        }
    }


    double cal_distance(Graph_Node g1, Graph_Node g2){

        int ind_1=g1.getIndex();
        int ind_2=g2.getIndex();

        double len_1 = Math.abs(point1[ind_1]-point1[ind_2]);
        double len_2 = Math.abs(point2[ind_1]-point2[ind_2]);
        double len_3 = Math.abs(point3[ind_1]-point3[ind_2]);
        double len_4 = Math.abs(point4[ind_1]-point4[ind_2]);

        double max = Math.max(Math.max(len_1,len_2) , Math.max(len_3,len_4));
        return max;
    }

}
