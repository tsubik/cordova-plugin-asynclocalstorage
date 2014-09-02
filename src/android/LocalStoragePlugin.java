package com.tsubik.cordova.plugin.asynclocalstorage;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * This class echoes a string called from JavaScript.
 */
public class LocalStoragePlugin extends CordovaPlugin {
    private LocalStorage localStorage;
    private final String pluginName = "asyncLocalStorage";


    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView)
    {
        super.initialize(cordova, webView);
        localStorage = new LocalStorage(cordova.getActivity().getApplicationContext());
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d(pluginName, "LocalStoragePlugin execute action: "+ action + " args: " + args.toString());
        JSONObject o;

        if(action.equalsIgnoreCase("getItem")){
            o = args.getJSONObject(0);
            callbackContext.success(this.localStorage.getItem(o.getString("key")));    
        }
        else if(action.equalsIgnoreCase("setItem")){ 
            o = args.getJSONObject(0);
            this.localStorage.setItem(o.getString("key"), o.getString("value"));    
        }
        else if(action.equalsIgnoreCase("removeItem")){ 
            o = args.getJSONObject(0);
            this.localStorage.removeItem(o.getString("key"));
        }
        else if(action.equalsIgnoreCase("clear")){ 
            this.localStorage.clear();
        }
        else{ 
            return false;
        }
        return true;

    }
}