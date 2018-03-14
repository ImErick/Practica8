package mx.iteso.erickgarcia.practica8;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by erickgarcia on 10/03/18
 */

public class FragmentAddUser extends Fragment {
    private EditText editTextName, editTextPhone;
    private Button buttonSaveContact;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        editTextName = view.findViewById(R.id.editTextName);
        editTextPhone = view.findViewById(R.id.editTextPhone);
        buttonSaveContact = view.findViewById(R.id.btnSaveContact);

        buttonSaveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> users = new HashMap<>();
                if (editTextName.getText().toString().length() > 0 && editTextPhone.getText().toString().length() > 0) { // no esta vacio
                    users.put(editTextName.getText().toString(), editTextPhone.getText().toString());
                    if (new SharedPreferenceMethod(getActivity()).addSharedPreferences("user", users)) {
                        Toast.makeText(getActivity(), "user saved!", Toast.LENGTH_SHORT).show();
                        editTextName.setText("");
                        editTextPhone.setText("");
                        editTextName.requestFocus();
                    } else
                        // regreso falso the addSharedPreferences
                        Toast.makeText(getActivity(), "unable to save the user", Toast.LENGTH_SHORT).show();
                } else
                    // la entrada esta vacia o nula
                    Toast.makeText(getActivity(), "unable to save user or phone number", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
