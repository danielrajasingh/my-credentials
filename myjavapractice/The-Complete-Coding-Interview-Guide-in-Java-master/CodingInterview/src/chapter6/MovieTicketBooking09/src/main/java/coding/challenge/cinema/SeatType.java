package chapter6.MovieTicketBooking09.src.main.java.coding.challenge.cinema;

public enum SeatType {
 
    SIMPLE(1), SILVER(5), GOLD(10);

    private final int price;

    private SeatType(int price) {
        this.price = price;
    }

    protected int getPrice() {
        return price;
    }
}
