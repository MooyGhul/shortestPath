package Project;

import java.text.DecimalFormat;

public class Tool {

    //static DecimalFormat df2 = new DecimalFormat("#.######");

    static double cal_distance(Graph_Node g1, Graph_Node g2){
        double dlat = 2 * Math.PI * (g2.getLat() - g1.getLat()) / 360.0;
        double mlat = 2 * Math.PI * (g1.getLat() + g2.getLat()) / 2.0 / 360;
        double dlon = 2 * Math.PI * (g2.getLon() - g1.getLon()) / 360.0;

        return 6371009 * Math.pow(Math.pow(dlat,2) + Math.pow((Math.cos(mlat) * dlon),2),0.5);
    }

}
