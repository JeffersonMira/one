angular.module('public', [])
    .controller('greeting', function($scope, $http) {
        $http.get('http://localhost:8091/public/greeting').
        then(function(response) {
            $scope.greeting = response.data;
            $scope.testing="data";
        });
    });



var working = 'testing this working';