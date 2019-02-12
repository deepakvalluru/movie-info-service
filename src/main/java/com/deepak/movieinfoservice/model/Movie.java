package com.deepak.movieinfoservice.model;

public class Movie
{
   private String movieId;
   private String name;
   private String desc;
   
   public Movie()
   {
      
   }
   
   public Movie( String movieId, String name, String desc )
   {
      super();
      this.movieId = movieId;
      this.name = name;
      this.desc = desc;
   }
   
   /**
    * @return the movieId
    */
   public String getMovieId()
   {
      return movieId;
   }
   /**
    * @param movieId the movieId to set
    */
   public void setMovieId( String movieId )
   {
      this.movieId = movieId;
   }
   /**
    * @return the name
    */
   public String getName()
   {
      return name;
   }
   /**
    * @param name the name to set
    */
   public void setName( String name )
   {
      this.name = name;
   }
   /**
    * @return the desc
    */
   public String getDesc()
   {
      return desc;
   }
   /**
    * @param desc the desc to set
    */
   public void setDesc( String desc )
   {
      this.desc = desc;
   }
   
}
