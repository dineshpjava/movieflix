(function() {
    'use strict';

    angular.module('movieflix')
        .controller('MovieTypeController', MoviesTypeController);

    MoviesTypeController.$inject = ['movieService', '$routeParams', '$route'];

    function MoviesTypeController(movieService, routeParams, $route) {
        var moviesVm = this;

        moviesVm.changeSort = changeSort;
        moviesVm.deleteMovie = deleteMovie;

        init();

        function init() {
            console.log('MoviesTypeController');

            moviesVm.profile = JSON.parse(localStorage.getItem('profile'));
            moviesVm.sorter = {
                by: 'title',
                reverse: false
            };

            movieService
                .getMoviesByType(routeParams.type)
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