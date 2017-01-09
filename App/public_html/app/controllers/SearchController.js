/**
 * Created by Braz on 09/01/2017.
 */
angular.module('workshop').controller('SearchController', function($scope, searchService) {

    $scope.searchTag = {
        tags: []
    };
    $scope.setTag = function (){
        searchService.setTag($scope.searchTag.tags[0]);
    };

    $scope.searchAll = function () {
        searchService.getFiltered(function (lists) {
            $scope.lists = lists;
            console.log(lists.getAccessId(1));
        });
    };

});
