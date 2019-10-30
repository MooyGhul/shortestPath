package Project;

public class Graph_Node {
    private int index;
    private Double lon;
    private Double lat;
    private StringBuilder path;



    void setIndex(int index) {
        this.index = index;
    }

    int getIndex() {
        return index;
    }


    void setLon(Double lon) {
        this.lon = lon;
    }

    void setLat(Double lat) {
        this.lat = lat;
    }

    Double getLon() {
        return lon;
    }

    Double getLat() {
        return lat;
    }


    StringBuilder getPath() {
        return this.path;
    }

    void setPath(StringBuilder sb) {
        this.path=sb;
    }

}
