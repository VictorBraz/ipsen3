/**
 * Created by Roel on 21-12-2016.
 */
angular.module('workshop').controller('NoteController',function ($scope,noteService) {
    var construct = function () {
        console.log('Contruct Controller 2');
        noteService.getNote(function (note) {
            $scope.note = note
        })
    }

    $scope.updateNote = function () {
        var confirmation = confirm("Weet u zeker dat u de gegevens wilt aanpassen?");
        if (confirmation == true) {
            noteService.updateNote($scope.note, onUpdated);
        }
        else{
            alert('Gegevens niet aangepast!');
        }
    };

    var onUpdated = function()
    {
        alert('Note aangepast! ');
        $scope.gotoHome();
    };

    construct()

});