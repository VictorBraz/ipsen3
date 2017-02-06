/**
 * Created by Victor Machado Braz
 */

angular.module('workshop').controller('ClientController', function ($scope, $route, alertify, clientService) {


    var construct = function () {
        clientService.getAll(function (clients) {
            $scope.clients = clients;
            $scope.activetab = true;
        });
        clientService.getClientFiles(function (documents) {
            $scope.documents = documents;

        });


    };

    $scope.searchKeyword = '';

    $scope.register = function () {
        clientService.create(
            $scope.firstname,
            $scope.lastname,
            $scope.birthdate,
            $scope.study,
            $scope.emailAddress,
            $scope.phonenumber,
            $scope.tag,
            $scope.address,
            $scope.city,
            $scope.postcode,
            $scope.noteText,
            $scope.active,
            clientCreated
        );
    };

    $scope.viewSettedClient = function (id) {
        clientService.setSelected(id);

        $scope.gotoViewClient();
    };

    $scope.selectedClient = {
        id: []
    };

    $scope.isSelected = function () {
        if ($scope.selectedClient.id.length > 0) {
            return true;
        } else {
            return false;
        }
    };

    $scope.selectClient = function () {
        clientService.setSelected($scope.selectedClient.id[0]);

    };

    var clientCreated = function () {
        alertify.success("Er is een nieuwe cliënt toegevoegd");
        $scope.gotoClients();
    };


    $scope.delete = function () {
        alertify
            .okBtn("OK")
            .cancelBtn("Annuleren")
            .confirm("Weet u zeker dat u de geselecteerde cliënt wilt verwijderen?", function (ev) {
                clientService.delete($scope.selectedClient.id[0], reload);
                ev.preventDefault();
                alertify.success("Cliënt succesvol verwijderd");
        }, function (ev) {
                ev.preventDefault();
                alertify.error("Cliënt niet verwijderd");
        });
    };

    $scope.restore = function () {
        alertify
            .okBtn("OK")
            .cancelBtn("Annuleren")
            .confirm("Weet u zeker dat u de geselecteerde cliënt wilt herstellen?", function (ev) {
            clientService.delete($scope.selectedClient.id[0], reload);
                ev.preventDefault();
                alertify.success("Client succesvol hersteld");
        }, function (ev) {
                ev.preventDefault();
                alertify.error("Client niet hersteld");
        });
    };

    $scope.reloadFillSettings = function() {
        $.material.options.autofill = true;
    }

    var reload = function() {
        $route.reload();
    };

    construct();
});
