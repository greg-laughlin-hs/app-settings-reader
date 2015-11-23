

var exec = require('cordova/exec');

function AppSettings() {

}
/**
 * Get a config.xml settings (preference) value
 *
 * @param {Function} successCallback The function to call when the value is available
 * @param {Function} errorCallback The function to call when value is unavailable
 * @param {String} key Key
 */
AppSettings.prototype.fetch = function (successCallback, errorCallback) {
    exec(successCallback, errorCallback, "AppSettings", "fetch", []);
};

module.exports = new AppSettings();

