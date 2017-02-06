
angular.module('IN2').controller('RegistrationController', function($scope, userService)
{

    $scope.register = function() {


        userService.create(
            $scope.emailAddress,
            $scope.password,
            $scope.privilege,
            $scope.userId = 1,
            userCreated
        );
    };

    var userCreated = function()
    {
        alert('Uw account is aangemaakt, u kunt nu inloggen');
        $scope.gotoOverview();
    };
});
