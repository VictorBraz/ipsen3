/**
 * Created by Negin on 13-12-2016.
 */

angular.module('workshop').controller('EmployeesController', function($scope, $route, employeeService)
{
    var construct = function()
    {
        employeeService.getAll(function (employees)
        {
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
        if($scope.selectedEmployee.id.length > 0){
            return true;
        }else{
            return false;
        }
    };

    $scope.selectEmployee = function () {
        employeeService.setSelected($scope.selectedEmployee.id[0]);
    };

    var employeeCreated = function() {
            alert('Er is een nieuwe medewerker toegevoegd');
            $scope.gotoEmployees();
    };

    $scope.delete = function () {
        var confirmation = confirm("Weet u zeker dat u de medewerker wilt verwijderen?");
        if (confirmation == true) {
            employeeService.delete($scope.selectedEmployee.id[0], reload);
            alert("De medewerker is op non-active gezet!");
        }
        else {
            alert("Gegevens niet verwijderd");
        }
    };

    $scope.restore = function () {
        var confirmation = confirm("Weet u zeker dat u de medewerker wilt herstellen?");
        if (confirmation == true) {
            employeeService.delete($scope.selectedEmployee.id[0], reload);
            alert("De medewerker is op active gezet!");
        } else{
            ("Gegevens niet hersteld");
        }
    }


    var reload = function()
    {
        $route.reload();
    };

    construct();
});