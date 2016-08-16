(function() {
  'use strict';

  angular.module('movieflix')
    .controller('MovieDetailController', MovieDetailController);

  MovieDetailController.$inject = ['movieService', 'reviewService', '$routeParams', '$location'];

  function MovieDetailController(movieService, reviewService, $routeParams, $location) {
    var movieDetailVm = this;

    movieDetailVm.addReview = addReview;
    movieDetailVm.deleteReview = deleteReview;
    
    init();

    function init() {
      console.log('MovieDetailController');

      movieDetailVm.profile = JSON.parse(localStorage.getItem('profile'));

      movieService
        .getMovieById($routeParams.id)
        .then(function (movie){
          movieDetailVm.movie = movie;
        }, function (error) {
          console.log(error);
        });

      reviewService
          .getReviews($routeParams.id)
          .then(function (reviews){
            movieDetailVm.reviews = reviews;
          }, function (error) {
            console.log(error);
          });
    }
    
    function addReview() {
        console.log('adding review in controller' + $routeParams.id);
        movieDetailVm.newReview.movieId = $routeParams.id;
      reviewService
          .addReview(movieDetailVm.newReview)
          .then(function(data) {
              $location.path('/movies');
          }, function(error) {
            console.log(error);
          })
    }

    function deleteReview(id) {
        console.log('controller : delete')
        reviewService
            .deleteReview(id)
            .then(function(data) {
                $location.path('/movies');
            }, function(error) {
                console.log(error);
            })
    }
  }
})();