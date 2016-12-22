
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

    //materialdesign
    addScript('assets/materialdesign/js/arrive.min.js');
    addScript('assets/materialdesign/js/material.min.js');
    addScript('assets/materialdesign/js/ripples.min.js');
    addScript('assets/materialdesign/js/initBootstrap.js');

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
