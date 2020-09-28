package id.ac.ui.cs.mobileprogramming.activity1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainActivityTest {

    private MainActivity mActivity;

//    public MainActivityTest() {
//        super(MainActivity.class);
//    }
//
//    @Override
//    protected void setUp() throws Exception {
//        mActivity = mActivity.onCreate();
//    }

    @Test
    public void testButtonReturnsString() {
//        mActivity.setContentView();
////
////        Button btn;
////        btn = (Button) mActivity.findViewById(R.id.button);
////        btn.performClick();
////
////        String str;
////        TextView txt;
////        txt = (TextView) mActivity.findViewById(R.id.text);
        mActivity = mActivity.onCreate();
        String str = mActivity.getHelloWorld();

        assertEquals(false, str.equals("Hello World"));
    }
}