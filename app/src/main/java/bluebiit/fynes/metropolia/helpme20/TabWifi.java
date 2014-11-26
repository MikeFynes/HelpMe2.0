package bluebiit.fynes.metropolia.helpme20;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mike on 07/10/2014.
 */
public class TabWifi extends Fragment {
    private View myView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedState) {
        myView = inflater.inflate(R.layout.content_wifi, container, false);
        ((FirstPage)getActivity()).setWifi_complete(true);
        return myView;

    }
}
