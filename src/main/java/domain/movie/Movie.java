package domain.movie;

import java.time.LocalDate;

public record Movie(
    String name,
    ScreeningPeriod screeningPeriod,
    MovieRuntime movieRuntime
) {

  public boolean isContainPeriod(LocalDate date){
    return screeningPeriod.isContains(date);
  }

  public long runtimeMinutes(){
    return movieRuntime.minute();
  }
}
