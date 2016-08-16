(function() {
  'use strict';

  angular.module('movieflix')
    .service('movieService', movieService);

  movieService.$inject = ['$http', '$q', 'CONFIG'];

  function movieService($http, $q, CONFIG) {

    var self = this;

    self.getMovies = getMovies;
    self.getMovieById = getMovieById;
    self.getMoviesByType = getMoviesByType;
    self.getMoviesByGenre = getMoviesByGenre;
    self.deleteMovie = deleteMovie;
    self.addMovie = addMovie;
    self.editMovie = editMovie;

    function getMovies() {
      return $http.get(CONFIG.API_HOST + '/movies')
        .then(successFn, errorFn);
    }

    function getMovieById(id) {
      return $http.get(CONFIG.API_HOST + '/movies/' + id)
        .then(successFn, errorFn);
    }

    function getMoviesByType(type){
      return $http.get(CONFIG.API_HOST + '/movies/type?type=' + type )
          .then(successFn, errorFn);
    }

    function getMoviesByGenre(genre){
      return $http.get(CONFIG.API_HOST + '/movies/genre?genreName=' + genre )
          .then(successFn, errorFn);
    }

    function deleteMovie(id){
      console.log("movie id is : " +id);
      return $http.delete(CONFIG.API_HOST + '/movies/' + id )
          .then(successFn, errorFn);

    }
    
    function addMovie(movie) {
      console.log("movie is : " );
      console.dir(movie)
      return $http.post(CONFIG.API_HOST + '/movies/', movie )
          .then(successFn, errorFn);
    }

    function editMovie(movie){
      console.log("updated movie is : " );
      console.dir(movie)
      return $http.put(CONFIG.API_HOST + '/movies/' +movie.id, movie )
          .then(successFn, errorFn);
    }

    function successFn(response) {
      return response.data;
    }

    function errorFn(response) {
      return $q.reject('ERROR: ' + response.statusText);
    }
  }
})();