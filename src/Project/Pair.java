package Project;

public class Pair<T, U> {
    public Pair(T first, U second) {
        this.second = second;
        this.first = first;
    }

    private T first;
    private U second;

    public T getNode() {
        return first;
    }

    public U getDistance() {
        return second;
    }

    public void setDistance(U distance) {
        this.second = distance;
    }

    public static <T, U> Pair<T, U> pair(T first, U second) {
        return new Pair<>(first, second);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}