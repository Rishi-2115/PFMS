package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.keshri_rakesh.pfms.R;

//import com.example.jasper.manageexpense.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class pieggraph extends Fragment {


    public pieggraph() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pieggraph, container, false);
    }

}
