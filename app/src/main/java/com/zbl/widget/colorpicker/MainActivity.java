package com.zbl.widget.colorpicker;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_color;
    private ColorPickerView colorPickerView;
    private ColorDrawable colorDrawable;

    private static final int INIT_COLOR = 0xFF5CACEE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        iv_color = (ImageView) findViewById(R.id.iv_color);
        colorPickerView = (ColorPickerView) findViewById(R.id.color_picker);
        colorPickerView.setColorPickerListener(new ColorPickerView.ColorPickerListener() {
            @Override
            public void onColorChanging(int color) {
                if (colorDrawable == null) {
                    colorDrawable = new ColorDrawable(color);
                    iv_color.setImageDrawable(colorDrawable);
                } else {
                    colorDrawable.setColor(color);
                }
            }

            @Override
            public void onColorPicked(int color) {

            }
        });

        colorPickerView.setCurrentColor(INIT_COLOR);
        colorDrawable = new ColorDrawable(INIT_COLOR);
        iv_color.setImageDrawable(colorDrawable);
    }
}
