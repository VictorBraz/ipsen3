
angular.module('IN2').controller('RegistrationController', function($scope, alertify, userService)
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
        alertify.success("Er is een nieuwe medewerker toegevoegd");
        $scope.gotoOverview();
    };
});
