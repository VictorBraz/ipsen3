/**
 * Created by Mitch van Wijngaarden
 * @author Mitch, Roel
 *
 */
angular.module('workshop').controller('CompaniesOverviewController', function($scope, companyService)
{
    $scope.selectedcompanies = {
        id: []
    };

    var construct = function()
    {
        companyService.getAll(function(companies)
        {
            $scope.companies = companies;

        });

        companyService.getAll(function(companies)
        {
            $scope.companytest = companies[$scope.selectedcompanies[0]];

        });

        $scope.deleteCompany = function() {
            companyService.getCompanyID();
            companyService.deleteCompany();
        };

        $scope.checkSelected = function() {
            if ($scope.selectedcompanies.id.length >= 1) {
                $scope.checkSelectedVar = true;
            }
            else {
                $scope.checkSelectedVar = false;
            }
        };
    };




    construct();



});
