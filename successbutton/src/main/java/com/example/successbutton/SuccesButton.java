package com.example.successbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by nandand on 24/02/17.
 */

public class SuccesButton extends Button implements Button.OnClickListener {
    private int color1 = -1;
    private int color2 = -2;
    private boolean clickFlag = false;

    public SuccesButton(Context context) {
        super(context);
    }

    public SuccesButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        getUserDefinedAttributes(context, attrs, 0);
        init();
    }

    public SuccesButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        getUserDefinedAttributes(context, attrs, defStyle);
        init();
    }


    private void getUserDefinedAttributes(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.successButton, defStyle, 0);
        try {
            color1 = a.getColor(R.styleable.successButton_sb_buttonColor1, 0);
            color2 = a.getColor(R.styleable.successButton_sb_buttonColor2, 0);
        } finally {
            a.recycle();
        }
    }

    private void init() {

        if (color1 != -1)
            setBackgroundColor(color1);

        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!clickFlag) {
            if (color2 != -1) {
                clickFlag = true;
                setBackgroundColor(color2);
            }
        } else {
            if (color1 != -1) {
                clickFlag = false;
                setBackgroundColor(color1);
            }
        }
    }
}
