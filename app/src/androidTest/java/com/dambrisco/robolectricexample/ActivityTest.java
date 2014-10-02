package com.dambrisco.robolectricexample;

import android.app.Activity;
import android.widget.TextView;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;
import org.robolectric.util.ActivityController;

/**
 * Brief file description goes here.
 *
 * @author dambrisco@itriagehealth.com
 * @since 2014-10-01
 */
@Config(manifest = "./src/main/AndroidManifest.xml", emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class ActivityTest {
    @Test
    public void testExampleActivity() {
        ActivityController<ExampleActivity> activityController = Robolectric.buildActivity(ExampleActivity.class);
        Activity activity = activityController.create().visible().get();

        TextView tv = (TextView) activity.findViewById(R.id.hello_world);
        String text = tv.getText().toString();
        Assert.assertTrue(text.equals(activity.getString(R.string.hello_world)));

        tv.performClick();
        text = ShadowToast.getTextOfLatestToast();
        Assert.assertTrue(text.equals(activity.getString(R.string.hello_world)));
    }
}
