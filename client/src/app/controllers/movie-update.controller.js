(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('UpdateMovieController', UpdateMovieController);

    UpdateMovieController.$inject = ['movieService', '$location', '$routeParams'];

    function UpdateMovieController(movieService, $location, $routeParams) {
        var updateMovieVm = this;

        updateMovieVm.editMovie = editMovie;

        init();

        function init() {
            console.log('in UpdateMovieController');
            updateMovieVm.id = $routeParams.id;

            movieService
                .getMovieById(updateMovieVm.id)
                .then(function (movie){
                    updateMovieVm.updateMovie = movie;
                }, function (error) {
                    console.log(error);
                });
        }

        function editMovie() {
            console.dir(updateMovieVm.updateMovie);

            movieService
                .editMovie(updateMovieVm.updateMovie)
                .then(function(data) {
                    $location.path('/movies');
                }, function(error) {
                    console.log(error);
                })
        }
    }
})();