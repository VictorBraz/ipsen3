/**
 * Created by Victor Machado Braz
 */
angular.module('workshop').controller('EditClientController', function($scope, alertify, clientService)
{
    var construct = function()
    {
        clientService.getClient(function(client)
        {
            $scope.client = client;


        });

    };

    $scope.update = function () {
        alertify
            .okBtn("OK")
            .cancelBtn("Annuleren")
            .confirm("Weet u zeker dat u de gegevens wilt aanpassen?", function (ev) {
            clientService.update($scope.client, onUpdated);
                ev.preventDefault();
                alertify.success("Cliënt aangepast");
        }, function (ev) {
                ev.preventDefault();
                alertify.error("Cliënt niet aangepast");
        });
    };

    var onUpdated = function()
    {
        $scope.gotoClients();
    };


    construct();
});
