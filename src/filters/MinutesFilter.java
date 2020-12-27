package src.filters;

import src.model.MovieDatabase;

public class MinutesFilter implements Filter {
  private final int minMinutes;
  private final int maxMinutes;

  public MinutesFilter(int min, int max) {
    minMinutes = min;
    maxMinutes = max;
  }

  @Override
  public boolean satisfies(String id) {
    return MovieDatabase.getMinutes(id) >= minMinutes && MovieDatabase.getMinutes(id) <= maxMinutes;
  }
}
