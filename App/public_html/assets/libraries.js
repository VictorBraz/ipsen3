
(function()
{
    //Jquery
    addScript('assets/libraries/jquery-3.1.1.min.js');

    // AngularJs
    addScript('assets/libraries/angular.min.js');
    addScript('assets/libraries/angular-route.min.js');
    addScript('assets/libraries/ui-bootstrap.min.js');


    // Other
    addScript('assets/libraries/base64.min.js');
    addScript('assets/libraries/checklist-model.js');

    //alertscreen
    addScript('https://cdn.rawgit.com/alertifyjs/alertify.js/v1.0.10/dist/js/ngAlertify.js');
    addScript('assets/materialdesign/js/initAlertify.js');

    //charts
    addScript("https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.js");
    addScript("http://cdn.rawgit.com/jtblin/angular-chart.js/master/dist/angular-chart.js")


    //materialdesign
    addScript('assets/materialdesign/js/arrive.min.js');
    addScript('assets/materialdesign/js/material.min.js');
    addScript('assets/materialdesign/js/ripples.min.js');
    addScript('assets/materialdesign/js/initBootstrap.js');
    addScript('assets/materialdesign/js/angular-material-datetimepicker.js');

    //calender
    addScript('assets/libraries/angular-animate.min.js');
    addScript('assets/libraries/angular-aria.min.js');
    addScript('assets/libraries/angular-material-calendar.js');
    addScript('assets/libraries/angular-material.min.js');
    addScript('assets/libraries/angular-sanitize.min.js');

    function addScript(url)
    {
        document.write('<script type="text/javascript" src="' + url + '"></script>');
    }
})();
