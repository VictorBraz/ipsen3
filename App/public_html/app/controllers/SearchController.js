/**
 * Created by Braz on 09/01/2017.
 */
angular.module('workshop').controller('SearchController', function($scope, searchService) {

    $scope.searchTag;
    $scope.setTag = function (){
        searchService.setTag($scope.searchTag);
    };

    $scope.searchAll = function () {
        $scope.setTag();
        $scope.searchClients();
        $scope.searchCompanies();
        $scope.searchEmployees();
    };

    $scope.searchClients = function(){
        searchService.getFilteredClients(function (clients) {
            $scope.filteredClients = clients;
        });
    };

    $scope.searchCompanies = function(){
        searchService.getFilteredCompanies(function (companies) {
            $scope.filteredCompanies = companies;
        });
    };

    $scope.searchEmployees = function(){
        searchService.getFilteredEmployees(function (employees){
            $scope.filteredEmployees = employees;
        });
    };

});
