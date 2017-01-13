
angular.module('workshop').controller('AppController', function($scope, $location, authenticationService)
{

    $scope.isLocation = function(location)
    {
        return $location.path() === location;
    };
    
    $scope.gotoHome = function()
    {
        $location.path('/');
    };
    
    $scope.gotoRegistration = function()
    {
        $location.path('/register');
    };
    
    $scope.gotoOverview = function()
    {
        $location.path('/overview');
    };

    $scope.gotoCompanies = function()
    {
        $location.path('/companies');
    };

    $scope.gotoClients = function ()
    {
        $location.path('/clients');
    };

    $scope.gotoEmployees = function ()
    {
        $location.path('/employees');
    };

    $scope.gotoAddEmployee = function ()
    {
        $location.path('/addEmployee');
    };

    $scope.gotoEditEmployee = function ()
    {
        $location.path('/editEmployee');
    };

    $scope.gotoAddClient = function () {
        $location.path('/addclient');

    };

    $scope.gotoEditClient = function () {
        $location.path('/editClient');
    };

    $scope.gotoCalender = function () {
        $location.path('/calender');
    }

    $scope.gotoAddCompany = function () {
        $location.path('/addcompany');
    }

    $scope.gotoEditCompany = function () {
        $location.path('/editcompany');
    }

    $scope.gotoDeleteCompany = function () {
        $location.path('/deletecompany');
    }

    $scope.logout = function()
    {
        authenticationService.deleteAuthentication();
        $scope.gotoHome();
    };

    $scope.gotoSearch = function(){
        $location.path('/search');
    };
});
