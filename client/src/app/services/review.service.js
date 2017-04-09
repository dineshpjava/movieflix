(function() {
    'use strict';

    angular.module('movieflix')
        .service('reviewService', reviewService);

    reviewService.$inject = ['$http', '$q', 'CONFIG'];

    function reviewService($http, $q, CONFIG) {

        var self = this;

        self.addReview = addReview;
        self.getReviews = getReviews;
        self.deleteReview = deleteReview;

        function getReviews(id) {
            console.log("in review service")
            return $http.get(CONFIG.API_HOST + '/reviews/' + id)
                .then(successFn, errorFn);
        }

        function addReview(review) {
            console.dir(review);
            return $http.post(CONFIG.API_HOST + '/reviews/', review)
                .then(successFn, errorFn);
        }

        function deleteReview(id) {
            return $http.delete(CONFIG.API_HOST + '/reviews/'+ id)
                .then(successFn, errorFn);

        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }
})();