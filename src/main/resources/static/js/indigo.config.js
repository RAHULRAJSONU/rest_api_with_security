//for some reason in order to make it work with brunch module init must be wrapped into function

angular.module('indigo', ['ngRoute',
    'ngSanitize',
    'ngResource',
    'ngAnimate',
    'toastr',
    'pascalprecht.translate',
    'spring-data-rest',
    'ui.tree',
    'ui.sortable',
    'engine',
    //application modules
    //this module is dynamically generated in index.html
    'indigo.constants'
]);

angular.module('indigo').config(function (toastrConfig) {
    angular.extend(toastrConfig, {
        autoDismiss: true,
        containerId: 'toast-container',
        maxOpened: 0,
        newestOnTop: true,
        positionClass: 'toast-bottom-right',
        preventDuplicates: false,
        preventOpenDuplicates: false,
        target: 'body'
    });
});