/**
 * Created by Negin on 13-12-2016.
 */

angular.module('workshop').service('employeeService', function($http)
{
    var self = this;

    self.create = function (firstName, lastName, study, birthDate, email, phoneNumber, tag, address, cityName, zipCode, onCreated) {

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
        };
        $http.post(uri, data).then(function (response)
            {
                onCreated(response.data);
            },
            function (message, status)
            {
                alert('Aanmaken mislukt: ' + message);
            });
    };

    self.getAll = function (onReceived) {

        var uri = 'api/employees';

        $http.get(uri).then(function(response){
                onReceived(response.data);
        },
        function(message, status){
            alert('Ophalen mislukt: ' + message);
        });

    };

    self.selectedEmployee = 0;

    self.setSelected = function(id){
        self.selectedEmployee = id;
    };

    self.getSelected = function () {
        console.log('test: ' + self.selectedId);
    };

    self.getEmployee = function (onReceived) {
        var uri = 'api/employees/' + self.selectedEmployee + '';
        $http.get(uri).then(function(response){
                onReceived(response.data);
                console.log("Trying to get: "+ self.selectedEmployee)
            },
            function (message, status) {
                alert('Ophalen mislukt: ' + message + status);
            });
    };

    self.update = function (employee, onReceived) {
        var uri = 'api/employees/' + employee.id + '';
        console.log("Naam: " + employee.firstName + employee.lastName);
        $http.put(uri, employee).then(function (response) {
                onReceived(response.data);
            },
            function (message, status) {
                alert('Aanpassen mislukt: ' + message + status);
            });
    };

});