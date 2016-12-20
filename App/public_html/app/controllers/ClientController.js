/**
 * Created by Victor on 12-12-2016.
 */
angular.module('workshop').controller('ClientController', function($scope, addressService, clientService)
{
    var construct = function()
    {
        clientService.getAll(function (clients)
        {
            $scope.clients = clients;
        });
    };

    $scope.checkAddress = function () {
        addressService.get($scope.postcode, $scope.streetnumber, function (address) {
            $scope.street = address.street;
            $scope.city = address.city;
        });
    };

    $scope.register = function () {
        clientService.create(
            $scope.firstname,
            $scope.lastname,
            $scope.birthdate,
            $scope.study,
            $scope.emailAddress,
            $scope.phonenumber,
            $scope.tag,
            /*$scope.street,
            $scope.city,
            $scope.postcode,
            $scope.streetnumber,*/
            clientCreated
        );

    };

    var clientCreated = function()
    {
        alert('Er is een nieuw cliënt toegevoegd');
        $scope.gotoClients();
    };

    construct();
});
