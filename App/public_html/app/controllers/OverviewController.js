
angular.module('IN2').controller('OverviewController', function($scope, userService, alertify, $route)
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
        alertify
            .okBtn("OK")
            .cancelBtn("Annuleren")
            .confirm("Weet u zeker dat u de geselecteerde account wilt verwijderen?", function (ev) {
                userService.delete($scope.selectedUser.id[0], reload);
                ev.preventDefault();
                alertify.success("Account succesvol verwijderd");
            }, function (ev) {
                ev.preventDefault();
                alertify.error("Account niet verwijderd");
            });
    };

    $scope.restore = function () {
        alertify
            .okBtn("OK")
            .cancelBtn("Annuleren")
            .confirm("Weet u zeker dat u de geselecteerde account wilt herstellen?", function (ev) {
                userService.delete($scope.selectedUser.id[0], reload);
                ev.preventDefault();
                alertify.success("Account succesvol hersteld");
            }, function (ev) {
                ev.preventDefault();
                alertify.error("Account niet hersteld");
            });
    };


    var reload = function()
    {
        $route.reload();
    };

    construct();
});
