package org.apache.cordova.appsettings;

import java.util.Locale;

import android.app.Activity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class AppSettings extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        JSONObject options = new JSONObject();
        if (action.equals("get")) {
            try{
                for(int i=0;i<args.length();i++){
                    String key=args.getString(i);
                    PackageManager pm = cordova.getActivity().getApplication().getPackageManager();
                    String packageName = cordova.getActivity().getApplication().getPackageName();
                    ApplicationInfo appInfo = pm.getApplicationInfo(packageName, pm.GET_META_DATA);
                    String keyvalue = appInfo.metaData.getString(key);
                    if (keyvalue != null) {
                        options.put(key, keyvalue);
                    }
                }
                callbackContext.success(options);
            } catch (Exception ex) {
                callbackContext.error(0);
            }
            return true;
        }
        return false;
    }
}
