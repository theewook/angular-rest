'use strict';

var taskControllers = angular.module('taskControllers', []);

taskControllers.controller('TaskCtrl', ['$scope', 'taskFactory',
    function($scope, taskFactory) {

        $scope.tasks = {};

        $scope.getAll = function () {
            $scope.tasks = taskFactory.query();
        };

        $scope.deleteTask = function (taskId) {
            taskFactory.delete({ id: taskId });
        };

        $scope.getAll();
}]);