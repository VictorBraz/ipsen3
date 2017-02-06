/**
 * Created by Victor Machado Braz
 */
angular.module('IN2').service('searchService', function($http){

    var self = this;

    self.setTag = function (tag){
        self.tag = tag;
    };

    self.getFilteredClients = function(onReceived){
        var uri = 'api/search/clients/' + self.tag + '';

        $http.get(uri).then(function(response){
            onReceived(response.data);
        },
        function () {
            alertify.okBtn("OK").confirm("Ophalen mislukt, neem contact op met uw beheerder!");
        });
    };

    self.getFilteredCompanies = function(onReceived){
        var uri = 'api/search/companies/' + self.tag + '';

        $http.get(uri).then(function(response){
            onReceived(response.data);
        },
        function () {
            alertify.okBtn("OK").confirm("Ophalen mislukt, neem contact op met uw beheerder!");
        });
    };

    self.getFilteredEmployees = function(onReceived){
        var uri = 'api/search/employees/' + self.tag + '';

        $http.get(uri).then(function(response){
            onReceived(response.data);
        },
        function () {
            alertify.okBtn("OK").confirm("Ophalen mislukt, neem contact op met uw beheerder!");
        });
    };
});