package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.widget.Button;

import org.mockito.Mock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by joonheepak on 7/8/16.
 */
public class AsyncTest extends AndroidTestCase {
    MainActivityFragment.EndpointsAsyncTask task;
    String result;
    @Mock
    Context mockContext;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        result = null;
        task = new MainActivityFragment.EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String joke){
                //No need to launch intent, so override this method
            }
        };
    }
    public void testAsyncReturnType() {

        try{

            //Default timeout for the GCM server is 20 seconds
            //If the .get can't get the result in 10 seconds, something is wrong anyway
            //Greater than 20 seconds results in an error string returned and requires further interpretation
            task.execute((Runnable) mockContext);
            result = task.get(10, TimeUnit.SECONDS);
            assertNotNull(result);

        }catch (Exception e){
            fail("Timed out");
        }
    }


}
