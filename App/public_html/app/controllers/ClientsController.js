/**
 * Created by Victor on 12-12-2016.
 */
angular.module('workshop').controller('ClientsController', function($scope, clientService)
{
    var construct = function()
    {
        clientService.getAll(function (clients)
        {
            $scope.clients = clients;
        });
    };

    construct();
});
