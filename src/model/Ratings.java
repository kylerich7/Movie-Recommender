package src.model;

import src.filters.Filter;
import src.filters.TrueFilter;

import java.util.ArrayList;
import java.util.Collections;

public class Ratings {

  public Ratings() {
    this("ratings.csv", "ratedmoviesfull.csv");
  }

  public Ratings(String ratingsFileName, String moviesFileName) {
    RaterDatabase.initialize(ratingsFileName);
    MovieDatabase.initialize(moviesFileName);
  }

  // Raw Average Calculations WITHOUT Weighted Averages Based On Similar Raters

  public double getRawAverageByID(String id, int minRaters) {
    double raters = countTotalMovieRatings(id);
    if (raters < minRaters) {
      return 0.0;
    }

    double ratingSoFar = 0;
    for (Rater r : RaterDatabase.getRaters()) {
      if (r.hasRating(id)) {
        ratingSoFar += r.getRating(id);
      }
    }

    double av = ratingSoFar / raters;
    return av;
  }

  public ArrayList<Rating> getRawAverageRatings(int minRaters) {
    return getRawAverageRatingsByFilter(minRaters, new TrueFilter());
  }

  public ArrayList<Rating> getRawAverageRatingsByFilter(int minRaters, Filter filterCriteria) {
    ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
    ArrayList<Rating> ratings = new ArrayList<Rating>();

    for (String movID : movies) {
      double avRating = getRawAverageByID(movID, minRaters);
      if (avRating != 0.0) {
        Rating r = new Rating(movID, avRating);
        ratings.add(r);
      }
    }

    return ratings;
  }

  // Weighted Average Calculations WITH Weighted Averages Based On Similar Raters

  private double dotProduct(Rater me, Rater rater) {
    double sumProdSoFar = 0;
    for (String movID : me.getItemsRated()) {
      if (rater.hasRating(movID)) {
        double myStandard = me.getRating(movID) - 5.0;
        double raterStandard = rater.getRating(movID) - 5.0;

        sumProdSoFar += myStandard * raterStandard;
      }
    }
    return sumProdSoFar;
  }

  private ArrayList<Rating> getSimilarities(String id) {
    ArrayList<Rating> similarRaters = new ArrayList<Rating>();
    Rater me = RaterDatabase.getRater(id);
    for (Rater rater : RaterDatabase.getRaters()) {
      double dotProd = dotProduct(me, rater);
      if (dotProd >= 0 && rater != me) {
        similarRaters.add(new Rating(rater.getID(), dotProd));
      }
    }
    Collections.sort(similarRaters, Collections.reverseOrder());
    return similarRaters;
  }

  private double getWeightedAverageByID(
      String movID, ArrayList<Rating> similarRaters, int minRaters) {
    double ratingsCountSoFar = 0.0;
    double sumOfWeightedRatingsSoFar = 0.0;

    for (Rating r : similarRaters) {
      String currRaterID = r.getItem();
      double currRaterSimilarityValue = r.getValue();
      Rater currRater = RaterDatabase.getRater(currRaterID);

      if (currRater.hasRating(movID)) {
        sumOfWeightedRatingsSoFar += currRater.getRating(movID) * currRaterSimilarityValue;
        ratingsCountSoFar++;
      }
    }

    if (ratingsCountSoFar < minRaters) {
      return 0.0;
    }

    return sumOfWeightedRatingsSoFar / ratingsCountSoFar;
  }

  public ArrayList<Rating> getSimilarRatings(String raterID, int numSimilarRaters, int minRaters) {
    return getSimilarRatingsByFilter(raterID, numSimilarRaters, minRaters, new TrueFilter());
  }

  public ArrayList<Rating> getSimilarRatingsByFilter(
      String raterID, int numSimilarRaters, int minRaters, Filter filterCriteria) {
    ArrayList<Rating> similarRaters = getSimilarities(raterID);
    ArrayList<Rating> topSimilarRaters = TopRatings(similarRaters, numSimilarRaters);

    ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);

    ArrayList<Rating> finalRatings = new ArrayList<Rating>();

    for (String movID : movies) {
      double weightedAverage = getWeightedAverageByID(movID, topSimilarRaters, minRaters);
      if (weightedAverage != 0.0) {
        finalRatings.add(new Rating(movID, weightedAverage));
      }
    }
    Collections.sort(finalRatings, Collections.reverseOrder());

    return finalRatings;
  }

  // Random Helpers

  private ArrayList<Rating> TopRatings(ArrayList<Rating> array, int howMany) {
    ArrayList<Rating> ret = new ArrayList<Rating>();
    for (int i = 0; i < howMany; i++) {
      ret.add(array.get(i));
    }
    return ret;
  }

  public int countTotalMovieRatings(String movieID) {
    int count = 0;
    for (Rater rater : RaterDatabase.getRaters()) {
      if (rater.hasRating(movieID)) {
        count++;
      }
    }
    return count;
  }
}
