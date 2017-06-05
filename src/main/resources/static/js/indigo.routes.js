angular.module('indigo')

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/profile', {
            template: '<profile></profile>',
            activetab: 'profile'
        });

        $routeProvider.otherwise({redirectTo: '/dashboard'});
    }])
    .config(['$translateProvider', function ($translateProvider) {
        // configures staticFilesLoader
        $translateProvider.useStaticFilesLoader({
            prefix: 'data/locale-',
            suffix: '.json'
        });
        // load 'en' table on startup
        $translateProvider.preferredLanguage('en');
        $translateProvider.useSanitizeValueStrategy('escape');
    }])