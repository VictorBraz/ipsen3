/**
 * Created by Victor on 21-12-2016.
 */
angular.module('workshop').controller('EditClientController', function($scope, clientService)
{
    var construct = function()
    {

        clientService.getClient(function(client)
        {
            $scope.client = client;

        });

    };

    $scope.update = function () {
        clientService.update($scope.client, onUpdated);
    };

    var onUpdated = function()
    {
        alert('Cliënt aangepast! ');
        $scope.gotoClients();
    };


    construct();
});
