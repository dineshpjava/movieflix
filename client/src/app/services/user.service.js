(function() {
    'use strict';

    angular.module('movieflix')
        .service('userService', userService);

    userService.$inject = ['$http', '$q', 'CONFIG'];

    function userService($http, $q, CONFIG) {

        var self = this;

        self.getUserAuth = getUserAuth;
        self.createUser = createUser;

        function getUserAuth() {
            return;
        }

        function createUser(){

        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }
})();