package domain.schedule;

import domain.movie.Movie;
import domain.seat.Seats;
import domain.theater.Theater;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ScreeningSchedule(
    Theater theater,
    Movie movie,
    LocalDate screeningDate,
    LocalDateTime screeningStartTime,
    Seats seats
) {

  public ScreeningSchedule(Theater theater, Movie movie, LocalDate screeningDate, LocalDateTime screeningStartTime) {
    this(theater, movie, screeningDate, screeningStartTime, new Seats());
  }

  public ScreeningSchedule(Theater theater, Movie movie, LocalDate screeningDate, LocalDateTime screeningStartTime, Seats seats) {
    this.theater = theater;
    this.movie = movie;
    validateScreeningDate(movie, screeningDate);
    this.screeningDate = screeningDate;

    validateScreeningStartTime(theater, movie, screeningStartTime);
    this.screeningStartTime = screeningStartTime;
    this.seats = seats;
  }

  private static void validateScreeningDate(Movie movie, LocalDate screeningDate) {
    if (!movie.isContainPeriod(screeningDate)) {
      throw new IllegalArgumentException();
    }
  }

  private static void validateScreeningStartTime(Theater theater, Movie movie, LocalDateTime screeningStartTime) {
    LocalDateTime endDateTime = screeningStartTime.plusMinutes(movie.runtimeMinutes());
    if(theater.isEndTimeAfter(endDateTime.toLocalTime())){
      throw new IllegalArgumentException();
    }
  }
}
