
angular.module('workshop').service('userService', function($http) {

    var self = this;
    self.selectedUser = 0;
    
    self.authenticate = function(onSuccess) {
        var uri = '/api/users/me';
        $http.get(uri).then(function(response) {
            onSuccess(response.data);
        },
        function(message, status) {
            alert('Inloggen mislukt: ' + message);
        });
    };
    
    self.create = function(emailAddress, password, privilege, userid, onCreated) {
        var uri = '/api/users';

        var data = {
            emailAddress: emailAddress,
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
    
    self.getAll = function(onReceived) {
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

    self.setSelected = function(accName){
        self.selectedUser = accName;
    };

    self.delete = function(id, onReceived) {
        var uri = 'api/users/' + id + '';
        $http.delete(uri, id).then(function (response) {
                onReceived(response.data);
                self.getAll(onReceived);
            },
            function(message, status) {
                alert('Verwijderen mislukt: ' + message + status);
            });
    };

});
