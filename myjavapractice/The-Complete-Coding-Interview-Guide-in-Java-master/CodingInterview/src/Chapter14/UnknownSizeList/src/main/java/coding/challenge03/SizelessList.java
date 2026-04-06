package Chapter14.UnknownSizeList.src.main.java.coding.challenge03;

public class SizelessList {

    private final int[] arr;

    public SizelessList(int[] arr) {
        this.arr = arr.clone();
    }

    public int peekAt(int index) {
        if (index >= arr.length) {
            return -1;
        }
        
        return arr[index];
    }
}
