/**
 * Created by Mitch on 12/12/2016.
 * @author Bernd, Mitch
 *
 */
angular.module('IN2').controller('CompanyController', function ($scope, $route, alertify, companyService) {

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

    $scope.viewSettedComp = function (id) {
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
    };

    var companyCreated = function() {
        alertify.success("Er is een nieuw bedrijf toegevoegd");
        $scope.gotoCompanies();
    };


    var reload = function()
    {
        $route.reload();
    };

    $scope.delete = function () {
        alertify
            .okBtn("OK")
            .cancelBtn("Annuleren")
            .confirm("Weet u zeker dat u de geselecteerde bedrijf wilt verwijderen?", function (ev) {
                companyService.delete($scope.selectedCompany.id[0], reload);
                ev.preventDefault();
                alertify.success("Bedrijf succesvol verwijderd");
            }, function (ev) {
                ev.preventDefault();
                alertify.error("Bedrijf niet verwijderd");
        });
    };

    $scope.restore = function () {
        alertify
            .okBtn("OK")
            .cancelBtn("Annuleren")
            .confirm("Weet u zeker dat u de geselecteerde bedrijf wilt herstellen?", function (ev) {
                companyService.delete($scope.selectedCompany.id[0], reload);
                ev.preventDefault();
                alertify.success("Bedrijf succesvol hersteld");
            }, function (ev) {
                ev.preventDefault();
                alertify.error("Bedrijf niet hersteld");
        });
    };


    construct();


});

