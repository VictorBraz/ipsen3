/**
 * Created by Mitch on 12/12/2016.
 * @author Bernd Oostrum
 *
 */
angular.module('workshop').controller('CompanyController', ['$scope','$controller','companyService','noteService','addressService', function ($scope, $controller, companyService,noteService, addressService) {
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

    $scope.register = function () {
        companyService.create(
            $scope.companyname,
            $scope.contactperson,
            $scope.telephonenumber,
            $scope.email,
            $scope.tag,
            $scope.address,
            $scope.city,
            $scope.postcode,
            companyCreated
        );
    };

    $scope.selectedCompany = {
        id: []
    };

    $scope.selectCompany = function() {
        companyService.setSelected($scope.selectedCompany.id[0]);
    };

    var companyCreated = function() {
        alert("Er is een nieuw bedrijf toegevoegd");
        $scope.gotoCompanies();
    };

    construct();

    angular.extend(this, $controller('NoteController', {
        $scope: $scope
    }));
}])

