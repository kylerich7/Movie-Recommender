package src;

import edu.duke.FileResource;
import src.model.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RecommendationRunner implements Recommender {

  public RecommendationRunner() {
    ArrayList<String> movies = getItemsToRate();
  }

  public static void main(String[] args) {
    new RecommendationRunner();
  }

  public ArrayList<String> getItemsToRate() {
    Ratings ratings = new Ratings();
    ArrayList<String> movies = new ArrayList<String>();
    movies.add("1201607");
    movies.add("1190080");
    movies.add("1262416");
    movies.add("1323594");
    movies.add("1375666");
    movies.add("1392170");
    movies.add("1446714");
    movies.add("1502712");
    movies.add("1515091");
    movies.add("1798684");
    movies.add("1905041");
    movies.add("1922777");
    movies.add("1951261");
    movies.add("2024544");
    movies.add("2170439");
    movies.add("2404463");
    movies.add("2848292");
    movies.add("3063516");
    movies.add("1872181");
    movies.add("1855325");

    return movies;
  }

  public void printRecommendationsFor(String webRaterID) {
    ArrayList<Rating> ratings = getSimilarRatings(webRaterID);
    DecimalFormat value = new DecimalFormat("#.#");
    if (ratings.size() == 0) {
      System.out.print("<html lang=\"en\"><head><meta charset=\"UTF-8\">");
      System.out.println("<style>");
      System.out.println(
          "@import url('https://fonts.googleapis.com/css?family=Amarante');html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video {margin: 0;padding: 0;border: 0;font-size: 100%;font: inherit;vertical-align: baseline;outline: none;-webkit-font-smoothing: antialiased;-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;-webkit-box-sizing: border-box;-moz-box-sizing: border-box;box-sizing: border-box;}html { overflow-y: scroll; }body {background: #eee url('https://i.imgur.com/eeQeRmk.png'); /* https://subtlepatterns.com/weave/ */font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;font-size: 62.5%;line-height: 1;color: #585858;padding: 22px 10px;padding-bottom: 55px;}::selection { background: #5f74a0; color: #fff; }::-moz-selection { background: #5f74a0; color: #fff; }::-webkit-selection { background: #5f74a0; color: #fff; }br { display: block; line-height: 1.6em; }article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section { display: block; }ol, ul { list-style: none; }input, textarea {-webkit-font-smoothing: antialiased;-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;-webkit-box-sizing: border-box;-moz-box-sizing: border-box;box-sizing: border-box;outline: none;}blockquote, q { quotes: none; }blockquote:before, blockquote:after, q:before, q:after { content: ''; content: none; }strong, b { font-weight: bold; }table { border-collapse: collapse; border-spacing: 0; }img { border: 0; max-width: 100%; }h1 {font-family: 'Amarante', Tahoma, sans-serif;font-weight: bold;font-size: 3.6em;line-height: 1.7em;margin-bottom: 10px;text-align: center;}/** page structure **/#wrapper {display: block;width: 85%;background: #fff;margin: 0 auto;padding: 10px 17px;-webkit-box-shadow: 2px 2px 3px -1px rgba(0,0,0,0.35);}#keywords {margin: 0 auto;font-size: 1.2em;margin-bottom: 15px;}#keywords thead {background: #c9dff0;}#keywords thead tr th {font-weight: bold;padding: 12px 30px;padding-left: 42px;}#keywords thead tr th span {padding-right: 20px;background-repeat: no-repeat;background-position: 100% 100%;}#keywords thead tr th.headerSortUp, #keywords thead tr th.headerSortDown {background: #acc8dd;}#keywords thead tr th.headerSortUp span {background-image: url('https://i.imgur.com/SP99ZPJ.png');}#keywords thead tr th.headerSortDown span {background-image: url('https://i.imgur.com/RkA9MBo.png');}#keywords tbody tr {color: #555;}#keywords tbody tr td {text-align: center;padding: 15px 10px;}#keywords tbody tr td.lalign {text-align: left;}");
      System.out.println("</style></head>");
      System.out.println(
          "<body><div id=\"wrapper\"><h1>No Movies Found!</h1><table id=\"keywords\" cellspacing=\"0\" cellpadding=\"0\"><thead><tr><th><span>Ranking</span></th><th><span>Title</span></th><th><span>Genre</span></th><th><span>Minutes</span></th><th><span>Year</span></th><th><span>src.model.Rating</span></th><th><span>Raters</span></th></tr></thead><tbody>");
      System.out.print(
          "<tr><td>"
              + "NA"
              + "</td><td class=\"lalign\">"
              + "NA"
              + "</td><td class=\"lalign\">"
              + "NA"
              + "</td><td>"
              + "NA"
              + "</td><td>"
              + "NA"
              + "</td><td>"
              + "NA"
              + " / 10"
              + "</td><td>"
              + "NA"
              + "</td></tr>");
      System.out.print(
          "<tr><td>"
              + "NA"
              + "</td><td class=\"lalign\">"
              + "NA"
              + "</td><td class=\"lalign\">"
              + "NA"
              + "</td><td>"
              + "NA"
              + "</td><td>"
              + "NA"
              + "</td><td>"
              + "NA"
              + " / 10"
              + "</td><td>"
              + "NA"
              + "</td></tr>");
      System.out.print("</tbody></table></div></body></html>");
    } else {
      System.out.print("<html lang=\"en\"><head><meta charset=\"UTF-8\">");
      System.out.println("<style>");
      System.out.println(
          "@import url('https://fonts.googleapis.com/css?family=Amarante');html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video {margin: 0;padding: 0;border: 0;font-size: 100%;font: inherit;vertical-align: baseline;outline: none;-webkit-font-smoothing: antialiased;-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;-webkit-box-sizing: border-box;-moz-box-sizing: border-box;box-sizing: border-box;}html { overflow-y: scroll; }body {background: #eee url('https://i.imgur.com/eeQeRmk.png'); /* https://subtlepatterns.com/weave/ */font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;font-size: 62.5%;line-height: 1;color: #585858;padding: 22px 10px;padding-bottom: 55px;}::selection { background: #5f74a0; color: #fff; }::-moz-selection { background: #5f74a0; color: #fff; }::-webkit-selection { background: #5f74a0; color: #fff; }br { display: block; line-height: 1.6em; }article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section { display: block; }ol, ul { list-style: none; }input, textarea {-webkit-font-smoothing: antialiased;-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;-webkit-box-sizing: border-box;-moz-box-sizing: border-box;box-sizing: border-box;outline: none;}blockquote, q { quotes: none; }blockquote:before, blockquote:after, q:before, q:after { content: ''; content: none; }strong, b { font-weight: bold; }table { border-collapse: collapse; border-spacing: 0; }img { border: 0; max-width: 100%; }h1 {font-family: 'Amarante', Tahoma, sans-serif;font-weight: bold;font-size: 3.6em;line-height: 1.7em;margin-bottom: 10px;text-align: center;}/** page structure **/#wrapper {display: block;width: 85%;background: #fff;margin: 0 auto;padding: 10px 17px;-webkit-box-shadow: 2px 2px 3px -1px rgba(0,0,0,0.35);}#keywords {margin: 0 auto;font-size: 1.2em;margin-bottom: 15px;}#keywords thead {background: #c9dff0;}#keywords thead tr th {font-weight: bold;padding: 12px 30px;padding-left: 42px;}#keywords thead tr th span {padding-right: 20px;background-repeat: no-repeat;background-position: 100% 100%;}#keywords thead tr th.headerSortUp, #keywords thead tr th.headerSortDown {background: #acc8dd;}#keywords thead tr th.headerSortUp span {background-image: url('https://i.imgur.com/SP99ZPJ.png');}#keywords thead tr th.headerSortDown span {background-image: url('https://i.imgur.com/RkA9MBo.png');}#keywords tbody tr {color: #555;}#keywords tbody tr td {text-align: center;padding: 15px 10px;}#keywords tbody tr td.lalign {text-align: left;}");
      System.out.println("</style></head>");
      System.out.println(
          "<body><div id=\"wrapper\"><h1>src.model.Movie Suggestions</h1><table id=\"keywords\" cellspacing=\"0\" cellpadding=\"0\"><thead><tr><th><span>Ranking</span></th><th><span>Title</span></th><th><span>Genre</span></th><th><span>Minutes</span></th><th><span>Year</span></th><th><span>src.model.Rating</span></th><th><span>Raters</span></th></tr></thead><tbody>");
      for (int i = 0; i < Math.min(ratings.size(), 20); i++) {
        Rating currRating = ratings.get(i);
        String movID = currRating.getItem();
        String title = MovieDatabase.getTitle(movID);
        String genre = MovieDatabase.getGenres(movID);
        int minutes = MovieDatabase.getMinutes(movID);
        int year = MovieDatabase.getYear(movID);
        String avRating = value.format((getRawAverageByID(movID, 0)));
        int numRatings = countTotalMovieRatings(movID);
        System.out.print(
            "<tr><td>"
                + (i + 1)
                + "</td><td class=\"lalign\">"
                + title
                + "</td><td class=\"lalign\">"
                + genre
                + "</td><td>"
                + minutes
                + "</td><td>"
                + year
                + "</td><td>"
                + avRating
                + " / 10"
                + "</td><td>"
                + numRatings
                + "</td></tr>");
      }
      System.out.print("</tbody></table></div></body></html>");
    }
  }

  public ArrayList<Rating> getSimilarRatings(String webRaterID) {
    Ratings ratings = new Ratings();
    int minRaters = 5;
    int numSimilarRaters = 50;
    ArrayList<Rating> similarRatings =
        ratings.getSimilarRatings(webRaterID, numSimilarRaters, minRaters);
    return similarRatings;
  }

  public void makeString() {
    FileResource fr = new FileResource();
    String string = "";
    for (String line : fr.lines()) {
      string = string + line.trim();
    }
    System.out.println(string);
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

    return ratingSoFar / raters;
  }
}
