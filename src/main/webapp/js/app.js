'use strict';

var myApp = angular.module('myApp', [
    'ngRoute',
    'taskControllers',
    'taskServices'
]);

myApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/',
            { templateUrl: 'views/list.html', controller: 'TaskListCtrl'})
        .when('/add',
            { templateUrl: 'views/add.html',  controller: 'TaskAddCtrl'})
        .when('/edit/:id',
            { templateUrl: 'views/edit.html', controller: 'TaskEditCtrl'})
        .otherwise(
            { redirectTo: '/' }
    );
}]);