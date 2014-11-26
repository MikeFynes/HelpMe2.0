package GesturePack;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import bluebiit.fynes.metropolia.helpme20.R;

public class Ball extends View implements OnTouchListener {

    private Paint mPaint;
    private Point bLocation, rLocation;
    private boolean swap=false ;
    private int bx, by, rx, ry;
    private Bitmap rBitmap = null;
    private Bitmap bBitmap = null;
    private GestureDetector myDetector;


    public Ball(Context context, AttributeSet attrs) {
        super(context, attrs);
        initBall();

    }

    private void initBall() {
        this.setOnTouchListener(this);
        bLocation = new Point(50, 100);
        rLocation = new Point(50, 300);
        myDetector = new GestureDetector(this.getContext(),
                new SimpleOnGestureListener() {
                    public boolean onDoubleTap(MotionEvent e) {
                        if (!swap) {
                            bLocation = new Point(50, 300);
                            rLocation = new Point(50, 100);
                            swap = true;
                        } else {
                            bLocation = new Point(50, 100);
                            rLocation = new Point(50, 300);
                            swap = false;
                        }
                        invalidate();
                        return true;
                    }});

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        rBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rottie);
        bBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.border);

    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
        bx = bLocation.x;
        by =  bLocation.y;
        canvas.drawBitmap(bBitmap, bx, by, mPaint);
        rx = rLocation.x;
        ry =  rLocation.y;
        canvas.drawBitmap(rBitmap, rx, ry, mPaint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        myDetector.onTouchEvent(event);
        return true;
    }
}
