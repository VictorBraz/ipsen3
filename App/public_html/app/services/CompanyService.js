/**
 * Created by Mitch on 12/9/2016.
 */


angular.module('workshop').service('companyService', function($http)
{
    var self = this;

    self.create = function (companyName, contactPerson, phoneNumber, email, tags, address, city, zipcode, noteText, onCreated){

        var uri = '/api/companies';
        var data =
        {
            companyName: companyName,
            contactPerson: contactPerson,
            phoneNumber: phoneNumber,
            email: email,
            tag: tags,
            address: address,
            city: city,
            zipcode: zipcode,
            noteText: noteText
        };

        $http.post(uri, data).then(function (response) {
            onCreated(response.data);
        },

        function (message, status) {
            alert("Aanmaken mislukt: " + message);
        });
    };

    self.getAll = function (onReceived) {
        var uri = "api/companies";

        $http.get(uri).then(function(response) {
            onReceived(response.data);
        },
        function(message, status) {
            alert("ophalen mislukt: " + message);
        });
    };
    self.getCompany = function(onReceived) {
        var uri = '/api/companies/' + (self.selectedId - 1) + '';

        if (self.selectedId >= 1) {
            $http.get(uri).then(function (response) {
                    onReceived(response.data);
                    console.log("trying to get" + self.selectedId)
                },
                function (message, status) {
                    alert('Ophalen mislukt: ' + message + status);
                });
        }

        self.selectedCompany = 0;

        self.setSelected = function (id) {
            self.selectedCompany = id;
        };

        self.getSelected = function () {
            console.log('test: ' + self.selectedId);
        };

        self.getCompany = function (onReceived) {
            var uri = "api/companies/" + self.selectedCompany + "";

            $http.get(uri).then(function (response) {
                    onReceived(response.data);
                    console.log("trying to get" + self.selectedClient)
                },
                function (message, status) {
                    alert("Ophalen mislukt: " + message + status);
                });
        };

        self.update = function (company, onReceived) {
            var uri = "api/companies/" + company.id + "";
            console.log("bedrijfsnaam: " + company.companyname);
            $http.put(uri, company).then(function (response) {
                    onReceived(response.data);
                },
                function (message, status) {
                    alert("Aanpassen mislukt: " + message + status);
                });
        };
    }
});


//     self.deleteCompany = function(onReceived)
//     {
//         var uri = '/api/companies/' + (self.selectedId - 1) + '';
//
//         $http.delete(uri)
//             .then(
//                 function(response){
//                     console.log("Deleted")
//                 },
//                 function(response){
//                     // failure call back
//                 }
//             );
//     };
//});
