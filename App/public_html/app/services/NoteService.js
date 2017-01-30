/**
 * Created by Roel on 15-12-2016.
 */
angular.module('workshop').service('noteService', function($http)
{
    var self = this;

    self.selectedOwnerId = null;

    self.setNoteOwnerID = function(id){
        self.selectedOwnerId = id;
    };

    self.getNoteOwnerID = function(){
        return self.selectedOwnerId;
    };

    self.create = function (id,text,ownerID, onCreated) {

        var uri = '/api/notes';
        var data =
        {
             id:id,
             text:text,
             ownerID:ownerID
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
        var uri = 'api/notes';

        $http.get(uri).then(function(response){
                onReceived(response.data);
            },
            function(message, status){
                alert('Ophalen mislukt: ' + message);
            });

    };

    self.getNote = function(onReceived)
    {
        var uri = '/api/notes/' + (self.selectedOwnerId - 1)+ '';

        $http.get(uri).then(function(response)
            {
                onReceived(response.data);
            },
            function(message, status)
            {
                alert('Ophalen mislukt: ' + message + status);
            });
    };

    self.updateNote = function (note, onReceived) {
        var uri = 'api/notes/' + note.id + '';

        $http.put(uri, note).then(function (response) {
                onReceived(response.data);
            },
            function (message, status) {
                alert('Aanpassen mislukt: ' + message + status);
            });
    };
});
