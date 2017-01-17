/**
 * Created by Negin on 10-1-2017.
 */

angular.module('workshop').controller('EditEmployeeController', function($scope, employeeService) {
    var construct = function () {
        employeeService.getEmployee(function(employees) {
            $scope.employees = employees;
        });
    };

    $scope.update = function () {
        var confirmation = confirm("Weet u zeker dat u de gegevens wilt aanpassen?");
        if (confirmation == true) {
            employeeService.update($scope.employees, onUpdated);
        } else {
            alert('Gegevens niet aangepast!');
        }

    };
    var onUpdated = function () {
        alert('Medewerker is aangepast! ');
        $scope.gotoEmployees();
    };

    construct();
});