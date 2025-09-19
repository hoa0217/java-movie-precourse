package domain.theater;

import java.time.LocalTime;

public record TheaterOperatingHours(
    LocalTime startTime,
    LocalTime endTime
) {

  public boolean isStartTimeLaterThanEndTime() {
    return startTime.isAfter(endTime);
  }

  public boolean isEndTimeAfter(LocalTime time) {
    return endTime.isAfter(time);
  }
}
