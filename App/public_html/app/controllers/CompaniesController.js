
angular.module('workshop').controller('CompaniesController', function($scope, companyService)
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

        $scope.ontestClick = function() {
            companyService.setCompanyID($scope.selectedcompanies.id[0]);
            companyService.getCompanyID();
        }

    };

    construct();



});


