package bluebiit.fynes.metropolia.helpme20;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by mike on 03/10/2014.
 */
public class TabGesturesFragment extends Fragment {
    private View myView;
    private TextView myTv, completed;
    private CharSequence out;


    private Boolean up, down, move;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedState) {
        myView = inflater.inflate(R.layout.content_gestures, container, false);
        setDown(false);
        setUp(false);
        setMove(false);

        completed = (TextView) myView.findViewById(R.id.tv_complete);



        myTv = (TextView) myView.findViewById(R.id.tv);
        myTv.setText(R.string.str);
        myTv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getActionMasked();
                if (action == MotionEvent.ACTION_MOVE) {

                    myTv.setText(getResources().getString(R.string.action_move));
                    setMove(true);
                } else if (action == MotionEvent.ACTION_DOWN) {

                    myTv.setText(getResources().getString(R.string.action_down));
                    setDown(true);
                } else if (action == MotionEvent.ACTION_UP) {

                    myTv.setText(getResources().getString(R.string.action_up));
                    setUp(true);
                }

                if (up == true && down == true && move == true) {
changeCompleted();
                    ((FirstPage)getActivity()).setGest_complete(true);
                }
                else if(((FirstPage)getActivity()).isGest_complete()){
changeCompleted();
                }


                return true;
            }
        });


        return myView;


    }

    public void changeCompleted(){
        completed.setText(getResources().getString(R.string.completed));
        completed.setBackground(getResources().getDrawable(R.color.completed));
    }

/*    @Override
    public void onResume() {
        super.onResume();
        Log.i("I RAN ON RESUME", "I started!!");

        MediaController mp = new MediaController(getActivity());
        final VideoView videoHolder = (VideoView) myView.findViewById(R.id.VideoView);
        videoHolder.setMediaController(mp);
        videoHolder.setVideoURI(Uri.parse("android.resource://bluebiit.fynes.metropolia.helpme20/" + R.raw.gestures2));
        videoHolder.requestFocus();
        videoHolder.start();


    }*/


    public Boolean getUp() {
        return up;
    }

    public void setUp(Boolean up) {
        this.up = up;
    }

    public Boolean getDown() {
        return down;
    }

    public void setDown(Boolean down) {
        this.down = down;
    }

    public Boolean getMove() {
        return move;
    }

    public void setMove(Boolean move) {
        this.move = move;
    }


}