/**
 * Created by Victor on 12-12-2016.
 */
angular.module('workshop').service('clientService', function($http)
{
    var self = this;

    self.create = function (firstname, lastname, birthdate, study, email, phonenumber, tag, onCreated) {

        var uri = '/api/clients';
        var data =
            {
                firstname: firstname,
                lastname: lastname,
                birthdate: birthdate,
                study: study,
                email: email,
                phonenumber: phonenumber,
                tag: tag
            };
        $http.post(uri, data).then(function (response)
        {
            onCreated(response.data);
        },
        function (message, status)
        {
            alert('Aanmaken mislukt: ' + message);
        });
    };

    self.getAll = function (onReceived) {
        var uri = 'api/clients';

        $http.get(uri).then(function(response){
            onReceived(response.data);
        },
        function(message, status){
            alert('Ophalen mislukt: ' + message);
        });

    };

});
