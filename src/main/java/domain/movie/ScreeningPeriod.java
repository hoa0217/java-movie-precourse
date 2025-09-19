package domain.movie;

import java.time.LocalDate;

public record ScreeningPeriod(
    LocalDate startDate,
    LocalDate endDate
) {

  public ScreeningPeriod(LocalDate startDate, LocalDate endDate) {
    validatePeriod(startDate, endDate);
    this.startDate = startDate;
    this.endDate = endDate;
  }

  private static void validatePeriod(LocalDate startDate, LocalDate endDate) {
    if(startDate.isAfter(endDate)){
      throw new IllegalArgumentException();
    }
  }

  public boolean isContains(LocalDate date){
    return !(startDate.isAfter(date) || endDate.isBefore(date));
  }
}
