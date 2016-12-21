
angular.module('workshop').config(function($routeProvider)
{
    $routeProvider.when('/', { templateUrl: 'assets/partials/home.html', controller: 'HomeController' });
    $routeProvider.when('/register', { templateUrl: 'assets/partials/registration.html', controller: 'RegistrationController' });
    $routeProvider.when('/overview', { templateUrl: 'assets/partials/overview.html', controller: 'OverviewController' });
    $routeProvider.when('/companies', { templateUrl: 'assets/partials/companies.html', controller: 'CompaniesController' });
    $routeProvider.when('/clients', {templateUrl: 'assets/partials/clients.html', controller: 'ClientController' });
    $routeProvider.when('/company', {templateUrl: 'assets/partials/companydetail.html', controller: 'CompanyController' });
    $routeProvider.when('/addclient', {templateUrl: 'assets/partials/addclient.html', controller: 'ClientController' });
    $routeProvider.when('/employees', {templateUrl: 'assets/partials/employees.html', controller: 'EmployeesController' });
<<<<<<< HEAD
    $routeProvider.when('/calender', {templateUrl: 'assets/partials/calender.html', controller: 'CalenderController' });
=======
    $routeProvider.when('/addEmployee', {templateUrl: 'assets/partials/addEmployee.html', controller: 'EmployeesController' });
>>>>>>> 420345cec54a2699079621fa464cd1c1de914a7d

    // Voeg hier meer routes toe
    
    $routeProvider.otherwise({ redirectTo: '/' });
});
