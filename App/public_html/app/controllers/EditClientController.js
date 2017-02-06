/**
 * Created by Victor Machado Braz
 */
angular.module('IN2').controller('EditClientController', function($scope, alertify, clientService)
{
    var construct = function()
    {
        clientService.getClient(function(client)
        {
            $scope.client = client;
            clientService.getClientFiles(function (documents) {
                $scope.documents = documents;
            });
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

    $scope.downloadFile = function(document) {

        clientService.getFile(document).$promise.then(function(result) {
            var url = "http://localhost:8080/fileToDownload/"+document.documentname;
            var a = document.createElement('a');
            a.href = url;
            a.download = result.filename;
            a.target = '_blank';
            a.click();
        })
            .catch(resourceError)
            .catch(function(error) {
                console.log(error.data); // in JSON
            });
    }

    construct();
});
