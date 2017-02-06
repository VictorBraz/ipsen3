/**
 * Created by Negin Nafissi on 10-1-2017.
 */

angular.module('IN2').controller('EditEmployeeController', function ($scope, alertify, employeeService) {

    var construct = function () {
        employeeService.getEmployee(function (employees) {
            $scope.employees = employees;
        });
    };

    $scope.update = function () {
        alertify
            .okBtn("OK")
            .cancelBtn("Annuleren")
            .confirm("Weet u zeker dat u de gegevens wilt aanpassen?", function (ev) {
                employeeService.update($scope.employees, onUpdated);
                ev.preventDefault();
                alertify.success("Medewerker aangepast");
            }, function (ev) {
                ev.preventDefault();
                alertify.error("Medewerker niet aangepast");
            });
    };
    var onUpdated = function () {
        $scope.gotoEmployees();
    };

    construct();
});