package src.model;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import src.filters.Filter;

import java.util.ArrayList;
import java.util.HashMap;

public class MovieDatabase {
  private static HashMap<String, Movie> ourMovies;

  private static void initialize() {
    if (ourMovies == null) {
      ourMovies = new HashMap<String, Movie>();
      loadMovies("data/ratedmoviesfull.csv");
    }
  }

  public static void initialize(String moviefile) {
    if (ourMovies == null) {
      ourMovies = new HashMap<String, Movie>();
      loadMovies("data/" + moviefile);
    }
  }

  private static void loadMovies(String filename) {
    ArrayList<Movie> movies = new ArrayList<Movie>();
    FileResource fr = new FileResource(filename);
    CSVParser parser = fr.getCSVParser();

    for (CSVRecord record : parser) {
      String anID = record.get("id");
      String aTitl = record.get("title");
      String aYear = record.get("year");
      String theGenres = record.get("genre");
      String aDirector = record.get("director");
      String aCountry = record.get("country");
      String aPoster = record.get("poster");
      int theMinutes = Integer.parseInt(record.get("minutes"));

      movies.add(
          new Movie(anID, aTitl, aYear, theGenres, aDirector, aCountry, aPoster, theMinutes));
    }

    for (Movie m : movies) {
      ourMovies.put(m.getID(), m);
    }
  }

  public static boolean containsID(String id) {
    initialize();
    return ourMovies.containsKey(id);
  }

  public static int getYear(String id) {
    initialize();
    return ourMovies.get(id).getYear();
  }

  public static String getGenres(String id) {
    initialize();
    return ourMovies.get(id).getGenres();
  }

  public static String getTitle(String id) {
    initialize();
    return ourMovies.get(id).getTitle();
  }

  public static Movie getMovie(String id) {
    initialize();
    return ourMovies.get(id);
  }

  public static String getPoster(String id) {
    initialize();
    return ourMovies.get(id).getPoster();
  }

  public static int getMinutes(String id) {
    initialize();
    return ourMovies.get(id).getMinutes();
  }

  public static String getCountry(String id) {
    initialize();
    return ourMovies.get(id).getCountry();
  }

  public static String getDirector(String id) {
    initialize();
    return ourMovies.get(id).getDirector();
  }

  public static int size() {
    return ourMovies.size();
  }

  public static ArrayList<String> filterBy(Filter f) {
    initialize();
    ArrayList<String> list = new ArrayList<String>();
    for (String id : ourMovies.keySet()) {
      if (f.satisfies(id)) {
        list.add(id);
      }
    }

    return list;
  }
}
