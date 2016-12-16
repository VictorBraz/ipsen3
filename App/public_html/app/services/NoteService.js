/**
 * Created by Roel on 15-12-2016.
 */
angular.module('workshop').service('noteService', function ($http) {
    var self = this;

    self.create = function(ownerID, onCreated){
        var uri = 'api/notities';
        var data = {
            /*ownerID = ownerID*/};
        $http.post(uri,data).then(function (response) {
            onCreated(response.data);
        }),
        function(message,status) {
            alert('Aanmaken mislukt: '+ message);
        }
    }

    self.getAll = function (onReceived) {
        var uri = 'api/notities';

        $http.get(uri).then(function(response){
                onReceived(response.data);
            },
            function(message, status){
                alert('Ophalen mislukt: ' + message);
            });

    };
})