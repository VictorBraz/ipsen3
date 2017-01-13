/**
 * Created by Braz on 09/01/2017.
 */
angular.module('workshop').service('searchService', function($http){

    var self = this;

    self.tag;

    self.setTag = function (tag){
        self.tag = tag;
    }

    self.getFilteredClients = function(onReceived){
        var uri = 'api/search/clients/' + self.tag + '';

        $http.get(uri).then(function(response){
            onReceived(response.data);
        },
        function (message) {
            alert('ophalen mislukt: ' + message);
        });
    };

    self.getFilteredCompanies = function(onReceived){
        var uri = 'api/search/companies/' + self.tag + '';

        $http.get(uri).then(function(response){
            onReceived(response.data);
        },
        function (message){
            alert('ophalen mislukt: ' + message);
        });
    };

    self.getFilteredEmployees = function(onReceived){
        var uri = 'api/search/employees/' + self.tag + '';

        $http.get(uri).then(function(response){
                onReceived(response.data);
            },
            function (message){
                alert('ophalen mislukt: ' + message);
            });
    };
});