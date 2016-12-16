/**
 * Created by Mitch on 12/9/2016.
 */


angular.module('workshop').service('companyService', function($http)
{
    var self = this;

    self.selectedId = 0;

    self.setCompanyID = function(id){
        self.selectedId = id;
    };

    self.getCompanyID = function(){
        console.log('test: ' + self.selectedId);
    };

    self.create = function(name, postcode, streetnumber, email, password, onCreated)
    {
        var uri = '/api/companies';
        var data =
        {

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
        var uri = '/api/companies';

        $http.get(uri).then(function(response)
            {
                onReceived(response.data);
            },
            function(message, status)
            {
                alert('Ophalen mislukt: ' + message);
            });
    };
    self.getCompany = function(onReceived)
    {
        var uri = '/api/companies/' + (self.selectedId - 1)+ '';

        $http.get(uri).then(function(response)
            {
                onReceived(response.data);
                console.log("trying to get" + self.selectedId)
            },
            function(message, status)
            {
                alert('Ophalen mislukt: ' + message + status);
            });
    };


    self.deleteCompany = function(onReceived)
    {
        var uri = '/api/companies/' + (self.selectedId - 1) + '';

        $http.delete(uri)
            .then(
                function(response){
                    console.log("Deleted")
                },
                function(response){
                    // failure call back
                }
            );
    };
});
