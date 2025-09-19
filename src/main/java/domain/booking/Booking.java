package domain.booking;

import domain.seat.Seats;

public class Booking {

  private final Seats seats;
  private final long bookingAmount;
  private Long discountedAmount;
  private Long paymentAmount;
  private PaymentMethod paymentMethod;
  private Long finalPaymentAmount;

  public Booking(Seats seats) {
    this.seats = seats;
    this.bookingAmount = seats.calculateSeatPrice();
  }
}
