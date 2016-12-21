/**
 * Created by Negin on 13-12-2016.
 */

angular.module('workshop').service('employeeService', function($http)
{
    var self = this;

    self.create = function (firstName, lastName, study, birthDate, phoneNumber, email, tag, onCreated) {

        var uri = '/api/employees';
        var data =
        {
            firstName: firstName,
            lastName: lastName,
            study: study,
            birthDate: birthDate,
            phoneNumber: phoneNumber,
            email: email,
            tag: tag,
            /*zipCode: "",
            streetNumber: ""**/
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

        var uri = 'api/employees';

        $http.get(uri).then(function(response){
                onReceived(response.data);
        },
        function(message, status){
            alert('Ophalen mislukt: ' + message);
        });

    };

});