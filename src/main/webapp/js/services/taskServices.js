'use strict';

var taskServices = angular.module('taskServices', [
    'ngResource'
]);

taskServices.factory('Task', ['$resource', function ($resource) {
    return $resource('api/tasks/:id', {
        id : '@id'
    }, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' },
        get: { method: 'GET' },
        update: { method: 'PUT' },
        delete: { method: 'DELETE' }
    })
}]);