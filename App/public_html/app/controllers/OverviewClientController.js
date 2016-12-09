/**
 * Created by Negin Nafissi on 9-12-2016.
 */

angular.module('workshop').controller('OverviewClientController', function($scope, clientService)
{
    var construct = function()
    {
        clientService.getAll(function(users)
        {
            $scope.users = users;
        });
    };

    construct();
});