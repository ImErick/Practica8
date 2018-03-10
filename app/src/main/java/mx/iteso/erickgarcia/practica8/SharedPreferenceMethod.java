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


}
