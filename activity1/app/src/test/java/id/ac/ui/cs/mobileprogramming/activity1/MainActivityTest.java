package id.ac.ui.cs.mobileprogramming.activity1;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainActivityTest {

    private MainActivity mActivity;

    @Test
    public void testButtonReturnsString() {
        mActivity = new MainActivity();
        Button btn;
        btn = (Button) mActivity.findViewById(R.id.button);
        btn.performClick();

        String str;
        TextView txt;
        txt = (TextView) mActivity.findViewById(R.id.text);
        str = txt.toString();

        assertEquals(false, str.equals("Hello World!"));
    }
}