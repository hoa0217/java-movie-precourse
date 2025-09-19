package domain.seat;

import java.util.ArrayList;
import java.util.List;

public record Seats(
    List<Seat> seats
) {

  private static char ROW_SIZE = 'C';
  private static int COLUMN_SIZE = 10;

  private static List<Seat> initializeSeats() {
    List<Seat> seatList = new ArrayList<>();
    for (char i = 'A'; i <= ROW_SIZE; i++) {
      for (int j = 1; j <= COLUMN_SIZE; j++) {
        seatList.add(new Seat(new SeatNumber(i, j)));
      }
    }
    return seatList;
  }

  public Seats() {
    this(initializeSeats());
  }
}
