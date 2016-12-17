
angular.module('workshop').controller('RegistrationController', function($scope, addressService, accountService)
{
    $scope.checkAddress = function()
    {
        addressService.get($scope.postcode, $scope.streetnumber, function(address)
        {
            $scope.street = address.street;
            $scope.city = address.city;
        });
    };
    
    $scope.register = function()
    {
        accountService.create(
            $scope.name,
            $scope.password,
            accoountCreated
        );
    };
    
    var accountCreated = function()
    {
        alert('Uw account is aangemaakt, u kunt nu inloggen');
        $scope.gotoHome();
    };
});
