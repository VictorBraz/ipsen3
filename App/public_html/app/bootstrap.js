
angular.module('workshop',
[
    'ngRoute',
    'checklist-model',
    'ngMaterial',
    'materialCalendar'

    // Voeg hier meer modules toe
])
.config(function($httpProvider)
{

    $httpProvider.interceptors.push('requestService');

    if(!$httpProvider.defaults.headers.get)
    {
        $httpProvider.defaults.headers.get = {};
    }
})
.config(function($locationProvider)
{
    $locationProvider.html5Mode(true);
    $locationProvider.baseHref = '/';

})
    .config(function($mdThemingProvider) {
    $mdThemingProvider
        .theme("default")
        .primaryPalette("cyan")
        .accentPalette("light-green");
});
// Voeg hier meer configuraties toe
