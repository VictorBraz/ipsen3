angular.module('workshop').controller('CompaniesOverviewController', function($scope, companyService)
{
    $scope.selectedcompanies = {
        id: []
    };

    var construct = function()
    {
        companyService.getAll(function(companies)
        {
            $scope.companies = companies;

        });

        companyService.getAll(function(companies)
        {
            $scope.companytest = companies[$scope.selectedcompanies[0]];

        });

        $scope.ontestClick = function() {
            companyService.setCompanyID($scope.selectedcompanies.id[0]);
            console.log($scope.selectedcompanies.id[0])
            companyService.getCompanyID();
        }

        $scope.deleteCompany = function() {
            companyService.getCompanyID();
            companyService.deleteCompany();
        }

        $scope.checkSelected = function() {
            if ($scope.selectedcompanies.id.length >= 1) { // your question said "more than one element"
                console.log("1 of meer selected")
                $scope.checkSelectedVar = true;
            }
            else {
                console.log("lager dan 1 selected")
                $scope.checkSelectedVar = false;
            }
        };
    };




    construct();



});


//
// angular.module('workshop').controller('CompaniesController', function($scope, companyService)
// {
//     $scope.selectedcompanies = {
//         id: []
//     };
//
//     var construct = function()
//     {
//         companyService.getAll(function(companies)
//         {
//             $scope.companies = companies;
//
//         });
//
//         companyService.getAll(function(companies)
//         {
//             $scope.companytest = companies[$scope.selectedcompanies[0]];
//
//         });
//
//         $scope.ontestClick = function() {
//             companyService.setCompanyID($scope.selectedcompanies.id[0]);
//             companyService.getCompanyID();
//         }
//
//         $scope.deleteCompany = function() {
//             companyService.getCompanyID();
//             companyService.deleteCompany();
//         }
//     };
//
//     construct();
//
//
//
// });
//
//
