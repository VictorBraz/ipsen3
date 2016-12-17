
angular.module('workshop').controller('HomeController', function($scope, authenticationService, accountService)
{
    $scope.login = function()
    {
        authenticationService.createAuthentication($scope.name, $scope.password);
        
        accountService.authenticate(function(authenticator)
        {
            authenticationService.setAuthenticator(authenticator);
            authenticationService.storeAuthentication($scope.remember);
        });
        
    };
});
