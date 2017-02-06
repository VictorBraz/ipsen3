angular.module('IN2').service('userService', function ($http, alertify) {

    var self = this;
    self.selectedUser = 0;

    self.authenticate = function (onSuccess) {
        var uri = '/api/users/me';
        $http.get(uri).then(function (response) {
                onSuccess(response.data);
            },
            function () {
                alertify.okBtn("OK").confirm("Inloggen mislukt, neem contact op met uw beheerder!");
            });
    };

    self.create = function (emailAddress, password, privilege, userid, onCreated) {
        var uri = '/api/users';

        var data = {
            emailAddress: emailAddress,
            password: password,
            privilege: privilege,
            userId: userid
        };

        $http.post(uri, data).then(function (response) {
                onCreated(response.data);
            },
            function () {
                alertify.okBtn("OK").confirm("Aanmaken mislukt, neem contact op met uw beheerder!");
            });
    };

    self.getAll = function (onReceived) {
        var uri = '/api/users';

        $http.get(uri).then(function (response) {
                onReceived(response.data);
            },
            function () {
                alertify.okBtn("OK").confirm("Ophalen mislukt, neem contact op met uw beheerder!");
            });
    };

    self.setSelected = function (accName) {
        self.selectedUser = accName;
    };

    self.delete = function (id, onReceived) {
        var uri = 'api/users/' + id + '';
        $http.delete(uri, id).then(function (response) {
                onReceived(response.data);
                self.getAll(onReceived);
            },
            function () {
                alertify.okBtn("OK").confirm("Verwijderen mislukt, neem contact op met uw beheerder!");
            });
    };

});
