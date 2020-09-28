package id.ac.ui.cs.mobileprogramming.activity1;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.view.Inflater;

import androidx.appcompat.app.AppCompatActivity;

import static id.ac.ui.cs.mobileprogramming.activity1.R.id.text;

public class MainActivity extends AppCompatActivity {

    ViewGroup tContainer;
    TextView txt;
    Button switchBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tContainer = findViewById(R.id.transitionContainer);
        txt = findViewById(text);
        switchBtn = findViewById(R.id.button);

        switchBtn.setOnClickListener(new View.OnClickListener() {
            boolean visible;

            @Override
            public void onClick(View v) {
                visible = !visible;
                txt.setVisibility(visible ? View.VISIBLE: View.INVISIBLE);
            }
        });
    }

    public String getHelloWorld() {
        final String string = getString(text);
        return string;
    }
}