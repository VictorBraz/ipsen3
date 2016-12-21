/**
 * Created by Negin on 13-12-2016.
 */

angular.module('workshop').controller('EmployeesController', function($scope, addressService, employeeService)
{
    var construct = function()
    {
        employeeService.getAll(function (employees)
        {
            $scope.employees = employees;
        });
    };

    $scope.checkAddress = function () {
        addressService.get($scope.zipCode, $scope.streetNumber, function (address) {
            $scope.street = address.street;
            $scope.city = address.city;
        });
    };

    $scope.register = function () {
        employeeService.create(
            $scope.firstName,
            $scope.lastName,
            $scope.study,
            $scope.birthDate,
            $scope.email,
            $scope.phoneNumber,
            $scope.tag,
            /*$scope.street,
            $scope.city,*/
            /*$scope.zipCode,
            $scope.streetNumber,**/
            employeeCreated
        );
    };

    var employeeCreated = function() {
            alert('Er is een nieuwe medewerker toegevoegd');
            $scope.gotoEmployees();
    };

    construct();
});