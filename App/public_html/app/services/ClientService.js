/**
 * Created by Negin on 9-12-2016.
 */

angular.module('workshop').service('clientService', function($http)
{
    var self = this;

    self.create = function(/*id, clientAddressId, firstName, lastName, birthDate, email, phoneNumber, study, tag**/)
    {
        var uri = '/api/clients';
        var data =
        {
            // id: id,
            // clientAddressId: clientAddressId,
            // firstName: firstName,
            // lastName: lastName,
            // birthDate: birthDate,
            // email : email,
            // phoneNumber: phoneNumber,
            // study: study,
            // tag: tag
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
        var uri = '/api/clients';

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
