/**
 * Created by Negin Nafissi on 13-12-2016.
 */

angular.module('IN2').controller('EmployeesController', function ($scope, $route, alertify, employeeService) {

    var construct = function () {
        employeeService.getAll(function (employees) {
            $scope.employees = employees;
            $scope.activetab = true;
        });
    };

    $scope.searchKeyword = '';

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
            $scope.noteText,
            employeeCreated
        );
    };

    $scope.viewSettedEmp = function (id) {
        employeeService.setSelected(id);
        $scope.gotoViewEmployee();
    };

    $scope.selectedEmployee = {
        id: []
    };

    $scope.isSelected = function () {
        if ($scope.selectedEmployee.id.length > 0) {
            return true;
        } else {
            return false;
        }
    };

    $scope.selectEmployee = function () {
        employeeService.setSelected($scope.selectedEmployee.id[0]);
    };

    var employeeCreated = function () {
        alertify.success("Er is een nieuwe medewerker toegevoegd");
        $scope.gotoEmployees();
    };

    $scope.delete = function () {
        alertify
            .okBtn("OK")
            .cancelBtn("Annuleren")
            .confirm("Weet u zeker dat u de geselecteerde medewerker wilt verwijderen?", function (ev) {
                employeeService.delete($scope.selectedEmployee.id[0], reload);
                ev.preventDefault();
                alertify.success("Medewerker succesvol verwijderd");
            }, function (ev) {
                ev.preventDefault();
                alertify.error("Medewerker niet verwijderd");
            });
    };

    $scope.restore = function () {
        alertify
            .okBtn("OK")
            .cancelBtn("Annuleren")
            .confirm("Weet u zeker dat u de geselecteerde medewerker wilt herstellen?", function (ev) {
                employeeService.delete($scope.selectedEmployee.id[0], reload);
                ev.preventDefault();
                alertify.success("Medewerker succesvol hersteld");
            }, function (ev) {
                ev.preventDefault();
                alertify.error("Medewerker niet hersteld");
            });
    };

    $scope.reloadFillSettings = function () {
        $.material.options.autofill = true;
    };

    var reload = function () {
        $route.reload();
    };

    construct();
});