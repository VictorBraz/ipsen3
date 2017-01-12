/**
 * Created by Victor on 12-12-2016.
 */

angular.module('workshop').service('clientService', function($http)
{
    var self = this;

    self.create = function (firstName, lastName, birthDate, Study, Email, phoneNumber, Tag, address, cityname, zipcode, noteText, onCreated) {

        var uri = '/api/clients';
        var data =
            {
                firstname: firstName,
                lastname: lastName,
                birthdate: birthDate,
                study: Study,
                emailAddress: Email,
                phonenumber: phoneNumber,
                tag: Tag,
                address: address,
                city: cityname,
                postcode: zipcode,
                noteText: noteText
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

    self.selectedClient = 0;

    self.setSelected = function(id){
        self.selectedClient = id;
        //console.log("SELECTED: " + self.selectedClient);
    };

    self.getSelected = function () {
        console.log('test: ' + self.selectedId);
    };

    self.getClient = function (onReceived) {
        var uri = 'api/clients/' + self.selectedClient + '';

        $http.get(uri).then(function(response){
            onReceived(response.data);
            console.log("trying to get" + self.selectedClient)
        },
        function (message, status) {
            alert('Ophalen mislukt: ' + message + status);
        });
    };

    self.update = function (client, onReceived) {
        var uri = 'api/clients/' + client.id + '';
        console.log("voornaam: " + client.firstname);
        $http.put(uri, client).then(function (response) {
            onReceived(response.data);
        },
        function (message, status) {
            alert('Aanpassen mislukt: ' + message + status);
        });
    };

});
