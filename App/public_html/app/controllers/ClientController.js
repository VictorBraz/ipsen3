/**
 * @author Victor
 */

angular.module('workshop').controller('ClientController', function ($scope, $route, clientService) {

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
        var confirmation = confirm("Weet u zeker dat u de client wilt verwijderen?");
        if (confirmation == true) {
            clientService.delete($scope.selectedClient.id[0], reload);
        }
        else {
            alert("Gegevens niet verwijderd");
        }
    };

    $scope.restore = function () {
        var confirmation = confirm("Weet u zeker dat u de client wilt herstellen?");
        if (confirmation == true) {
            clientService.delete($scope.selectedClient.id[0], reload);
        } else{
            ("Gegevens niet hersteld");
        }
    };


    var reload = function()
    {
        $route.reload();
    };

    construct();






});
