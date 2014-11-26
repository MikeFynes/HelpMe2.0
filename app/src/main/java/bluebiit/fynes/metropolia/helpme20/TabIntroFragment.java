package bluebiit.fynes.metropolia.helpme20;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by mike on 07/10/2014.
 */
public class TabIntroFragment extends Fragment {
    private static final String PREF = "TestPref";
    View myView;
    TextView acc, applic, browser, camera, gest, icons, sounds, wp, wifi, user;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedState) {
        myView = inflater.inflate(R.layout.content_intro, container, false);
        user = (TextView) myView.findViewById(R.id.detail_intro_user);
        acc = (TextView) myView.findViewById(R.id.intro_status_acc_bool);
        applic = (TextView) myView.findViewById(R.id.intro_status_app_bool);
        browser = (TextView) myView.findViewById(R.id.intro_status_browser_bool);
        camera = (TextView) myView.findViewById(R.id.intro_status_camera_bool);
        gest = (TextView) myView.findViewById(R.id.intro_status_gest_bool);
        icons = (TextView) myView.findViewById(R.id.intro_status_icons_bool);
        sounds = (TextView) myView.findViewById(R.id.intro_status_sounds_bool);
        wp = (TextView) myView.findViewById(R.id.intro_status_wp_bool);
        wifi = (TextView) myView.findViewById(R.id.intro_status_wifi_bool);

        String userName = ((FirstPage) getActivity()).getUser();
        user.setText(userName);

        statusSetter();




        return myView;

    }

    @Override
    public void onResume() {
        super.onResume();
        statusSetter();


    }


    public void statusSetter(){
        if (((FirstPage) getActivity()).isAcc_complete()) {
            acc.setText(getResources().getString(R.string.completed));
        } else {
            acc.setText(getResources().getString(R.string.notComplete));
        }

        if (((FirstPage) getActivity()).isApp_complete()) {
            applic.setText(getResources().getString(R.string.completed));
        } else {
            applic.setText(getResources().getString(R.string.notComplete));
        }

        if (((FirstPage) getActivity()).isBrowser_complete()) {
            browser.setText(getResources().getString(R.string.completed));
        } else {
            browser.setText(getResources().getString(R.string.notComplete));
        }

        if (((FirstPage) getActivity()).isCam_complete()) {
            camera.setText(getResources().getString(R.string.completed));
        } else {
            camera.setText(getResources().getString(R.string.notComplete));
        }

        if (((FirstPage) getActivity()).isGest_complete()) {
            gest.setText(getResources().getString(R.string.completed));
        } else {
            gest.setText(getResources().getString(R.string.notComplete));
        }

        if (((FirstPage) getActivity()).isIcon_complete()) {
            icons.setText(getResources().getString(R.string.completed));
        } else {
            icons.setText(getResources().getString(R.string.notComplete));
        }

        if (((FirstPage) getActivity()).isSound_complete()) {
            sounds.setText(getResources().getString(R.string.completed));
        } else {
            sounds.setText(getResources().getString(R.string.notComplete));
        }

        if (((FirstPage) getActivity()).isWp_complete()) {
            wp.setText(getResources().getString(R.string.completed));
        } else {
            wp.setText(getResources().getString(R.string.notComplete));
        }

        if (((FirstPage) getActivity()).isWifi_complete()) {
            wifi.setText(getResources().getString(R.string.completed));
        } else {
            wifi.setText(getResources().getString(R.string.notComplete));
        }
    }
}
