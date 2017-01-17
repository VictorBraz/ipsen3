/**
 * Created by Roel on 16-1-2017.
 */
angular.module('workshop').controller('EditCompanyController', function ($scope, companyService) {
    var construct = function () {
        companyService.getCompany(function (company) {
            $scope.company = company;
        });
    };

    $scope.update = function () {
        var confirmation = confirm("Weet u zeker dat u de gegevens wilt aanpassen?");
        if (confirmation == true) {
            companyService.update($scope.company, onUpdated);
        }
        else{
            alert('Gegevens niet aangepast!');
        }
    };

    var onUpdated = function()
    {
        alert('Company aangepast!');
        $scope.gotoCompanies();
    };


    construct();
});