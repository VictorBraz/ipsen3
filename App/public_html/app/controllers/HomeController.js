angular.module('IN2').controller('HomeController', function ($scope, authenticationService, userService) {

    $scope.login = function () {

        authenticationService.createAuthentication($scope.emailAddress, $scope.password);

        userService.authenticate(function (authenticator) {
            authenticationService.setAuthenticator(authenticator);
            authenticationService.storeAuthentication($scope.remember);
        });

    };

    $scope.labels = ["Januari", "Februari", "Maart", "April", "Mei", "Juni", "Juli"];
    $scope.series = ['Series A', 'Series B'];
    $scope.data = [
        [65, 59, 80, 81, 56, 55, 40],
        [28, 48, 40, 19, 86, 27, 90]
    ];

    $scope.onClick = function (points, evt) {
        console.log(points, evt);
    };

    $scope.datasetOverride = [{yAxisID: 'y-axis-1'}, {yAxisID: 'y-axis-2'}];

    $scope.options = {
        scales: {
            yAxes: [
                {
                    id: 'y-axis-1',
                    type: 'linear',
                    display: true,
                    position: 'left'
                },
                {
                    id: 'y-axis-2',
                    type: 'linear',
                    display: true,
                    position: 'right'
                }
            ]
        }
    };

    $scope.labelsfordonut = ["Medewerkers", "Clienten", "Bedrijven"];

    $scope.datafordonut = [300, 500, 100];
});
