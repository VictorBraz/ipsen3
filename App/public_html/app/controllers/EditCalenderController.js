/**
 * Created by Vedad Piric
 */
angular.module('workshop').controller('EditCalenderController', function($scope, alertify, CalenderService)
{
    var construct = function()
    {
        CalenderService.getEvent(function(event)
        {
            $scope.event = event;


        });

    };

    $scope.update = function () {
        alertify
            .okBtn("OK")
            .cancelBtn("Annuleren")
            .confirm("Weet u zeker dat u de gegevens wilt aanpassen?", function (ev) {
            CalenderService.update($scope.event, onUpdated);
                ev.preventDefault();
                alertify.success("Agendapunt aangepast");
        }, function (ev) {
                ev.preventDefault();
                alertify.error("Agendapunt niet aangepast");
        });
    };

    var onUpdated = function()
    {
        $scope.gotoCalender();
    };


    construct();
});
