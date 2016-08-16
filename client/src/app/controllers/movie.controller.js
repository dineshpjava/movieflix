(function() {
  'use strict';

  angular.module('movieflix')
    .controller('MoviesController', MoviesController);

  MoviesController.$inject = ['movieService', '$location'];

  function MoviesController(movieService, $location) {
    var moviesVm = this;

    moviesVm.changeSort = changeSort;
    moviesVm.deleteMovie = deleteMovie;
    moviesVm.updateMovie = updateMovie;

    init();

    function init() {
      console.log('MoviesController');
      moviesVm.profile = JSON.parse(localStorage.getItem('profile'));

      moviesVm.sorter = {
        by: 'title',
        reverse: false
      };

      movieService
        .getMovies()
        .then(function(movies) {
          moviesVm.movies = movies;
        }, function(error) {
          console.log(error);
        });
    }

    function deleteMovie(id) {
      console.log("delete in controller")
      movieService
          .deleteMovie(id)
          .then(function(movies) {
            $location.path('/home');
          }, function(error) {
            console.log(error);
          });
    }

    function updateMovie() {

    }

    function changeSort(prop) {
      moviesVm.sorter.by = prop;
      moviesVm.sorter.reverse = !moviesVm.sorter.reverse;
    }
  }

})();