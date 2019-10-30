package Project;

public class MinHeap {

    private Pair<Graph_Node,Double>[] Heap;

    private int size;
    private int maxsize;
    private static final int FRONT = 1;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new Pair[this.maxsize + 1];
        Graph_Node init_node = new Graph_Node();
        init_node.setLat(0.0);
        init_node.setLon(0.0);
        init_node.setIndex(0);
        Pair<Graph_Node,Double> init_pair = new Pair<>(init_node,-1.0);
        Heap[0] = init_pair;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        Pair<Graph_Node,Double> tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos].getDistance() > Heap[rightChild(pos)].getDistance() ||
                    Heap[pos].getDistance() > Heap[leftChild(pos)].getDistance()) {

                if (Heap[leftChild(pos)].getDistance() < Heap[rightChild(pos)].getDistance()) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    private void upHeapify(int pos){
        //System.out.println("upHeapify: " + pos);
        if( pos!=FRONT){
            if (Heap[pos].getDistance() < Heap[parent(pos)].getDistance()){
                swap(pos, parent(pos));
                upHeapify(parent(pos));
            }
        }
    }

    // Function to insert a node into the heap
    public void insert(Pair<Graph_Node,Double> element)
    {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;

        while (Heap[current].getDistance() < Heap[parent(current)].getDistance()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void update(int index, double new_dist){
        int i;
        for(i =0; i<=size; i++){
            if(Heap[i].getNode().getIndex()==index){
                Heap[i].setDistance(new_dist);
                break;
            }
        }
        upHeapify(i);
    }

    public Pair<Graph_Node,Double> peek(){
        return Heap[FRONT];
    }
    /********************************************
    void MinHeap::decreaseKey(int i, int new_val)
    {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i])
        {
           swap(&harr[i], &harr[parent(i)]);
           i = parent(i);
        }
    }
     **********************************************/





    public Pair<Graph_Node,Double> remove()
    {
        Pair popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        if(size >0) {
            minHeapify(FRONT);
        }
        return popped;
    }

    int size(){
        return size;
    }
}
