
(function()
{
    //Jquery
    addScript('https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js');

    // AngularJs
    addScript('assets/libraries/angular.min.js');
    addScript('assets/libraries/angular-route.min.js');
    addScript('assets/libraries/ui-bootstrap.min.js');

    // Other
    addScript('assets/libraries/base64.min.js');

    //materialdesign
    addScript('assets/materialdesign/js/arrive.min.js')
    addScript('assets/materialdesign/js/material.min.js');
    addScript('assets/materialdesign/js/ripples.min.js');
    addScript('assets/materialdesign/js/initBootstrap.js');



    function addScript(url)
    {
        document.write('<script type="text/javascript" src="' + url + '"></script>');
    }
})();
