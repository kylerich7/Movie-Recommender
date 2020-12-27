package src.filters;

import src.model.MovieDatabase;

public class GenreFilter implements Filter {
  private final String myGenre;

  public GenreFilter(String genre) {
    myGenre = genre;
  }

  @Override
  public boolean satisfies(String id) {
    return MovieDatabase.getGenres(id).contains(myGenre);
  }
}
