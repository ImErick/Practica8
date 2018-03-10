package mx.iteso.erickgarcia.practica8;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erickgarcia on 10/03/18
 */

public class ItemUserAdapter extends ArrayAdapter<ItemUser>{
    private List<ItemUser> itemUserList;
    private Activity activity;

    public ItemUserAdapter(Activity activity, int r, ArrayList<ItemUser> itemUserList){
        super(activity, r, itemUserList);
        this.activity = activity;
        this.itemUserList = itemUserList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        final View view = inflater.inflate(R.layout.fragment_item_user, parent, false);
        TextView user_name = view.findViewById(R.id.textViewName);
        TextView user_phone = view.findViewById(R.id.textViewPhone);
        ImageButton delete_user = view.findViewById(R.id.imageButtonDeleteUser);
        RelativeLayout relativeLayout = view.findViewById(R.id.fragmentItemListView);

        user_name.setText(itemUserList.get(position).getName());
        user_phone.setText(itemUserList.get(position).getPhone());
        delete_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: hacer el metodo para eliminar al usuario y agregar al SharedPreferenceMethod
            }
        });

        return view;
    }
}
