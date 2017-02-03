/**
 * Created by vedadpiric on 21-12-16.
 */

angular.module("workshop").controller('CalenderController', function($scope, $filter, $q, $timeout,$http, $log,CalenderService) {

    var holidays = {};

    var getHolidays = function () {
        CalenderService.getAll(function (events) {
            $scope.events = events;
            for (i = 0; i < $scope.events.length; i++) {
                tempArray = new Array();

                tempObject  = new Object();

                console.log($scope.events[i]);
                tempObject.name = $scope.events[i].eventName;
                tempObject.date = $scope.events[i].datum;
                tempObject.country = "us";

                tempArray.push(tempObject);

                holidays[$scope.events[i].datum] = tempArray;

            }
            //console.log(events);
        });
    };

    getHolidays();

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
        $scope.msg = "You clicked " + $filter("date")(date, "MMM d, y h:mm:ss a Z");
    };

    $scope.prevMonth = function(data) {
        $scope.msg = "You clicked (prev) month " + data.month + ", " + data.year;
    };

    $scope.nextMonth = function(data) {
        $scope.msg = "You clicked (next) month " + data.month + ", " + data.year;
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
        var data = (holidays[key]||[{ name: ""}])[0].name;
        if (loadContentAsync) {
            var deferred = $q.defer();
            $timeout(function() {
                deferred.resolve(data);
            });
            return deferred.promise;
        }

        return data;

    };

    $scope.register = function () {

        CalenderService.create(
            $scope.datum,
            $scope.contactPersoon,
            $scope.eventName,
            calenderCreated
        );


    };
    var calenderCreated = function () {
        alertify.success("Er is een nieuw agendapunt toegevoegd");
        $scope.gotoCalender();
    };





});

