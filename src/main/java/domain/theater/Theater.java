package domain.theater;

import java.time.LocalTime;

public record Theater(
    String name,
    TheaterOperatingHours operatingHours,
    TheaterOperatingType operatingType
) {

  public Theater(String name, TheaterOperatingHours operatingHours, TheaterOperatingType operatingType) {
    this.name = name;

    validateOperatingHours(operatingHours, operatingType);
    this.operatingHours = operatingHours;
    this.operatingType = operatingType;
  }

  private static void validateOperatingHours(TheaterOperatingHours operatingHours, TheaterOperatingType operatingType) {
    if (operatingType == TheaterOperatingType.SAME_DAY_OPERATION &&
        operatingHours.isStartTimeLaterThanEndTime()) {
      throw new IllegalArgumentException();
    }

    if (operatingType == TheaterOperatingType.CROSS_DAY_OPERATION &&
        !operatingHours.isStartTimeLaterThanEndTime()) {
      throw new IllegalArgumentException();
    }
  }

  public boolean isEndTimeAfter(LocalTime time) {
    return operatingHours().isEndTimeAfter(time);
  }
}
