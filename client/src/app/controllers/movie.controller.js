(function() {
  'use strict';

  angular.module('movieflix')
    .controller('MoviesController', MoviesController);

  MoviesController.$inject = ['movieService', '$route'];

  function MoviesController(movieService, $route) {
    var moviesVm = this;

    moviesVm.changeSort = changeSort;
    moviesVm.deleteMovie = deleteMovie;

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
            $route.reload();
            //$location.path('/home');
          }, function(error) {
            console.log(error);
          });
    }

    function changeSort(prop) {
      moviesVm.sorter.by = prop;
      moviesVm.sorter.reverse = !moviesVm.sorter.reverse;
    }
  }

})();