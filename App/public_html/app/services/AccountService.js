
angular.module('workshop').service('accountService', function($http)
{
    var self = this;
    
    self.authenticate = function(onSuccess)
    {
        var uri = '/api/accounts/me';
        
        $http.get(uri).then(function(response)
        {
            onSuccess(response.data);
        },
        function(message, status)
        {
            alert('Inloggen mislukt: ' + message);
        });
    };
    
    self.create = function(name, password, onCreated)
    {
        var uri = '/api/accounts';
        var data =
        {
            accountname: name,
            password: password
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
        var uri = '/api/accounts';
        
        $http.get(uri).then(function(response)
        {
            onReceived(response.data);
        },
        function(message, status)
        {
            alert('Ophalen mislukt: ' + message);
        });
    };
});
