package Chapter10.ThreeStacksInOneArray.src.main.java.coding.challenge11;
 
public class StackNode {

    int value;
    int backLink;

    StackNode(int value, int backLink) {
        this.value = value;
        this.backLink = backLink;
    }

    @Override
    public String toString() {
        return value + "(back link: " + backLink + ")";
    }

}
