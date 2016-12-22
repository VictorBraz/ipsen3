
angular.module('workshop').service('userService', function($http)
{
    var self = this;
    
    self.authenticate = function(onSuccess)
    {
        var uri = '/api/users/me';
        
        $http.get(uri).then(function(response)
        {
            onSuccess(response.data);
        },
        function(message, status)
        {
            alert('Inloggen mislukt: ' + message);
        });
    };
    
    self.create = function(id, accountName, password, privilege, userid, onCreated)
    {
        var uri = '/api/users';
        var data =
        {
            id : id,
            accountName: accountName,
            password: password,
            privilege: privilege,
            userId : userid
        };

        $http.post(uri, data).then(function(response)
        {
            onCreated(response.data);
        },
        function(message, status)
        {
            alert('Aanmaken mislukt: ' + message);
        });
    };
    
    self.getAll = function(onReceived)
    {
        var uri = '/api/users';

        $http.get(uri).then(function(response)
        {
            onReceived(response.data);
        },
        function(message, status)
        {
            alert('Ophalen mislukt: ' + message);
        });
    };

    self.selectedUser = 0;

    self.setSelected = function(accName){
        self.selectedUser = accName;
        console.log("SELECTED: " + self.selectedUser);
    };

    self.getUser = function (onReceived) {
        var uri = 'api/clients/' + self.selectedUser + '';

        $http.get(uri).then(function(response){
                onReceived(response.data);
                console.log("trying to get" + self.selectedUser);
            },
            function (message, status) {
                alert('Ophalen mislukt: ' + message + status);
            });
    };
});
