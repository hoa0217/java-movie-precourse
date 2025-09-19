package domain.seat;

public enum SeatGrade {
  S(18000),
  A(15000),
  B(12000);

  private final long price;

  SeatGrade(long price) {
    this.price = price;
  }

  public static SeatGrade getGrade(SeatNumber number) {
    if (number.row() >= 'C') {
      return S;
    }
    if (number.row() >= 'B') {
      return A;
    }

    return B;
  }

  public long getPrice() {
    return price;
  }
}
