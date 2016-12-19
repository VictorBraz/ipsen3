/**
 * Created by Victor on 12-12-2016.
 */

angular.module('workshop').service('clientService', function($http)
{
    var self = this;

    self.create = function (firstName, lastName, birthDate, Study, Email, phoneNumber, Tag, /*streetname, cityname,*/ /*zipcode, streetnumber,*/ onCreated) {

        var uri = '/api/clients';
        var data =
            {
                firstname: firstName,
                lastname: lastName,
                birthdate: birthDate,
                study: Study,
                emailAddressClient: Email,
                phonenumber: phoneNumber,
                tag: Tag,
                /*street: streetname,
                city: cityname,*/
                /*zipCode: zipcode,
                streetNumber: streetnumber,*/
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
