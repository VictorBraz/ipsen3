/**
 * Created by vedadpiric on 21-12-16.
 */
angular.module('workshop').service('CalenderService', function($http)
{
    var self = this;

    self.create = function (datum,eventName,contactPersoon, onCreated) {

        var uri = 'api/calender';
        var data =
            {
                datum: datum,
                eventName: eventName,
                contactPersoon: contactPersoon

            };
        $http.post(uri, data).then(function (response){
                onCreated(response.data);
            },

            function (message)
            {
                alert('Aanmaken mislukt: ' + message);
            });
    };

    self.getAll = function (onReceived) {
        var uri = 'api/calender';

        $http.get(uri).then(function(response){
                onReceived(response.data);

            },
            function(message, status){
                alert('Ophalen mislukt, neem contact op met uw beheerder: ' + message);
            });

    };

    self.selectedEvent = 0;

    self.setSelected = function(id){
        self.selectedEvent = id;
    };
    self.getEvent = function (onReceived) {
        var uri = 'api/calender/' + self.selectedEvent + '';

        $http.get(uri).then(function(response){
                onReceived(response.data);
            },
            function (message, status) {
                alert('Ophalen mislukt, neem contact op met uw beheerder: ' + message + status);
            });
    };

    self.update = function (event, onReceived) {
        var uri = 'api/calender/' + event.id + '';

        $http.put(uri, event).then(function (response) {
                onReceived(response.data);
            },
            function (message, status) {
                alert('Aanpassen mislukt, neem contact op met uw beheerder: ' + message + status);
            });
    };
    self.delete = function(id, onReceived) {
        var uri = 'api/calender/' + id + '';

        $http.delete(uri, id).then(function (response) {
                onReceived(response.data);
            },
            function(message, status) {
                alert('Verwijderen mislukt, neem contact op met uw beheerder: ' + message + status);
            });
    };



});