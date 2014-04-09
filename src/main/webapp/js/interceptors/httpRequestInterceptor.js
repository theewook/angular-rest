'use strict';

var httpRequestInterceptor = angular.module('httpRequestInterceptor', []);

httpRequestInterceptor.config(function($provide, $httpProvider) {

        // this message will appear for a defined amount of time and then vanish again
        var showMessage = function(content) {

            $('#errorMessageContent').text(content);
            $('#errorMessage').show().delay(5000).fadeOut(300);;
        };

        // push function to the responseInterceptors which will intercept
        // the http responses of the whole application
        $httpProvider.responseInterceptors.push(function($timeout, $q) {
            return function(promise) {
                return promise.then(function(successResponse) {
                        return successResponse || $q.when(successResponse);
                    },
                    // if the message returns unsuccessful we display the error
                    function(errorResponse) {
                        console.log('Error ' + errorResponse.status + ': ' + errorResponse.data.message);
                        showMessage('Error ' + errorResponse.status + ': ' + errorResponse.data.message);
                        return $q.reject(errorResponse);
                    });
            };
        });
});