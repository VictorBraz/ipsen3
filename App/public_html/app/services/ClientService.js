/**
 * Created by Victor on 12-12-2016.
 */

angular.module('workshop').service('clientService', function($http)
{
    var self = this;

    self.create = function (firstName, lastName, birthDate, Study, Email, phoneNumber, Tag, address, cityname, zipcode, noteText, active, onCreated) {

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
                noteText: noteText,
                active: active
            };
        $http.post(uri, data).then(function (response){
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
            alert('Ophalen mislukt, neem contact op met uw beheerder: ' + message);
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
            alert('Ophalen mislukt, neem contact op met uw beheerder: ' + message + status);
        });
    };

    self.update = function (client, onReceived) {
        var uri = 'api/clients/' + client.id + '';
        console.log("voornaam: " + client.firstname);
        $http.put(uri, client).then(function (response) {
            onReceived(response.data);
        },
        function (message, status) {
            alert('Aanpassen mislukt, neem contact op met uw beheerder: ' + message + status);
        });
    };

    self.delete = function(id, onReceived) {
        var uri = 'api/clients/' + id + '';
        console.log("client " + id);
        $http.delete(uri, id).then(function (response) {
            onReceived(response.data);
            self.getAll(onReceived);
        },
        function(message, status) {
            alert('Verwijderen mislukt: ' + message + status);
        });
    };

    self.restore = function(id, onReceived) {
        var uri = 'api/clients/' + id + '';
        console.log("client" + id);
        $http.put(uri, id).then(function(response) {
            onReceived(response.data);
        },
        function(message, status) {
            alert('Herstellen mislukt: ' + message + status);
        });
    }
});
