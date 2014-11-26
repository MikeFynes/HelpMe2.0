package bluebiit.fynes.metropolia.helpme20;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by mike on 03/10/2014.
 */
public class TabSoundsFragment extends Fragment {
    private View myView;
    private TextView sound_details1, sound_details2, completed;

    private SeekBar volumeControl;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedState) {
        myView = inflater.inflate(R.layout.content_sounds, container, false);
        volumeControl = null;
        volumeControl = (SeekBar) myView.findViewById(R.id.volume_bar);
        final TextView seekBarValue = (TextView) myView.findViewById(R.id.volume_bar_value);
        completed = (TextView) myView.findViewById(R.id.tv_complete);

        sound_details1 = (TextView) myView.findViewById(R.id.detail_sound1);
        sound_details2 = (TextView) myView.findViewById(R.id.detail_sound2);
        sound_details1.setText(R.string.detail_sound1);
        sound_details2.setText(R.string.detail_sound2);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                seekBarValue.setText(String.valueOf(progress));
                if (progress == 100) {
                    completed.setText(getResources().getString(R.string.completed));
                    completed.setBackground(getResources().getDrawable(R.color.completed));
                    ((FirstPage)getActivity()).setSound_complete(true);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return myView;


    }

}
