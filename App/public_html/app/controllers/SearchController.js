/**
 * @author Victor
 */
angular.module('workshop').controller('SearchController', function($scope, searchService, clientService, employeeService, companyService) {

    $scope.searchTag = '';

    $scope.setClient = function (id) {
        clientService.setSelected(id);
        $scope.gotoEditClient()
    };

    $scope.setEmployee = function (id) {
        employeeService.setSelected(id);
        $scope.gotoViewEmployee();
    };

    $scope.setCompany = function (id) {
        companyService.setSelected(id);
        $scope.gotoEditCompany();
    };

    $scope.setTag = function (){
        if ($scope.searchTag != ''){
            searchService.setTag($scope.searchTag);
        }
    };

    $scope.searchAll = function () {
        $scope.setTag();
        $scope.searchClients();
        $scope.searchCompanies();
        $scope.searchEmployees();
    };

    $scope.searchClients = function(){
        if ($scope.filteredClients == null) {
            searchService.getFilteredClients(function (clients) {
                $scope.filteredClients = clients;
            });
        };
    };

    $scope.searchCompanies = function(){
        if($scope.filteredCompanies == null) {
            searchService.getFilteredCompanies(function (companies) {
                $scope.filteredCompanies = companies;
            });
        };
    };

    $scope.searchEmployees = function(){
        if($scope.filteredEmployees == null) {
            searchService.getFilteredEmployees(function (employees) {
                $scope.filteredEmployees = employees;
            });
        };
    };


});
