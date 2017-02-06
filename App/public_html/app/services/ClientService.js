/**
 * Created by Victor Machado Braz, Bernd Oostrum
 */

angular.module('IN2').service('clientService', function($http, alertify)
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
            alertify.okBtn("OK").confirm("Aanmaken mislukt, neem contact op met uw beheerder!");
        });
    };

    self.getAll = function (onReceived) {
        var uri = 'api/clients';

        $http.get(uri).then(function(response){
            onReceived(response.data);
        },
        function(message, status){
            alertify.okBtn("OK").confirm("Ophalen mislukt, neem contact op met uw beheerder!");
        });

    };

    self.fileName = '';
    self.selectedClient = 0;

    self.setSelected = function(id){
        self.selectedClient = id;
    };

    self.getClient = function (onReceived) {
        var uri = 'api/clients/' + self.selectedClient + '';

        $http.get(uri).then(function(response){
            onReceived(response.data);
        },
        function (message, status) {
            alertify.okBtn("OK").confirm("Ophalen mislukt, neem contact op met uw beheerder!");
        });
    };

    self.getClientFiles = function (onReceived) {
        var uri = 'api/documents/' + self.selectedClient + '';

        $http.get(uri).then(function(response){
                onReceived(response.data);
                self.fileName = response.data;
            },
            function (message, status) {
                alertify.okBtn("OK").confirm("Ophalen mislukt, neem contact op met uw beheerder!");
        });
    };

    self.getFile = function (onReceived,documentname){
        var uri = 'api/documents/' + self.selectedClient + '/' + documentname + '';

        $http.get(uri).then(function (response) {
            onReceived(response.data);
        })
    };



    self.update = function (client, onReceived) {
        var uri = 'api/clients/' + client.id + '';

        $http.put(uri, client).then(function (response) {
            onReceived(response.data);
        },
        function (message, status) {
            alertify.okBtn("OK").confirm("Aanpassen mislukt, neem contact op met uw beheerder!");
        });
    };

    self.delete = function(id, onReceived) {
        var uri = 'api/clients/' + id + '';

        $http.delete(uri, id).then(function (response) {
            onReceived(response.data);
        },
        function(message, status) {
            alertify.okBtn("OK").confirm("Verwijderen mislukt, neem contact op met uw beheerder!");
        });
    };

    // self.restore = function(id, onReceived) {
    //     var uri = 'api/clients/' + id + '';
    //
    //     $http.put(uri, id).then(function(response) {
    //         onReceived(response.data);
    //     },
    //     function(message, status) {
    //         alert('Herstellen mislukt, neem contact op met uw beheerder: ' + message + status);
    //     });
    // }
});
