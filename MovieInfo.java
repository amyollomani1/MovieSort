import java.util.Comparator;

public class MovieInfo implements Comparable<MovieInfo> {  
   String title;
   String genre;
   String leadActor;
   
   MovieInfo(String t, String g, String a) {
      title = t; genre = g; leadActor = a;
   }
   public String toString() {
      return title + " " + genre + " " + leadActor + "\n";
   }
   // getters
   public String getTitle() { return title; }
   public String getGenre( ) { return genre; }
   public String getActor( ) { return leadActor; }
   
   public int compareTo(MovieInfo other) {
      
	   return title.compareTo(other.getTitle());
   }
   public static class GenreOrder implements Comparator<MovieInfo>{
	   
	   public int  compare(MovieInfo movie1, MovieInfo movie2) {
		   return movie1.getGenre().compareTo(movie2.getGenre());
	   }
	   
   }
   public static class ActorOrder implements Comparator <MovieInfo> {
	   
	   public int compare(MovieInfo movie1, MovieInfo movie2) {
		   return movie1.getActor().compareTo(movie2.getActor());
	   }
   }
   
   
}