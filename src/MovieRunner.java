package src;

import src.filters.AllFilters;
import src.filters.GenreFilter;
import src.model.MovieDatabase;
import src.model.RaterDatabase;
import src.model.Rating;
import src.model.Ratings;

import java.util.ArrayList;
import java.util.Collections;

public class MovieRunner {

  // Raw Average Runners

  public void printAverageRatings() {
    // src.model.Ratings ratings = new src.model.Ratings("ratings_short.csv",
    // "ratedmovies_short.csv");
    Ratings ratings = new Ratings();
    int minRaters = 35;

    ArrayList<Rating> avRatings = ratings.getRawAverageRatings(minRaters);
    Collections.sort(avRatings);
    System.out.println("Movies: " + MovieDatabase.size());
    System.out.println("Raters: " + RaterDatabase.size());
    for (Rating r : avRatings) {
      System.out.println(MovieDatabase.getTitle(r.getItem()) + r);
    }
  }

  public void printAverageRatingsByFilters() {
    // src.model.Ratings ratings = new src.model.Ratings("ratings_short.csv",
    // "ratedmovies_short.csv");
    Ratings ratings = new Ratings();

    int minRaters = 3;

    String genre = "Drama"; // src.filters.GenreFilter Parameter
    // int year = 1990;        //src.filters.YearAfterFilter Parameter
    // int minMinutes = 90;    //src.filters.MinutesFilter Parameter 1
    // int maxMinutes = 180;   //src.filters.MinutesFilter Parameter 2
    // String directors = "Clint Eastwood"; //DirectorFilter Parameter

    AllFilters filters = new AllFilters();
    filters.addFilter(new GenreFilter(genre));
    // filters.addFilter(new src.filters.YearAfterFilter(year));
    // filters.addFilter(new src.filters.MinutesFilter(minMinutes, maxMinutes));
    // filters.addFilter(new src.filters.DirectorsFilter(directors));

    ArrayList<Rating> filteredAvRatings = ratings.getRawAverageRatingsByFilter(minRaters, filters);
    Collections.sort(filteredAvRatings);
    System.out.println("Movies: " + filteredAvRatings.size());
    System.out.println("Raters: " + RaterDatabase.size());
    for (Rating r : filteredAvRatings) {
      System.out.println(MovieDatabase.getTitle(r.getItem()) + r);
    }
  }

  // Weighted Average Runners

  public void printSimilarRatings() {
    // src.model.Ratings ratings = new src.model.Ratings("ratings_short.csv",
    // "ratedmovies_short.csv");
    Ratings ratings = new Ratings();

    int minRaters = 3;
    int numSimilarRaters = 10;
    String raterID = "337";

    ArrayList<Rating> similarRatings =
        ratings.getSimilarRatings(raterID, numSimilarRaters, minRaters);

    for (Rating r : similarRatings) {
      System.out.println("6      " + MovieDatabase.getTitle(r.getItem()) + r);
      break;
    }
  }

  public void printSimilarRatingsByFilters() {
    // src.model.Ratings ratings = new src.model.Ratings("ratings_short.csv",
    // "ratedmovies_short.csv");
    Ratings ratings = new Ratings();

    int minRaters = 5;
    int numSimilarRaters = 20;
    String raterID = "964";

    String genre = "Drama"; // src.filters.GenreFilter Parameter
    // int year = 1990;        //src.filters.YearAfterFilter Parameter
    // int minMinutes = 90;    //src.filters.MinutesFilter Parameter 1
    // int maxMinutes = 180;   //src.filters.MinutesFilter Parameter 2
    // String directors = "Clint Eastwood"; //DirectorFilter Parameter

    AllFilters filters = new AllFilters();
    filters.addFilter(new GenreFilter(genre));
    // filters.addFilter(new src.filters.YearAfterFilter(year));
    // filters.addFilter(new src.filters.MinutesFilter(minMinutes, maxMinutes));
    // filters.addFilter(new src.filters.DirectorsFilter(directors));

    ArrayList<Rating> similarRatings =
        ratings.getSimilarRatingsByFilter(raterID, numSimilarRaters, minRaters, filters);
    for (Rating r : similarRatings) {
      System.out.println(MovieDatabase.getTitle(r.getItem()) + r);
    }
  }
}
