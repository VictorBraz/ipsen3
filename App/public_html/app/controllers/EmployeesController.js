/**
 * Created by Negin on 13-12-2016.
 */

angular.module('workshop').controller('EmployeesController', function($scope, employeeService)
{
    var construct = function()
    {
        employeeService.getAll(function (employees)
        {
            $scope.employees = employees;
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
            $scope.address,
            $scope.city,
            $scope.postcode,
            employeeCreated
        );
    };

    $scope.selectedEmployee = {
        id: []
    };

    $scope.selectEmployee = function () {
        employeeService.setSelected($scope.selectedEmployee.id[0]);
    };

    var employeeCreated = function() {
            alert('Er is een nieuwe medewerker toegevoegd');
            $scope.gotoEmployees();
    };

    construct();
});