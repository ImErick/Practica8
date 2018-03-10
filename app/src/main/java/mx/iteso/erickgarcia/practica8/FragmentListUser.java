package mx.iteso.erickgarcia.practica8;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

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
        //TODO: ya me tiltie: como capturo a los pendejos usuarios del shared preferences en el fragment?


        return view;
    }
}
