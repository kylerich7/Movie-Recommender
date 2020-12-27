package src.filters;

import src.model.MovieDatabase;

import java.util.ArrayList;

public class DirectorsFilter implements Filter {
  private final ArrayList<String> myDirectors;

  public DirectorsFilter(String directors) {
    myDirectors = new ArrayList<String>();
    buildDirectors(directors);
  }

  private void buildDirectors(String directors) {
    int startIndex = 0;
    int endIndex = directors.indexOf(",");
    while (true) {
      if (endIndex != -1) {
        myDirectors.add(directors.substring(startIndex, endIndex));
        startIndex = endIndex + 1;
        endIndex = directors.indexOf(",", endIndex + 1);
      } else {
        myDirectors.add(directors.substring(startIndex));
        break;
      }
    }
  }

  @Override
  public boolean satisfies(String id) {
    for (String director : myDirectors) {
      if (MovieDatabase.getDirector(id).contains(director)) {
        return true;
      }
    }
    return false;
  }
}
