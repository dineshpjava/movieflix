(function() {
    'use strict';

    angular.module('movieflix')
        .controller('AuthController', AuthController);

    AuthController.$inject = ['auth', '$location'];

    function AuthController(auth, $location, $rootScope) {
        var headVm = this;

        headVm.login = login;
        headVm.logout = logout;
        headVm.auth = auth;

        function login() {
            auth
                .signin({}, function(profile,token) {
                    localStorage.setItem('profile',JSON.stringify(profile));
                    localStorage.setItem('token',token);
                    $location.path('/movies');
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