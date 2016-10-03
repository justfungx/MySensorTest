package tw.org.iii.mysensortest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by user on 2016/10/3.
 */

public class MyView extends View {
    private float ballX,ballY, ballR;
    private float viewW, viewH;
    private boolean  isInit;
    private Paint paintVLine, paintHLine, paintBall;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.BLACK);
    }

    private void init(){
        viewW = getWidth(); viewH = getHeight();
        ballX = viewW / 2; ballY = viewH/2;
        ballR = 40;

        paintVLine = new Paint();
        paintHLine = new Paint();
        paintBall = new Paint();

        paintVLine.setColor(Color.GREEN);
        paintHLine.setColor(Color.RED);
        paintBall.setColor(Color.YELLOW);

        isInit = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInit) init();

        canvas.drawCircle(ballX,ballY,ballR, paintBall);

        canvas.drawLine(viewW/2,0,viewW/2,viewH, paintVLine);
        canvas.drawLine(0,viewH/2,viewW,viewH/2, paintHLine);

    }


    void setXY(float x, float y){
        ballX = x; ballY = y;
        invalidate();
    }

    float getViewW(){return viewW;}
    float getViewH(){return viewH;}
}