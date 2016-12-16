/**
 * Created by Roel on 16-12-2016.
 */
angular.module('workshop').controller('NoteController', function($scope, noteService)
{
    var construct = function()
    {
        noteService.getAll(function (notes)
        {
            $scope.notes = notes;
        });
    };

    construct();
});
