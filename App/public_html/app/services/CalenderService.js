/**
 * Created by vedadpiric on 21-12-16.
 */
angular.module('IN2').service('CalenderService', function ($http, alertify) {

    var self = this;

    self.create = function (datum, eventName, contactPersoon, onCreated) {

        var uri = 'api/calender';
        var data =
            {
                datum: datum,
                eventName: eventName,
                contactPersoon: contactPersoon

            };
        $http.post(uri, data).then(function (response) {
                onCreated(response.data);
            },
            function () {
                alertify.okBtn("OK").confirm("Aanmaken mislukt, neem contact op met uw beheerder!");
            });
    };

    self.getAll = function (onReceived) {
        var uri = 'api/calender';

        $http.get(uri).then(function (response) {
                onReceived(response.data);

            },
            function () {
                alertify.okBtn("OK").confirm("Ophalen mislukt, neem contact op met uw beheerder!");
            });

    };

    self.selectedEvent = 0;

    self.setSelected = function (id) {
        self.selectedEvent = id;
    };

    self.getEvent = function (onReceived) {
        var uri = 'api/calender/' + self.selectedEvent + '';

        $http.get(uri).then(function (response) {
                onReceived(response.data);
            },
            function () {
                alertify.okBtn("OK").confirm("Ophalen mislukt, neem contact op met uw beheerder!");
            });
    };

    self.update = function (event, onReceived) {
        var uri = 'api/calender/' + event.id + '';

        $http.put(uri, event).then(function (response) {
                onReceived(response.data);
            },
            function () {
                alertify.okBtn("OK").confirm("Aanpassen mislukt, neem contact op met uw beheerder!");
            });
    };

    self.delete = function (id, onReceived) {
        var uri = 'api/calender/' + id + '';

        $http.delete(uri, id).then(function (response) {
                onReceived(response.data);
            },
            function () {
                alertify.okBtn("OK").confirm("Verwijderen mislukt, neem contact op met uw beheerder!");
            });
    };


});