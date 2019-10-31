package Project;

public class Landmark {
    private Graph_Node node_low_lon;
    private Graph_Node node_high_lon;
    private Graph_Node node_low_lat;
    private Graph_Node node_high_lat;
    private Graph_Node[] nodes;

    private double[] z1 = new double[1001];
    private double[] z2 = new double[1001];
    private double[] z3 = new double[1001];
    private double[] z4 = new double[1001];


    Landmark(Graph_Node[] nodes){
        this.nodes = nodes;
        //System.out.println("Double.MIN_VALUE="+Tool.df2.format(Double.MIN_VALUE));
        double low_lon = Double.MAX_VALUE;
        double high_lon = -Double.MAX_VALUE;
        double low_lat  = Double.MAX_VALUE;
        double high_lat = -Double.MAX_VALUE;

        for(int i = 1; i<=1000; i++){
            Graph_Node curr = nodes[i];
            if(curr.getLon()<low_lon){
                //System.out.println("lowlon");
                low_lon=curr.getLon();
                node_low_lon=curr;
            }
            if(curr.getLon()>high_lon){
                //System.out.println(i+" : "+ curr.getLon() + " > "+ high_lon);
                high_lon=curr.getLon();
                node_high_lon=curr;
            }
            if(curr.getLat()<low_lat){
                //System.out.println("lowlat");
                low_lat=curr.getLat();
                node_low_lat=curr;
            }
            if(curr.getLat()>high_lat){
                //System.out.println("highlat");
                high_lat=curr.getLat();
                node_high_lat=curr;
            }
        }
        set_distances();
    }


    public Graph_Node getNode_low_lon() {
        return node_low_lon;
    }


    public Graph_Node getNode_high_lon() {
        return node_high_lon;
    }

    public Graph_Node getNode_low_lat() {
        return node_low_lat;
    }

    public Graph_Node getNode_high_lat() {
        return node_high_lat;
    }

    void set_distances(){
        for(int i = 1; i<=1000; i++){
            Graph_Node curr = nodes[i];
            z1[i]=Tool.cal_distance(curr, node_high_lat);
            z2[i]=Tool.cal_distance(curr, node_high_lon);
            z3[i]=Tool.cal_distance(curr, node_low_lat);
            z4[i]=Tool.cal_distance(curr, node_low_lon);
        }
    }

    double cal_distance(Graph_Node g1, Graph_Node g2){
        int num_1=g1.getIndex();
        int num_2=g2.getIndex();

        double len_1 = Math.abs(z1[1]-z1[2]);
        double len_2 = Math.abs(z2[1]-z2[2]);
        double len_3 = Math.abs(z3[1]-z3[2]);
        double len_4 = Math.abs(z4[1]-z4[2]);

        double min = Math.min(Math.min(len_1,len_2) , Math.min(len_3,len_4));
        return min;
    }


}
