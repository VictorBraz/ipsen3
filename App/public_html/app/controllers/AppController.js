
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

    $scope.logout = function()
    {
        authenticationService.deleteAuthentication();
        $scope.gotoHome();
    };
});
