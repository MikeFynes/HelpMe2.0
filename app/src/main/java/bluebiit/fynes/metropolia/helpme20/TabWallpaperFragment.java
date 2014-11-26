package bluebiit.fynes.metropolia.helpme20;

import android.app.Fragment;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by mike on 03/10/2014.
 */
public class TabWallpaperFragment extends Fragment {
    private View myView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedState) {
        myView = inflater.inflate(R.layout.content_wallpaper, container, false);


        return myView;


    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("I RAN ON RESUME", "I started!!");

        MediaController mp = new MediaController(getActivity());
        final VideoView videoHolder = (VideoView) myView.findViewById(R.id.VideoView);
        videoHolder.setMediaController(mp);
        videoHolder.setVideoURI(Uri.parse("android.resource://bluebiit.fynes.metropolia.helpme20/" + R.raw.wallpaper2));
        videoHolder.requestFocus();
        videoHolder.start();

        videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                ((FirstPage)getActivity()).setWp_complete(true);
                Context context = getActivity();
                CharSequence text = "Task completed!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


            }
        });
    }
}