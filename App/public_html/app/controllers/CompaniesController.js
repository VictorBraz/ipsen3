
angular.module('workshop').controller('CompaniesController', function($scope, companyService)
{
    var construct = function()
    {
        companyService.getAll(function(companies)
        {
            $scope.companies = companies;

        });
    };


    $scope.getNumber = function(id) {
        $scope.selectedCompanyID = id
    };

    $scope.account = {
        id: []
    };
    $scope.checkAll = function() {
        $scope.account.roles = $scope.roles.map(function(item) { return item.id; });
    };
    $scope.uncheckAll = function() {
        $scope.account.roles = [];
    };
    $scope.checkFirst = function() {
        $scope.account.roles.splice(0, $scope.account.roles.length);
        $scope.account.roles.push(1);
    };

    construct();
});


