
angular.module('workshop').controller('OverviewController', function($scope, userService, $route)
{
    var construct = function()
    {
        userService.getAll(function(users)
        {
            $scope.users = users;
            $scope.activetab = true;
        });
    };

    $scope.selectedUser = {
        id: []
    };

    $scope.signIn = function () {
        $scope.gotoRegistration();
    };

    $scope.selectUser = function () {
        userService.setSelected($scope.selectedUser.id[0]);
    };

    $scope.isSelected = function () {
        if ($scope.selectedUser.id.length > 0) {
            return true;
        } else {
            return false;
        }
    };

    $scope.delete = function () {
        var confirmation = confirm("Weet u zeker dat u geselecteerde account wilt deactiveren?");
        if (confirmation == true) {
            userService.delete($scope.selectedUser.id[0], reload);
        }
        else {
            alert("Gegevens niet deactiveerd");
        }
    };

    $scope.restore = function () {
        var confirmation = confirm("Weet u zeker dat u geselecteerde account wilt herstellen?");
        if (confirmation == true) {
            userService.delete($scope.selectedUser.id[0], reload);
        } else{
            ("Gegevens niet hersteld");
        }
    };


    var reload = function()
    {
        $route.reload();
    };

    construct();
});
