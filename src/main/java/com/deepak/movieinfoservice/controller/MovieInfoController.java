package com.deepak.movieinfoservice.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.movieinfoservice.model.Movie;

@RefreshScope
@RestController
@RequestMapping ( "/movies" )
public class MovieInfoController
{
   private static final Logger logger = LoggerFactory.getLogger( MovieInfoController.class );
   
   @Value("${eureka.instance.instance-id}")
   private String instanceId;
   
   @Value("${message:Movie Info service - Config Server is not working..pelase check}")
   private String message;
   
   private static List< Movie > movieList = getAllMovies();
   
   @RequestMapping( method=RequestMethod.GET, path="/message")
   public String getMessage()
   {
      String message = this.message + " - with instance id - "+ this.instanceId + " at this time - " + LocalDateTime.now(); 
      logger.debug( "Here's the message : {}", message );
      return message;
   }
   
   @RequestMapping ( method = RequestMethod.GET, path = "/{movieId}" )
   public Movie getMovieDetails( @PathVariable ( "movieId" ) String movieId )
   {
      logger.debug( "Instance Id for movie-info-service : {}", instanceId );
      Optional<Movie> item =  movieList.stream().filter( movie -> movie.getMovieId().equals( movieId ) ).findAny();
      if( item.isPresent() )
      {
         return item.get();
      }
      else
      {
         throw new IllegalArgumentException(" Movie Not Found ");
      }
   }
   
   private static List< Movie > getAllMovies()
   {
      return Stream.< Movie > builder()
                   .add( new Movie( "1234", "Transformers", "Description for Transformers" ) )
                   .add( new Movie( "1236", "Big Lebowski", "Description for Big Lebowski" ) )
                   .add( new Movie( "1237", "Titanic", "Description for Titanic" ) )
                   .build()
                   .collect( Collectors.toList() );
   }
}
