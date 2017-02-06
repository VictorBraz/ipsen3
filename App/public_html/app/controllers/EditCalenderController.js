/**
 * Created by Vedad Piric
 */
angular.module('IN2').controller('EditCalenderController', function($scope, alertify, CalenderService)
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
    $scope.delete = function () {
        alertify
            .okBtn("OK")
            .cancelBtn("Annuleren")
            .confirm("Weet u zeker dat u de geselecteerde cliënt wilt verwijderen?", function (ev) {
                CalenderService.delete($scope.event.id, onDelete);
                ev.preventDefault();
                alertify.success("Afspraak succesvol verwijderd");
            }, function (ev) {
                ev.preventDefault();
                alertify.error("Afspraak niet verwijderd");
            });
    };

    var onUpdated = function()
    {
        $scope.gotoCalender();
    };

    var onDelete = function() {
        $scope.gotoCalender();
    };


    construct();
});
