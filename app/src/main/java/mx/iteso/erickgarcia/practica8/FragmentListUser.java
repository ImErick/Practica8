package mx.iteso.erickgarcia.practica8;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by erickgarcia on 10/03/18
 */

public class FragmentListUser extends Fragment {
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_list_user, container, false);

        listView = view.findViewById(R.id.fragmentListView);
        ItemUser itemUser;
        ArrayList<ItemUser> itemUserArrayList = new ArrayList<>();
        ItemUserAdapter itemUserAdapter;


        //TODO: primero que muestre los usuarios luego vemos como se eliminan ALV ImageButton imageButtonDeleterUser = view.findViewById(R.id.imageButtonDeleteUser);
        Map<String, ?> allUsers = new SharedPreferenceMethod(getActivity()).getAllUsers("user");
        if (!allUsers.isEmpty()) {
            for (Map.Entry<String, ?> entry: allUsers.entrySet()) {
                Log.d("map values", entry.getKey() + ": " + entry.getValue().toString()); // si esta funcionando!!!
                itemUser = new ItemUser(entry.getKey(), entry.getValue().toString());
                itemUserArrayList.add(itemUser);
                itemUserAdapter = new ItemUserAdapter(getActivity(), 0, itemUserArrayList);
            }
        } else {
            Log.d("empty list", "no hay usuarios para mostrar!");
            Toast.makeText(getActivity(), "there is not users to show", Toast.LENGTH_SHORT).show();
        }
        return view;
    }
}
