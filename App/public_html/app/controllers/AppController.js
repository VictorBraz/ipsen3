
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
    
    $scope.gotoNotes = function () {
        $location.path('/notes');
    };

    $scope.gotoAddEmployee = function ()
    {
        $location.path('/addEmployee');
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

    $scope.logout = function()
    {
        authenticationService.deleteAuthentication();
        $scope.gotoHome();
    };

    $scope.gotoSearch = function(){
        $location.path('/search');
    };
});
