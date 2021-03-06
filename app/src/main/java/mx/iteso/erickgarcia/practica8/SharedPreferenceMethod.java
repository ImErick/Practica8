package mx.iteso.erickgarcia.practica8;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by erickgarcia on 10/03/18
 */

public class SharedPreferenceMethod {
    private Activity activity;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreferenceMethod(Activity activity) {
        this.activity = activity;
    }

    public boolean addSharedPreferences(String keyShared, Map<String, String> map) {
        boolean saved = true;
        sharedPreferences = activity.getSharedPreferences(keyShared, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        for (Map.Entry<String, String> entry: map.entrySet()) {
            editor.putString(entry.getKey(), entry.getValue());
            if (editor.commit())
                continue;
            else {
                saved = false; // no guardo
                break;
            }
        }
        return saved;
    }

    public boolean cleanAllSharedPreferences(String keyShared) {
        sharedPreferences = activity.getSharedPreferences(keyShared, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        return editor.commit();
    }

    public Map<String, ?> getAllUsers(String keyShared) {
        sharedPreferences = activity.getSharedPreferences(keyShared, Context.MODE_PRIVATE);
        return sharedPreferences.getAll();
    }

    public String getValue(String keyShared, String key) {
        sharedPreferences = activity.getSharedPreferences(keyShared, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "the value does not exist");
    }

    public boolean delKey(String keyShared, String key){
        boolean existe = true;
        sharedPreferences = activity.getSharedPreferences(keyShared, Context.MODE_PRIVATE);

        if (getValue(keyShared, key).equals("the value does not exist"))
            existe = false;
        else {
            editor = sharedPreferences.edit();
            editor.remove(key);
            editor.commit();
            existe = true;
        }
        return existe;
    }
}
