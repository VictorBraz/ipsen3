angular.module('workshop',
    [
        'ngRoute',
        'checklist-model',
        'ngMaterial',
        'materialCalendar',
        'ngAlertify',
        'ngAnimate',
        'chart.js'



        // Voeg hier meer modules toe
    ])
    .config(function ($httpProvider) {

        $httpProvider.interceptors.push('requestService');

        if (!$httpProvider.defaults.headers.get) {
            $httpProvider.defaults.headers.get = {};
        }
    })
    .config(function ($locationProvider) {
        $locationProvider.html5Mode(true);
        $locationProvider.baseHref = '/';

    })
    .config(function ($mdThemingProvider) {
        $mdThemingProvider
            .theme("default")
            .primaryPalette("cyan")
            .accentPalette("light-green");
    })

    .directive("ngModel", ["$timeout", function ($timeout) {
        return {
            restrict: 'A',
            priority: -1, // lower priority than built-in ng-model so it runs first
            link: function (scope, element, attr) {
                scope.$watch(attr.ngModel, function (value) {
                    $timeout(function () {
                        if (value) {
                            element.trigger("change");
                        } else if (element.attr('placeholder') === undefined) {
                            if (!element.is(":focus"))
                                element.trigger("blur");
                        }
                    });
                });
            }
        };
    }]);


// Voeg hier meer configuraties toe
