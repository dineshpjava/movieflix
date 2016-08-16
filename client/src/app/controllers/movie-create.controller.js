(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('AddMovieController', AddMovieController);

    AddMovieController.$inject = ['movieService', '$location'];

    function AddMovieController(movieService, $location) {
        var addMovieVm = this;

        addMovieVm.addMovie = addMovie;

        init();

        function init() {
            console.log('in AddMovieController');
        }

        function addMovie() {
            console.dir(addMovieVm.newMovie);
            var str = addMovieVm.genre;
            addMovieVm.newMovie.genre = str.split(", ");
            console.dir(addMovieVm.newMovie.genre);

            movieService
                .addMovie(addMovieVm.newMovie)
                .then(function(data) {
                    $location.path('/home');
                }, function(error) {
                    console.log(error);
                })
        }
    }
})();