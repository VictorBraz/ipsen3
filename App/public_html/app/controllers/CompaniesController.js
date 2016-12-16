
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

    $scope.user = {
        id: []
    };
    $scope.checkAll = function() {
        $scope.user.roles = $scope.roles.map(function(item) { return item.id; });
    };
    $scope.uncheckAll = function() {
        $scope.user.roles = [];
    };
    $scope.checkFirst = function() {
        $scope.user.roles.splice(0, $scope.user.roles.length);
        $scope.user.roles.push(1);
    };

    construct();
});


