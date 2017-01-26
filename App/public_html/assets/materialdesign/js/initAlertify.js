angular
    .module("workshop", ["ngAlertify"])
    .controller("myController", function($scope, alertify) {
        alertify.success("Welcome to alertify!");
    });