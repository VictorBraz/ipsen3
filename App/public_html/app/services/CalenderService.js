/**
 * Created by vedadpiric on 21-12-16.
 */
angular.module('workshop').service('CalenderService', function($http)
{
    var self = this;

    self.create = function (eventName,Datum) {

        var uri = 'api/calender/';
        var data =
            {
                eventName: eventName,
                datum: datum

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
        var uri = 'api/calender/';

        $http.get(uri).then(function(response){
                onReceived(response.data);

            },
            function(message, status){
                alert('Ophalen mislukt, neem contact op met uw beheerder: ' + message);
            });

    };



});