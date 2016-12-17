
angular.module('workshop').config(function($routeProvider)
{
    $routeProvider.when('/', { templateUrl: 'assets/partials/home.html', controller: 'HomeController' });
    $routeProvider.when('/register', { templateUrl: 'assets/partials/registration.html', controller: 'RegistrationController' });
    $routeProvider.when('/accounts', { templateUrl: 'assets/partials/accounts.html', controller: 'AccountsController' });
    $routeProvider.when('/companies', { templateUrl: 'assets/partials/companies.html', controller: 'CompaniesController' });
    $routeProvider.when('/clients', {templateUrl: 'assets/partials/clients.html', controller: 'ClientsController' });
    $routeProvider.when('/company', {templateUrl: 'assets/partials/companydetail.html', controller: 'CompanyController' });
    $routeProvider.when('/employees', {templateUrl: 'assets/partials/employees.html', controller: 'EmployeesController' });

    // Voeg hier meer routes toe
    
    $routeProvider.otherwise({ redirectTo: '/' });
});
