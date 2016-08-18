(function() {
    'use strict';

    angular.module('movieflix')
        .controller('MovieGenreController', MovieGenreController);

    MovieGenreController.$inject = ['movieService', '$routeParams'];

    function MovieGenreController(movieService, routeParams) {
        var moviesVm = this;

        moviesVm.changeSort = changeSort;

        init();

        function init() {
            console.log('MovieGenreController');

            moviesVm.profile = JSON.parse(localStorage.getItem('profile'));
            moviesVm.sorter = {
                by: 'title',
                reverse: false
            };

            movieService
                .getMoviesByGenre(routeParams.genre)
                .then(function(movies) {
                    moviesVm.movies = movies;
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