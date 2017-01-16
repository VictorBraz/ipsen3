/**
 * Created by bernd on 12-1-2017.
 */

(function() {
    'use strict';

    angular.module('navBarDemoBasicUsage', ['ngMaterial'])
        .controller('AppCtrl', AppCtrl);

    function AppCtrl($scope) {
        $scope.currentNavItem = 'page1';
    }
})();