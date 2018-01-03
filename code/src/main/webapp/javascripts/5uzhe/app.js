angular.module('5uzhe', ['ngRoute', 'ui.bootstrap', 'ngCookies'])

    .constant('AppConfig', {
        'baseUrl': './',
        'defPageSize': '15'
    }).constant('ApiKeyConst', {

    }).config(function($routeProvider, $httpProvider) {
        $routeProvider.when('/', {
            templateUrl: 'tpls/entry.html',
            controller: 'EntryController'
        }).otherwise({
            redirectTo: '/'
        });

        // 构造http拦截器
        $httpProvider.interceptors.push(function($rootScope) {
            return {
                request: function(config) {
                    if ($rootScope.session && config.params) {
                        config.params.sessionId = $rootScope.session.sessionId;
                    }
                    return config;
                },
                requestError: function(rejection) {
                    return rejection;
                },
                response: function(response) {
                    $rootScope.loading = false;
                    return response;
                },
                responseError: function(rejection) {
                    return rejection;
                }

            };
        });
    }).run(function($rootScope, $cookies, $location, AppConfig) {

    });