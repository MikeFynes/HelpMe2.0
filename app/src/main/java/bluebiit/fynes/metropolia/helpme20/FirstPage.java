package bluebiit.fynes.metropolia.helpme20;

import android.app.ActionBar;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by mike on 03/10/2014.
 */
public class FirstPage extends StartPage {

    private String user;
    private boolean acc_complete, app_complete, browser_complete, cam_complete, gest_complete, icon_complete, sound_complete, wp_complete, wifi_complete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        setLanguageSelected(getLanguageChoice().getLanguage());

        setContentView(R.layout.activity_main_en);
        userGrabber();

        ActionBar actionBar = getActionBar();






        // LABEL FOR EACH TAB USES SAME STRING INSTANCE BUT DIFFERENT LABELS FOR EACH TAB
        String label1 = getResources().getString(R.string.tab_lbl_intro);


        // INSTANTIATES NAVIGATION TABS


        /*
        EXAMPLE OF TAB - THIS CAN BE COPIES AND AMENDED TO CREATE NEW TAB

        -----
        EACH TAB MUST HAVE A LABEL, LABEL IS ASSIGNED BY GETTING STRING ALL
        TABS USE VARIABLE label1 FOR SIMPLICITY

        label1 = getResources().getString(R.string.tab_lbl_apps);

        -----
        CREATE FRAGMENT, NAME EACH TAB SO IT IS RECOGNIZABLE FOR SIMPLICITY, TAB MUST BE INSTANTIATED BEFORE IT CAN BE USED
        Fragment TF1 = new TabAccountFragment();
        ActionBar.Tab accountTab = actionBar.newTab();

        -----

        LABEL IS SET TO TAB
        accountTab.setText(label1);

        -----
        TAB LISTENER IS CREATED, ALL TABS MUST HAVE UNIQUE LISTENER CALLBACK OR BUILD WILL NOT COMPLETE
        EACH LISTENER IS INSTANCE OF CLASS TListener
        TListener t1 = new TListener(TF1);

        -----

        TAB LISTENER IS SET AND TAB IS ADDED TO ACTIONBAR
        accountTab.setTabListener(t1);
        actionBar.addTab(accountTab);

        -----
        */
        // INTRO TAB


        Fragment TF_Intro = new TabIntroFragment();
        ActionBar.Tab introTab = actionBar.newTab();
        introTab.setText(label1);
        TListener t_intro = new TListener(TF_Intro);
        introTab.setTabListener(t_intro);
        actionBar.addTab(introTab);

        // ACCOUNTS TAB

        label1 = getResources().getString(R.string.tab_lbl_accounts);
        Fragment TF_Acc = new TabAccountFragment();
        ActionBar.Tab accountTab = actionBar.newTab();
        accountTab.setText(label1);
        TListener t_acc = new TListener(TF_Acc);
        accountTab.setTabListener(t_acc);
        actionBar.addTab(accountTab);

        // APPLICATIONS TAB
        label1 = getResources().getString(R.string.tab_lbl_apps);

        Fragment TF_App = new TabApplicationsFragment();
        ActionBar.Tab appsTab = actionBar.newTab();
        appsTab.setText(label1);
        TListener t_app = new TListener(TF_App);
        appsTab.setTabListener(t_app);
        actionBar.addTab(appsTab);


        // BROWSER TAB
        label1 = getResources().getString(R.string.tab_lbl_browsers);

        Fragment TF_Browser = new TabBrowserFragment();
        ActionBar.Tab browsersTab = actionBar.newTab();
        browsersTab.setText(label1);
        TListener t_browser = new TListener(TF_Browser);
        browsersTab.setTabListener(t_browser);
        actionBar.addTab(browsersTab);

        // CAMERA TAB
        label1 = getResources().getString(R.string.tab_lbl_camera);

        Fragment TF_Camera = new TabCamera();
        ActionBar.Tab cameraTab = actionBar.newTab();
        cameraTab.setText(label1);
        TListener t_camera = new TListener(TF_Camera);
        cameraTab.setTabListener(t_camera);
        actionBar.addTab(cameraTab);

        // GESTURES TAB
        label1 = getResources().getString(R.string.tab_lbl_gestures);

        Fragment TF_Gest = new TabGesturesFragment();
        ActionBar.Tab gesturesTab = actionBar.newTab();
        gesturesTab.setText(label1);
        TListener t_gest = new TListener(TF_Gest);
        gesturesTab.setTabListener(t_gest);
        actionBar.addTab(gesturesTab);


        // SOUNDS TAB
        label1 = getResources().getString(R.string.tab_lbl_sounds);

        Fragment TF_Sound = new TabSoundsFragment();
        ActionBar.Tab soundsTab = actionBar.newTab();
        soundsTab.setText(label1);
        TListener t_sound = new TListener(TF_Sound);
        soundsTab.setTabListener(t_sound);
        actionBar.addTab(soundsTab);


        // WALLPAPER TAB
        label1 = getResources().getString(R.string.tab_lbl_wallpaper);

        Fragment TF_Wallpaper = new TabWallpaperFragment();
        ActionBar.Tab wallTab = actionBar.newTab();
        wallTab.setText(label1);
        TListener t_wall = new TListener(TF_Wallpaper);
        wallTab.setTabListener(t_wall);
        actionBar.addTab(wallTab);

        // SCREEN ICONS TAB
        label1 = getResources().getString(R.string.tab_lbl_screen_icons);

        Fragment TF_Icons = new TabScreenIcons();
        ActionBar.Tab screen_icons = actionBar.newTab();
        screen_icons.setText(label1);
        TListener t_icons = new TListener(TF_Icons);
        screen_icons.setTabListener(t_icons);
        actionBar.addTab(screen_icons);

        // WIFI TAB
        label1 = getResources().getString(R.string.tab_lbl_wifi);

        Fragment TF_Wifi = new TabWifi();
        ActionBar.Tab wifi = actionBar.newTab();
        wifi.setText(label1);
        TListener t_wifi = new TListener(TF_Wifi);
        wifi.setTabListener(t_wifi);
        actionBar.addTab(wifi);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        d.getUserStatus(user);





    }

    public boolean isAcc_complete() {
        d.getUserStatus(user);
        return d.isAcc_complete();
    }

    public void setAcc_complete(boolean acc_complete) {
        this.acc_complete = acc_complete;
        if(acc_complete){
            d.updateTask(user, 2);
        }


        //d.updateTask();
    }

    public boolean isApp_complete() {
        d.getUserStatus(user);
        return d.isApp_complete();
    }

    public void setApp_complete(boolean app_complete) {
        this.app_complete = app_complete;
       if(app_complete){
           d.updateTask(user, 3);
       }
    }

    public boolean isBrowser_complete() {
        d.getUserStatus(user);
        return d.isBrowser_complete();
    }

    public void setBrowser_complete(boolean browser_complete) {
        this.browser_complete = browser_complete;
        if(browser_complete){
            d.updateTask(user, 4);
        }
    }

    public boolean isCam_complete() {
        d.getUserStatus(user);
        return d.isCam_complete();
    }

    public void setCam_complete(boolean cam_complete) {
    this.cam_complete = cam_complete;
      if(cam_complete){
          d.updateTask(user, 5);
      }
    }

    public boolean isGest_complete() {
        d.getUserStatus(user);
        return d.isGest_complete();
    }

    public void setGest_complete(boolean gest_complete) {
        this.gest_complete = gest_complete;
       if(gest_complete){
           d.updateTask(user, 6);
       }
    }

    public boolean isIcon_complete() {
        d.getUserStatus(user);
        return d.isIcon_complete();
    }

    public void setIcon_complete(boolean icon_complete) {
    this.icon_complete = icon_complete;
    if(icon_complete){
        d.updateTask(user, 7);
    }
    }

    public boolean isSound_complete() {
        d.getUserStatus(user);
        return d.isSound_complete();
    }

    public void setSound_complete(boolean sound_complete) {
        this.sound_complete = sound_complete;
      if(sound_complete){
          d.updateTask(user, 8);
      }
    }

    public boolean isWp_complete() {
        d.getUserStatus(user);
        return d.isWp_complete();
    }

    public void setWp_complete(boolean wp_complete) {
        this.wp_complete = wp_complete;
      if(wp_complete){
          d.updateTask(user, 9);
      }
    }

    public boolean isWifi_complete() {
        d.getUserStatus(user);
        return d.isWifi_complete();
    }

    public void setWifi_complete(boolean wifi_complete) {
        this.wifi_complete = wifi_complete;
      if(wifi_complete){
          d.updateTask(user, 10);
      }
    }


    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }


    public void userGrabber() {
        String Fname = "user.txt";
        try {
            int content;
            BufferedReader bR = new BufferedReader(new InputStreamReader(openFileInput(Fname)));
            String fContent = "";
            while ((content = bR.read()) != -1) {
                fContent = fContent + (char) content;
                ;
            }

           setUser(fContent);
            bR.close();
            Log.d("USER IS ", fContent);
        } catch (Exception e) {
            Log.d("ERROR", e.toString());
        }
    }
}


