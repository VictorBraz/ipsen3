
angular.module('workshop').controller('CompaniesController', function($scope, companyService)
{
    var construct = function()
    {
        companyService.getAll(function(companies)
        {
            $scope.companies = companies;
        });
    };

    construct();
});
