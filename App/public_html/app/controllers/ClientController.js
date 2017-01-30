/**
 * @author Victor, Bernd
 *
 */

angular.module('workshop').controller('ClientController', function ($scope, $route, alertify, clientService) {

// Make sure to include the ngAlertify.js file.

    var construct = function () {
        clientService.getAll(function (clients) {
            $scope.clients = clients;
            $scope.activetab = true;
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
        alert('Er is een nieuw cliënt toegevoegd');
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
        // if (confirmation == true) {
        //
        // }
        // else {
        //     alert("Gegevens niet verwijderd");
        // }
    };

    // alertify
    //     .okBtn("OK")
    //     .cancelBtn("Annuleren")
    //     .confirm("Weet u zeker dat u een cliënt wilt verwijderen?", function (ev) {
    //         ev.preventDefault();
    //         alertify.succes("Cliënt succesvol verwijderd");
    //     }, function(ev) {
    //
    //
    //
    //     })

    $scope.restore = function () {
        var confirmation = alertify.confirm("Message", function () {
            clientService.delete($scope.selectedClient.id[0], reload);
        }, function () {


        });
        // if (confirmation == true) {
        //
        // } else{
        //     ("Gegevens niet hersteld");
        // }
    };


    var reload = function()
    {
        $route.reload();
    };

    construct();






});
