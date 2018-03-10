package mx.iteso.erickgarcia.practica8;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by erickgarcia on 10/03/18
 */

public class SharedPreferenceActivity extends AppCompatActivity{
    ImageButton imageButtonList, imageButtonAdd, imageButtonDeleteAll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preference_activity);

        imageButtonAdd = (ImageButton) findViewById(R.id.imageButton_add);
        imageButtonList = (ImageButton) findViewById(R.id.imageButton_list);
        imageButtonDeleteAll = (ImageButton) findViewById(R.id.imageButton_delete);

        imageButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = new FragmentAddUser();
                fragmentTransaction.add(R.id.main_frameLayout, fragment);
                fragmentTransaction.commit();
            }
        });
    }
}
