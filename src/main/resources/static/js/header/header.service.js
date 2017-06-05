angular.module('indigo')
    .component('indigoHeader', {
        templateUrl: 'js/header/header.view.html',
        controller: function ($scope, $route, SESSION) {
            this.$route = $route
            if (SESSION.roles.indexOf("ROLE_PROVIDER") != -1)
                this.is_provider = true;
        }
    });