
(function()
{
    // Applicatie
    addScript('app/bootstrap.js');
    addScript('app/routes.js');


    // Services
    addScript('app/services/AuthenticationService.js');
    addScript('app/services/RequestService.js');
    addScript('app/services/AddressService.js');
    addScript('app/services/AccountService.js');
    addScript('app/services/CompanyService.js');
    addScript('app/services/ClientService.js');
    addScript('app/services/EmployeeService.js');

    // Controllers
    addScript('app/controllers/AppController.js');
    addScript('app/controllers/HomeController.js');
    addScript('app/controllers/RegistrationController.js');
    addScript('app/controllers/AccountController.js');
    addScript('app/controllers/CompaniesController.js');
    addScript('app/controllers/CompanyController.js');
    addScript('app/controllers/ClientsController.js');
    addScript('app/controllers/ClientsController.js');
    addScript('app/controllers/EmployeesController.js');
    function addScript(url)
    {
        document.write('<script type="text/javascript" src="' + url + '"></script>');
    }
})();
