(function() {
    'use strict';

    angular.module('movieflix')
        .controller('UserProfileController', UserProfileController);

    UserProfileController.$inject = ['$http'];
    function UserProfileController($http) {
        var userVm = this;

        init();

        function init() {
            console.log('UserProfileController');
            userVm.profile = JSON.parse(localStorage.getItem('profile'));
            // console.dir(userVm.profile);
        }
    }
})();