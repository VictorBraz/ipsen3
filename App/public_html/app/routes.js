
angular.module('workshop').config(function($routeProvider)
{
    $routeProvider.when('/', { templateUrl: 'assets/partials/home.html', controller: 'HomeController' });
    $routeProvider.when('/register', { templateUrl: 'assets/partials/registration.html', controller: 'RegistrationController' });
    $routeProvider.when('/overview', { templateUrl: 'assets/partials/overview.html', controller: 'OverviewController' });
    $routeProvider.when('/companies', { templateUrl: 'assets/partials/companies.html', controller: 'CompanyController' });
    $routeProvider.when('/clients', {templateUrl: 'assets/partials/clients.html', controller: 'ClientController' });
    $routeProvider.when('/company', {templateUrl: 'assets/partials/companydetail.html', controller: 'CompanyController' });
    $routeProvider.when('/addcompany', {templateUrl: 'assets/partials/addcompany.html', controller: 'CompanyController' });
    $routeProvider.when('/editcompany', {templateUrl: 'assets/partials/editCompany.html', controller: 'EditCompanyController' });
    $routeProvider.when('/addclient', {templateUrl: 'assets/partials/addclient.html', controller: 'ClientController' });
    $routeProvider.when('/editClient', {templateUrl: 'assets/partials/editClient.html', controller: 'EditClientController'});
    $routeProvider.when('/calender', {templateUrl: 'assets/partials/calender.html', controller: 'CalenderController' });
    $routeProvider.when('/employees', {templateUrl: 'assets/partials/employees.html', controller: 'EmployeesController' });
    $routeProvider.when('/addEmployee', {templateUrl: 'assets/partials/addEmployee.html', controller: 'EmployeesController' });
    $routeProvider.when('/editEmployee', {templateUrl: 'assets/partials/editEmployee.html', controller: 'EditEmployeeController' });
    $routeProvider.when('/search', {templateUrl: 'assets/partials/search.html', controller: 'SearchController'});
    $routeProvider.when('/viewEmployee', {templateUrl: 'assets/partials/viewEmployee.html', controller: 'EditEmployeeController' });

    // Voeg hier meer routes toe
    
    $routeProvider.otherwise({ redirectTo: '/' });
});
