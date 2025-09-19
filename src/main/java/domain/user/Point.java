package domain.user;

public record Point(
    long point
) {

  public Point(long point) {
    if (point < 0L) {
      throw new IllegalArgumentException();
    }
    this.point = point;
  }
}
