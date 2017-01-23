/**
 * Created by Mitch on 12/12/2016.
 * @author Bernd Oostrum
 *
 */
angular.module('workshop').controller('CompanyController', function ($scope, $route, companyService) {

    var construct = function() {
        companyService.getAll(function(companies){
            $scope.companies = companies;
            $scope.activetab = true;
        });
    };

    $scope.searchKeyword = '';


    $scope.selectedCompany = {
        id: []
    };





    $scope.ontestClick = function() {
        companyService.setSelected($scope.selectedCompanyTest.id[0]);
        companyService.getSelected();
    };

    $scope.create = function () {
        companyService.create(
            $scope.companyname,
            $scope.contactperson,
            $scope.phoneNumber,
            $scope.email,
            $scope.tag,
            $scope.address,
            $scope.city,
            $scope.postcode,
            $scope.noteText,
            $scope.active,
            companyCreated
        );
    };

    //$scope.selectCompany = function() {
     //   companyService.setSelected($scope.selectedCompany.id[0]);
    //};

    $scope.viewSettedComp = function (id) {
        console.log("Current ID get: " +  id);
        companyService.setSelected(id);
        $scope.gotoViewCompany();
    };

    $scope.isSelected = function () {
        if($scope.selectedCompany.id.length > 0){
            return true;
        }else{
            return false;
        }
    };

    $scope.selectCompany = function () {
        companyService.setSelected($scope.selectedCompany.id[0]);
        console.log($scope.selectedCompany.id[0]);
    };

    var companyCreated = function() {
        alert("Er is een nieuw bedrijf toegevoegd");
        $scope.gotoCompanies();
    };


    var reload = function()
    {
        $route.reload();
    };

    $scope.delete = function () {
        var confirmation = confirm("Weet u zeker dat u dit bedrijf wilt verwijderen?");
        if (confirmation == true) {
            companyService.delete($scope.selectedCompany.id[0], reload);
        }
        else {
            alert("Gegevens niet verwijderd");
        }
    };

    $scope.restore = function () {
        var confirmation = confirm("Weet u zeker dat u het bedrijf wilt herstellen?");
        if (confirmation == true) {
            companyService.delete($scope.selectedCompany.id[0], reload);
        } else{
            alert("Gegevens niet hersteld");
        }
    };


    construct();


});

