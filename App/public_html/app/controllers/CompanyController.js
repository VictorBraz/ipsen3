/**
 * Created by Mitch on 12/12/2016.
 * @author Bernd Oostrum
 *
 */
angular.module('workshop').controller('CompanyController', function ($scope, companyService, addressService) {

    $scope.selectedCompanyTest = {
        id: []
    };


    var construct = function() {
        companyService.getAll(function(companies){
            $scope.companies = companies;
        });
    };

    $scope.checkAddress = function () {
        addressService.get($scope.postcode, $scope.streetnumber, function (address) {
            $scope.street = address.street;
            $scope.city = address.city;
        });
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
            companyCreated
        );
    };

    $scope.selectCompany = function() {
        companyService.setSelected($scope.selectedCompany.id[0]);
    };

    var companyCreated = function() {
        alert("Er is een nieuw bedrijf toegevoegd");
        $scope.gotoCompanies();
    };

    construct();


});

