package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.v4.util.Pair;
import android.test.AndroidTestCase;
import android.widget.Button;

import org.mockito.Mock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by joonheepak on 7/8/16.
 */
public class AsyncTest extends AndroidTestCase
{
    EndpointsAsyncTask task;
    String result;
    @Mock Context mockContext;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        result = null;
        task = new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String joke){

            }
        };
    }
    public void testAsyncReturnType() {

        try{
            task.execute(new Pair<Context, String>(mockContext, "Manfred"));
            result = task.get(10, TimeUnit.SECONDS);
            assertNotNull(result);

        }catch (Exception e){
            fail("Timed out");
        }
    }


}
