
angular.module('workshop').controller('OverviewController', function($scope, userService)
{
    var construct = function()
    {
        userService.getAll(function(users)
        {
            $scope.users = users;
        });
    };

    $scope.selectedUser = {
        accountName: []
    };

    $scope.selectUser = function () {
        userService.setSelected($scope.selectedUser.accountName[0]);
    };

    construct();
});
