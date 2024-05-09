
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;
class Movie {
    public static Movie add;
    private String title;
    private List<String>cast;
    private String category;
    private String releaseDate;
    private String boxOffice;

    public Movie(String title, List<String>cast , String category, String releaseDate, String boxOffice) {
        this.title = title;
        this.cast = cast;
        this.category = category;
        this.releaseDate = releaseDate;
        this.boxOffice = boxOffice;
    }

    // Getters and setters for each value
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", category: " + category + ", Release Date: " + releaseDate + ", Box Office: " + boxOffice;
    }

    public static boolean containsGmail(String input) {
        String regex = ".*@gmail\\.com$";
        return Pattern.matches(regex, input);
    }

}

public class App {
   public App() {
   }

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("\n\n                  Welcome to IMDB");
      System.out.print("Please Enter Your Email : ");
      String email = input.next();
      if (Movie.containsGmail(email)) {
         List<Movie> movies = new ArrayList();
         List<String> cast1 = Arrays.asList("Robert Downey Jr.", "Chris Evans", "Mark Ruffalo");
         List<String> cast2 = Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page");
         List<String> cast3 = Arrays.asList("Christian Bale", "Heath Ledger", "Aaron Eckhart");
         List<String> cast4 = Arrays.asList("Tom Hanks", "Robin Wright", "Gary Sinise");
         List<String> cast5 = Arrays.asList("Tim Robbins", "Morgan Freeman", "Bob Gunton");
         List<String> cast6 = Arrays.asList("Marlon Brando", "Al Pacino", "James Caan");
         List<String> cast7 = Arrays.asList("Tom Cruise", "Kelly McGillis", "Val Kilmer");
         List<String> cast8 = Arrays.asList("Elijah Wood", "Viggo Mortensen", "Ian McKellen");
         List<String> cast9 = Arrays.asList("Emma Watson", "Daniel Radcliffe", "Rupert Grint");
         List<String> cast10 = Arrays.asList("Johnny Depp", "Geoffrey Rush", "Orlando Bloom");
         movies.add(new Movie("The Avengers", cast1, "Superhero film", "April 11, 2012", "220-225 Million Dollars"));
         movies.add(new Movie("Inception", cast2, "Science Fiction", "July 16, 2010", "825.5 Million Dollars"));
         movies.add(new Movie("The Dark Knight", cast3, "Superhero film", "July 18, 2008", "1.005 Billion Dollars"));
         movies.add(new Movie("Forrest Gump", cast4, "Drama", "July 6, 1994", "678.2 Million Dollars"));
         movies.add(new Movie("The Shawshank Redemption", cast5, "Drama", "September 23, 1994", "58.3 Million Dollars"));
         movies.add(new Movie("The Godfather", cast6, "Crime film", "March 24, 1972", "245-286 Million Dollars"));
         movies.add(new Movie("Top Gun", cast7, "Action", "May 16, 1986", "356.8 Million Dollars"));
         movies.add(new Movie("The Lord of the Rings: The Fellowship of the Ring", cast8, "Fantasy", "December 19, 2001", "887.8 Million Dollars"));
         movies.add(new Movie("Harry Potter and the Philosopher's Stone", cast9, "Fantasy", "November 16, 2001", "974.8 Million Dollars"));
         movies.add(new Movie("Pirates of the Caribbean: The Curse of the Black Pearl", cast10, "Adventure", "July 9, 2003", "654.3 Million Dollars"));
         Collections.sort(movies, Comparator.comparing(Movie::getTitle));
         System.out.println("\n\n\n                             Search Movie");
         List<Movie> favoriteMovies = new ArrayList();

         while(true) {
            while(true) {
               System.out.println("\n\n                       If You Want to search by Title Press 1");
               System.out.println("                       If You Want to search by category press 2");
               System.out.println("                       If You Want to add movie favourte list press 3");
               System.out.println("                       If you want to see Personal Details and favourte Movie List press 4");
               System.out.println("                       If you want to search from favourte Movie List press 5");
               System.out.println("                       If You want to Exit press 6");
               System.out.print("Enter the Number : ");
               int choose = input.nextInt();
               input.nextLine();
               
               if (choose == 1) {
                  System.out.print("Enter the title to search: ");
                  String searchTitle = input.nextLine();
                  Iterator var26 = movies.iterator();

                  while(var26.hasNext()) {
                     Movie movie = (Movie)var26.next();
                     if (movie.getTitle().equalsIgnoreCase(searchTitle)) {
                        System.out.println("\n\n                     Movie Found:\n" + String.valueOf(movie));
                     }
                  }
               } else if (choose == 2) {
                  System.out.print("\nEnter the category to search: ");
                  String searchTitle = input.nextLine().trim();
                  int p = 0;
                  Iterator var19 = movies.iterator();

                  while(var19.hasNext()) {
                     Movie movie = (Movie)var19.next();
                     if (movie.getCategory().equalsIgnoreCase(searchTitle)) {
                        if (p == 0) {
                           System.out.println("\n\n                  Movies Found in Category: " + searchTitle);
                           ++p;
                        }

                        System.out.println(movie);
                     }
                  }
               }  else if (choose == 3) {
                  System.out.print("\nEnter the title of the movie to add to your favorite list: ");
                  String favoriteTitle = input.nextLine().trim();
  
                  // Find the movie in the list of all movies
                  Optional<Movie> foundMovie = movies.stream()
                          .filter(movie -> movie.getTitle().equalsIgnoreCase(favoriteTitle))
                          .findFirst();
  
                  if (foundMovie.isPresent()) {
                      favoriteMovies.add(foundMovie.get());
                      System.out.println("\nAdded to favorite list: " + foundMovie.get().getTitle());
                  } else {
                      System.out.println("Movie not found in the list.");
                  }
              }
              else if(choose == 4){
                  System.out.println("Md Safiqul Islam Nasim \nmdsafiqulislamnasim1234@gmail.com\n01930802944");
                  System.out.println("\n\n\n             Here is the list of Favourite Movie List");
                  Collections.sort(favoriteMovies, Comparator.comparing(Movie::getTitle));
                  for (Movie faMovie : favoriteMovies){
                      System.out.println(faMovie);
                  }
                  System.out.println("\n\n               If You Want to Delete Movie From Favourite List Press 1 , if want to back press 2");
                  int delete = input.nextInt();
                  if(delete == 1){
                      input.nextLine();
                      String removeTitle = input.nextLine().trim();
                      // Find the movie in the favorite list
                      Optional<Movie> foundFavoriteMovie = favoriteMovies.stream()
                              .filter(movie -> movie.getTitle().equalsIgnoreCase(removeTitle))
                              .findFirst();
  
                      if (foundFavoriteMovie.isPresent()) {
                          favoriteMovies.remove(foundFavoriteMovie.get());
                          System.out.println("\nRemoved from favorite list: " + foundFavoriteMovie.get().getTitle());
                      } else {
                          System.out.println("Movie not found in the favorite list.");
                      }
                  }
                  else if(delete == 2) {
                      continue;
                  }
              }
              else if(choose == 5){
                  System.out.print("\nEnter the title of the movie to search in your favorite list: ");
                  String searchTitle = input.nextLine().trim();
  
                  // Find the movie in the favorite list
                  Optional<Movie> foundFavoriteMovie = favoriteMovies.stream()
                          .filter(movie -> movie.getTitle().equalsIgnoreCase(searchTitle))
                          .findFirst();
  
                  if (foundFavoriteMovie.isPresent()) {
                      System.out.println("\nMovie Found in Favorite List:\n" + foundFavoriteMovie.get());
                  } else {
                      System.out.println("Movie not found in the favorite list.");
                  }
              }
              else {
                  break;
                     }
                  }
               }
            
         
      } else {
         System.out.println("Please Enter a Valid Email");
      }
   }
}
