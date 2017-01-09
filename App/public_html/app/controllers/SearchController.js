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
        searchService.getFiltered(function (lists) {
            $scope.lists = lists;
            $scope.filteredClients = $scope.lists.getIndex(1);
            $scope.filteredCompanies = $scope.lists.getIndex(2);
            $scope.filteredEmployees = $scope.lists.getItem(3);
        });
    };

});
