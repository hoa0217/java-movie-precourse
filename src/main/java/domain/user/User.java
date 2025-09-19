package domain.user;

public class User {

  private final String email;
  private Point point;

  public User(String email) {
    this.email = email;
    this.point = new Point(0);
  }

  public void usePoint(long usedPoint) {
    long newPoint = this.point.point() - usedPoint;
    this.point = new Point(newPoint);
  }
}
