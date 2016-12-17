
angular.module('workshop').controller('AccountsController', function($scope, accountService)
{
    var construct = function()
    {
        accountService.getAll(function(accounts)
        {
            $scope.accounts = accounts;
        });
    };
    
    construct();
});
