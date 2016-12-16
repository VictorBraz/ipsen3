/**
 * Created by Mitch on 12/9/2016.
 */


angular.module('workshop').service('companyService', function($http)
{
    var self = this;

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
    self.getCompany = function(onReceived, id)
    {
        var uri = '/api/companies/' + id + '';

        $http.get(uri).then(function(response)
            {
                onReceived(response.data);
            },
            function(message, status)
            {
                alert('Ophalen mislukt: ' + message + status);
            });
    };
});
