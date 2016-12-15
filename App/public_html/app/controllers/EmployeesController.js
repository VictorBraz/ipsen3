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

    construct();
});