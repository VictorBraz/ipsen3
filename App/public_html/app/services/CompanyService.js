/**
 * Created by Mitch on 12/9/2016.
 * @author Bernd, Roel
 *
 */


angular.module('IN2').service('companyService', function($http, alertify)
{
    var self = this;

    self.create = function (companyName, contactPerson, phoneNumber, Email, Tag, Address, City, zipCode, noteText, active, onCreated){

        var uri = '/api/companies';
        var data =
        {
            companyName: companyName,
            contactPerson: contactPerson,
            phoneNumber: phoneNumber,
            email: Email,
            tag: Tag,
            address: Address,
            city: City,
            postcode: zipCode,
            noteText: noteText,
            active: active
        };

        $http.post(uri, data).then(function (response) {
            onCreated(response.data);
        },

        function (message, status) {
            alertify.okBtn("OK").confirm("Aanmaken mislukt, neem contact op met uw beheerder!");
        });
    };

    self.getAll = function (onReceived) {
        var uri = "api/companies";

        $http.get(uri).then(function(response) {
            onReceived(response.data);
        },
        function(message, status) {
            alertify.okBtn("OK").confirm("Ophalen mislukt, neem contact op met uw beheerder!");
        });
    };

    self.selectedCompany = 0;

    self.getCompany = function(onReceived) {
        var uri = '/api/companies/' + (self.selectedCompany) + '';

        if (self.selectedCompany >= 1) {
            $http.get(uri).then(function (response) {
                    onReceived(response.data);
                },
                function (message, status) {
                    alertify.okBtn("OK").confirm("Ophalen mislukt, neem contact op met uw beheerder!");
            });
        }
    };

    self.setSelected = function (id) {
        self.selectedCompany = id;
    };

    self.delete = function(id, onReceived) {
        var uri = 'api/companies/' + id + '';

        $http.delete(uri, id).then(function (response) {
                onReceived(response.data);
                self.getAll(onReceived);
            },
            function(message, status) {
                alertify.okBtn("OK").confirm("Verwijderen mislukt, neem contact op met uw beheerder!");
        });
    };

    self.update = function (company, onReceived) {
        var uri = "api/companies/" + company.id + "";

        $http.put(uri, company).then(function (response) {
                onReceived(response.data);
            },
            function (message, status) {
                alertify.okBtn("OK").confirm("Aanpassen mislukt, neem contact op met uw beheerder!");
        });
    };
});
