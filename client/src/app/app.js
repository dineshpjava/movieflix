(function() {
  'use strict';

  angular
    .module('movieflix', ['ng','ngMessages','ngRoute', 'auth0', 'angular-storage', 'angular-jwt', 'ngMaterial'])
    .config(moduleConfig)
    .run(moduleRun);


    moduleConfig.$inject = ['$routeProvider', '$provide', 'authProvider', '$httpProvider', 'jwtInterceptorProvider'];
    function moduleConfig($routeProvider, $provide, authProvider, $httpProvider, jwtInterceptorProvider) {

      authProvider.init({
          domain: 'learn-angular.auth0.com',
          clientID: 'OkoaECUGBUA0YdLNw7EeCfP8FS0w7LdW'
      });

      jwtInterceptorProvider.tokenGetter = function () {
          return localStorage.getItem('token');
      }

      //to deal with expired tokens
      /*
      moduleConfig.$inject = ['$q', 'auth', '$location'];
      function redirect($q, auth, $location){
          return{
              responseError: function(rejection){

                  if(rejection.status === 401){
                      auth.signout();
                      localStorage.removeItem('profile');
                      localStorage.removeItem('token');
                      $location.path('/home');

                  }
                  return $q.reject(rejection);
              }
          }
      }
      $provide.factory('redirect', redirect);
      $httpProvider.interceptors.push('redirect');
       */

      $httpProvider.interceptors.push('jwtInterceptor');

      $routeProvider
      .when('/movies', {
        templateUrl: 'app/views/movie.tmpl.html',
        controller: 'MoviesController',
        controllerAs: 'moviesVm'
      })
      .when('/movies/:id', {
        templateUrl: 'app/views/movie-detail.tmpl.html',
        controller: 'MovieDetailController',
        controllerAs: 'movieVm'
      })
      .when('/movies/type/:type', {
        templateUrl: 'app/views/movie-type.tmpl.html',
        controller: 'MovieTypeController',
        controllerAs: 'moviesVm'
       })
      .when('/movies/genre/:genre', {
        templateUrl: 'app/views/movie-genre.tmpl.html',
        controller: 'MovieGenreController',
        controllerAs: 'moviesVm'
      })
      .when('/createmovie', {
        templateUrl: 'app/views/movie-create.tmpl.html',
        controller: 'AddMovieController',
        controllerAs: 'addMovieVm'
      })
      .when('/updatemovie/:id', {
        templateUrl: 'app/views/movie-update.tmpl.html',
        controller: 'UpdateMovieController',
        controllerAs: 'updateMovieVm'
      })
      .when('/login', {
        templateUrl: 'app/views/user-home.tmpl.html',
        controller: 'UserLoginController',
        controllerAs: 'userVm'
      })
        .when('/signup', {
            templateUrl: 'app/views/user-signup.tmpl.html',
            controller: 'UserSignController',
            controllerAs: 'userVm'
        })
          .when('/profile', {
              templateUrl: 'app/views/user-profile.tmpl.html',
              controller: 'UserProfileController',
              controllerAs: 'userVm'
          })
        .when('/home', {
            templateUrl: 'app/views/home.tmpl.html'
        })
        .otherwise({
        redirectTo: '/home'
      });
  }

  moduleRun.$inject = ['$rootScope', 'auth', 'jwtHelper', '$location'];
  function moduleRun($rootScope, auth, jwtHelper, $location){

      $rootScope.$on('$locationChangeStart', function(){

          var token = localStorage.getItem('token');
          if(token){//if token exists
              if(!jwtHelper.isTokenExpired(token)){//check for token expiry
                  if(!auth.isAuthenticated){//check if authenticated
                      auth.authenticate(localStorage.getItem('profile',token));
                  }
              }
          }else{
              $location.path('/home');
          }
      })
  }
})();