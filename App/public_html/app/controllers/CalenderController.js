/**
 * Created by vedadpiric on 21-12-16.
 */

angular.module("IN2").controller('CalenderController', function($scope, $filter, $q, $timeout, $http, $log, CalenderService, alertify) {

    var eventday = {};

    var getEvents = function () {
        CalenderService.getAll(function (events) {
            $scope.events = events;
            for (i = 0; i < $scope.events.length; i++) {
                tempArray = new Array();

                tempObject  = new Object();


                tempObject.name = $scope.events[i].eventName;
                tempObject.date = $scope.events[i].datum;
                tempObject.id = $scope.events[i].id;

                tempArray.push(tempObject);

                eventday[$scope.events[i].datum] = tempArray;

            }

        });
    };

    getEvents();

    $scope.selectedDate = new Date();
    $scope.weekStartsOn = 0;
    $scope.dayFormat = "d";
    $scope.tooltips = true;
    $scope.disableFutureDates = false;

    $scope.setDirection = function(direction) {
        $scope.direction = direction;
        $scope.dayFormat = direction === "vertical" ? "EEEE, MMMM d" : "d";
    };

    $scope.dayClick = function(date) {

        $scope.viewSettedEvent($scope.getid(date));
    };

    var numFmt = function(num) {
        num = num.toString();
        if (num.length < 2) {
            num = "0" + num;
        }
        return num;
    };

    var loadContentAsync = true;
    $log.info("setDayContent.async", loadContentAsync);



    $scope.setDayContent = function(date) {
        var key = [date.getFullYear(), numFmt(date.getMonth()+1), numFmt(date.getDate())].join("-");
        var data = (eventday[key]||[{ name: ""}])[0].name;
        if (loadContentAsync) {
            var deferred = $q.defer();
            $timeout(function() {
                deferred.resolve(data);
            });
            return deferred.promise;
        }
            reload()
        return data;

    };
    $scope.getid = function(date) {
        var key = [date.getFullYear(), numFmt(date.getMonth()+1), numFmt(date.getDate())].join("-");
        var data = (eventday[key]||[{ id: ""}])[0].id;
        return data;

    };

    $scope.register = function () {

        CalenderService.create(
            $scope.datum,
            $scope.eventName,
            $scope.contactPersoon,
            calenderCreated
        );


    };
    var calenderCreated = function () {
        alertify.success("Er is een nieuw agendapunt toegevoegd");
        $scope.gotoCalender();
    };

    $scope.viewSettedEvent = function (id) {
        CalenderService.setSelected(id);
        $scope.gotoViewCalender();
    };

    var reload = function() {
        $route.reload();
    };

});

