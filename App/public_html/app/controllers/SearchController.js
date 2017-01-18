/**
 * Created by Braz on 09/01/2017.
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
    };

    $scope.searchClients = function(){
        searchService.getFilteredClients(function (clients) {
            $scope.filteredClients = clients;
        });
    };

    $scope.searchCompanies = function(){
        searchService.getFilteredCompanies(function (companies) {
            $scope.filteredCompanies = companies;
        });
    };

    $scope.searchEmployees = function(){
        searchService.getFilteredEmployees(function (employees){
            $scope.filteredEmployees = employees;
        });
    };

    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {
            window.document.location = $(this).data("href");
        });
    });

});
