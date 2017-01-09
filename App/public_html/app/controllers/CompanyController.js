/**
 * Created by Mitch on 12/12/2016.
 */
angular.module('workshop').controller('CompanyController', ['$scope','$controller','companyService','noteService', function ($scope, $controller, companyService,noteService) {
    var construct = function()
    {
        console.log("Contruct Controller 1");
        companyService.getCompanyID();
        noteService.setNoteOwnerID(companyService.getCompanyID());
        companyService.getCompany(function(test)
        {
            $scope.company = test;
        });
    };

    construct();

    angular.extend(this, $controller('NoteController', {
        $scope: $scope
    }));
}])

