/**
 * Created by Roel on 21-12-2016.
 */
angular.module('workshop').controller('NoteController',function ($scope,noteService) {
    var construct = function () {
        noteService.getNote(function (test2) {
            $scope.note = test2
        })
    }
    construct()
//    $scope.updateNote = function () {
//        noteService.updateNote(
//            $scope.text,
//            $scope.note
//        )
//    }
});