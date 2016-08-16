(function () {
    'use strict';

    angular
        .module('movieflix')
        .directive('movieMenu', movieMenu);

    function movieMenu() {
        var directive = {
            templateUrl: 'app/views/movie-menu.tmpl.html',
            controller: 'AuthController',
            controllerAs: 'authVm'
        };

        return directive;
    }
})();

