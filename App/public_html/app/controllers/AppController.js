
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
    
    $scope.logout = function()
    {
        authenticationService.deleteAuthentication();
        $scope.gotoHome();
    };
});
