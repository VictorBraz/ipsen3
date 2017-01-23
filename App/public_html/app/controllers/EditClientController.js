/**
 * @author Victor
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
        var confirmation = confirm("Weet u zeker dat u de gegevens wilt aanpassen?");
        if (confirmation == true) {
            clientService.update($scope.client, onUpdated);
        }
        else{
            alert('Gegevens niet aangepast!');
        }
    };

    var onUpdated = function()
    {
        alert('Cliënt aangepast! ');
        $scope.gotoClients();
    };


    construct();
});
