
angular.module('workshop').config(function($routeProvider)
{
    $routeProvider.when('/', { templateUrl: 'assets/partials/home.html', controller: 'HomeController' });
    $routeProvider.when('/register', { templateUrl: 'assets/partials/registration.html', controller: 'RegistrationController' });
    $routeProvider.when('/overview', { templateUrl: 'assets/partials/overview.html', controller: 'OverviewController' });
    $routeProvider.when('/companies', { templateUrl: 'assets/partials/companies.html', controller: 'CompaniesController' });
    $routeProvider.when('/clients', {templateUrl: 'assets/partials/clients.html', controller: 'ClientsController' });
    $routeProvider.when('/company', {templateUrl: 'assets/partials/companydetail.html', controller: 'CompanyController' });
    $routeProvider.when('/notes',{templateUrl:'assets/partials/notes.html',controller:'NoteController'});
    $routeProvider.when('/employees', {templateUrl: 'assets/partials/employees.html', controller: 'EmployeesController' });

    // Voeg hier meer routes toe
    
    $routeProvider.otherwise({ redirectTo: '/' });
});
