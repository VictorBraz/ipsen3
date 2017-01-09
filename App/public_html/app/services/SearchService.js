/**
 * Created by Braz on 09/01/2017.
 */
angular.module('workshop').service('searchService', function($http){

    var self = this;

    self.tag;

    self.setTag = function (tag){
        self.tag = tag;
    }

    self.getFiltered = function(onReceived){
        var uri = 'api/search/' + self.tag + '';

        $http.get(uri).then(function (response) {
            onReceived(response.data);
        },
        function (message, status) {
            alert('ophalen mislukt: ' + message + status);
        });
    };
});