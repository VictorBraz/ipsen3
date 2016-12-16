/**
 * Created by Mitch on 12/12/2016.
 */
angular.module('workshop').controller('CompanyController', function($scope, companyService)
{
    var construct = function()
    {
        companyService.getAll(function (companytest) {
            $scope.selectedcompany = 0;
            $scope.companyding = companytest;
            $scope.testID = companytest[0];
        });

    };



    construct();
});
