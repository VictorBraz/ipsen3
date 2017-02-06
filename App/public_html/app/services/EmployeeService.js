/**
 * Created by Negin Nafissi on 13-12-2016.
 */

angular.module('IN2').service('employeeService', function ($http, alertify) {

    var self = this;

    self.create = function (firstName, lastName, study, birthDate, email, phoneNumber, tag, address, cityName, zipCode, noteText, onCreated) {

        var uri = '/api/employees';
        var data =
            {
                firstName: firstName,
                lastName: lastName,
                study: study,
                birthDate: birthDate,
                email: email,
                phoneNumber: phoneNumber,
                tag: tag,
                address: address,
                city: cityName,
                postcode: zipCode,
                noteText: noteText
            };
        $http.post(uri, data).then(function (response) {
                onCreated(response.data);
            },
            function () {
                alertify.okBtn("OK").confirm("Aanmaken mislukt, neem contact op met uw beheerder!");
            });
    };

    self.getAll = function (onReceived) {

        var uri = 'api/employees';

        $http.get(uri).then(function (response) {
                onReceived(response.data);
            },
            function () {
                alertify.okBtn("OK").confirm("Ophalen mislukt, neem contact op met uw beheerder!");
            });

    };

    self.selectedEmployee = 0;

    self.setSelected = function (id) {
        self.selectedEmployee = id;
    };

    self.getEmployee = function (onReceived) {
        var uri = 'api/employees/' + self.selectedEmployee + '';

        $http.get(uri).then(function (response) {
                onReceived(response.data);
            },
            function () {
                alertify.okBtn("OK").confirm("Ophalen mislukt, neem contact op met uw beheerder!");
            });
    };

    self.update = function (employee, onReceived) {
        var uri = 'api/employees/' + employee.id + '';

        $http.put(uri, employee).then(function (response) {
                onReceived(response.data);
            },
            function () {
                alertify.okBtn("OK").confirm("Aanpassen mislukt, neem contact op met uw beheerder!");
            });
    };

    self.delete = function (id, onReceived) {
        var uri = 'api/employees/' + id + '';

        $http.delete(uri, id).then(function (response) {
                onReceived(response.data);
                self.getAll(onReceived);
            },
            function () {
                alertify.okBtn("OK").confirm("Verwijderen mislukt, neem contact op met uw beheerder!");
            });
    };

});