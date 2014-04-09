'use strict';

var taskControllers = angular.module('taskControllers', []);

taskControllers.controller('TaskListCtrl', ['$scope', '$route', 'Task',
    function($scope, $route, Task) {

        $scope.deleteTask = function (taskId) {
            if (!confirm('Are you sure?')) {
                return;
            }

            Task.delete({id: taskId});
            $route.reload();
        };

        $scope.tasks = Task.query();
}]);

taskControllers.controller('TaskAddCtrl', ['$scope', '$location', 'Task',
    function($scope, $location, Task) {

        $scope.save = function () {
            Task.create($scope.task);
            $location.path('/');
        };
}]);

taskControllers.controller('TaskEditCtrl', ['$scope', '$location', '$routeParams', 'Task',
    function($scope, $location, $routeParams, Task) {

        $scope.task = {};

            $scope.update = function () {
            Task.update($scope.task);
            $location.path('/');
        };

        Task.get({id: $routeParams.id})
            .$promise.then(
            function( value ){
                $scope.task = value;
            },
            function( error ){
                console.log(error);
            }
        )
}]);