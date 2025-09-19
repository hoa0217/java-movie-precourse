package domain.seat;

public class Seat {
  private final SeatNumber number;
  private final SeatGrade grade;
  private SeatStatus status;

  public Seat(SeatNumber number) {
    this(number, SeatGrade.getGrade(number), SeatStatus.AVAILABLE);
  }

  public Seat(SeatNumber number, SeatGrade grade, SeatStatus status) {
    this.number = number;
    this.grade = grade;
    this.status = status;
  }

  public boolean isAvailable(){
    return status == SeatStatus.AVAILABLE;
  }

  public void select(){
    if(!isAvailable()){
      throw new IllegalArgumentException();
    }
    this.status = SeatStatus.RESERVED;
  }

  public long price(){
    return grade.getPrice();
  }
}
