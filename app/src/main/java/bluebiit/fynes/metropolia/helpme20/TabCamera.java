package bluebiit.fynes.metropolia.helpme20;

import android.app.Fragment;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mike on 03/10/2014.
 */
public class TabCamera extends Fragment {
private ImageView cameraView;
private TextView completed;
    View myView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedState) {
        myView = inflater.inflate(R.layout.content_camera, container, false);
        cameraView = (ImageView) myView.findViewById(R.id.camera_preview);
        cameraView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open();
            }
        });

        completed = (TextView) myView.findViewById(R.id.tv_complete);
if(   ((FirstPage)getActivity()).isCam_complete()){
    changeCompleted();
}


        return myView;

    }

    public void open() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
        ((FirstPage)getActivity()).setCam_complete(true);

    }

    public void changeCompleted(){
        completed.setText(getResources().getString(R.string.completed));
        completed.setBackground(getResources().getDrawable(R.color.completed));
    }


}

