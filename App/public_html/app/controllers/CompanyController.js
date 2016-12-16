/**
 * Created by Mitch on 12/12/2016.
 */
angular.module('workshop').controller('CompanyController', function($scope, companyService)
{
    var construct = function()
    {


        companyService.getCompanyID();

        companyService.getCompany(function(test)
        {
            $scope.company = test;

        });

    };



    construct();
});
