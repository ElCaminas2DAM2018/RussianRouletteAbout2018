package org.ieselcaminas.pmdm.russianrouletteabout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private FrameLayout bangLayout;
    private TextView textBang;
    private Barrel barrel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bangLayout = findViewById(R.id.bangLayout);
        textBang = findViewById(R.id.textViewBang);

        assignActionToReloadButton();

        barrel = findViewById(R.id.barrelLayout);
        barrel.setFireListener(new Barrel.FireListener() {
            @Override
            public void fire(boolean bang) {
                if (bang) {
                    bang();
                }
            }
        });

        Button aboutButton = findViewById(R.id.buttonAbout);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

    }

    private void assignActionToReloadButton() {
        Button reloadButton = findViewById(R.id.buttonReload);
        reloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackground();
                barrel.reset();
            }

            private void resetBackground() {
                bangLayout.setBackgroundColor(
                        getResources().
                                getColor(R.color.colorNoBang));
                textBang.setVisibility(View.INVISIBLE);
            }


        });
    }


    private void bang() {
        bangLayout.setBackgroundColor(getResources().getColor(R.color.colorBang));
        textBang.setVisibility(View.VISIBLE);
    }


}
