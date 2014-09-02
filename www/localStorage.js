var exec = require('cordova/exec');

var asyncLocalStorage = {
    getItem: function(key) {
        var promise = new Promise(function(resolve, reject){
	        exec(function(result) {
                resolve(result);
            },
            function(error) {
                reject(error);
            }, "LocalStoragePlugin", "getItem", [{
                key: key
            }]);
    	});
        return promise;
    },
    setItem: function(key, value) {
        exec(null, null, "LocalStoragePlugin", "setItem", [{
            key: key,
            value: value
        }]);
    },
    removeItem: function(key) {
        exec(null, null, "LocalStoragePlugin", "removeItem", [{
            key: key
        }]);
    },
    clear: function() {
        exec(null, null, "LocalStoragePlugin", "clear", []);
    }
};

module.exports = asyncLocalStorage;
