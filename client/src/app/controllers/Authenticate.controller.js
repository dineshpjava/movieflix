(function() {
    'use strict';

    angular.module('movieflix')
        .controller('AuthController', AuthController);

    AuthController.$inject = ['auth', '$location'];

    function AuthController(auth, $location) {
        var headVm = this;

        headVm.login = login;
        headVm.logout = logout;
        headVm.auth = auth;
        headVm.init = init;

        init();

        function init() {
            headVm.profile = JSON.parse(localStorage.getItem('profile'));
            console.log(headVm.profile);
        }

        function login() {
            auth
                .signin({}, function(profile,token) {
                    localStorage.setItem('profile',JSON.stringify(profile));
                    localStorage.setItem('token',token);
                    headVm.profile = JSON.parse(localStorage.getItem('profile'));
                    // store.set('profile',JSON.stringify(profile));
                    // store.set('token',token);
                    $location.path('/movies');
                    console.dir(headVm.profile);
                }, function(error){
                    console.log(error);
                });
        }

        function logout() {
            localStorage.removeItem('profile');
            localStorage.removeItem('token');
            auth.signout();
            $location.path('/home');
        }
    }
})();