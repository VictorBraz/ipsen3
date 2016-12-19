
angular.module('workshop').controller('HomeController', function($scope, authenticationService, userService)
{
    $scope.login = function()
    {
        authenticationService.createAuthentication($scope.emailAddress, $scope.password);

        userService.authenticate(function(authenticator)
        {
            authenticationService.setAuthenticator(authenticator);
            authenticationService.storeAuthentication($scope.remember);
        });
        
    };
});
