/**
 * Created by Roel on 16-1-2017.
 */
angular.module('IN2').controller('EditCompanyController', function ($scope, alertify, companyService) {

    var construct = function () {
        companyService.getCompany(function (company) {
            $scope.company = company;
        });
    };

    $scope.update = function () {
        alertify
            .okBtn("OK")
            .cancelBtn("Annuleren")
            .confirm("Weet u zeker dat u de gegevens wilt aanpassen?", function (ev) {
                companyService.update($scope.company, onUpdated);
                ev.preventDefault();
                alertify.success("Bedrijf aangepast");
            }, function (ev) {
                ev.preventDefault();
                alertify.error("Bedrijf niet aangepast");
            });
    };

    var onUpdated = function () {
        $scope.gotoCompanies();
    };

    construct();

});