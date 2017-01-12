/**
 * Created by Victor on 12-12-2016.
 */
angular.module('workshop').controller('ClientController', function($scope, clientService)
{
    var construct = function()
    {
        clientService.getAll(function (clients)
        {
            $scope.clients = clients;
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
            clientCreated
        );

    };

    $scope.selectedClient = {
        id: []
    };

    $scope.isSelected = function () {
        if($scope.selectedClient.id.length > 0){
            return true;
        }else{
            return false;
        }
    };

    $scope.selectClient = function () {
        clientService.setSelected($scope.selectedClient.id[0]);
    };

    var clientCreated = function()
    {
        alert('Er is een nieuw cliënt toegevoegd');
        $scope.gotoClients();
    };

    construct();
});
