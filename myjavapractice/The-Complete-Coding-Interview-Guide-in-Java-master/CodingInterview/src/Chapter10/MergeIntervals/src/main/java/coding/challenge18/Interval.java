package Chapter10.MergeIntervals.src.main.java.coding.challenge18;
 
public class Interval {

    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
};
