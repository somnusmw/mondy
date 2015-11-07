package com.csdn.helloworld;

import java.io.InputStream;


import org.apache.http.util.EncodingUtils;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView assetsText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        assetsText = (TextView) this.findViewById(R.id.tv_assets);
        assetsText.setText(getFromAssets("test.txt"));
    }

    /**
     * 使用输入流读取文件内容
     * @param filename
     * @return result
     */
    private String getFromAssets(String filename){
    	String result = "";
    	try {
			InputStream in = getResources().getAssets().open(filename);
			int length = in.available();
			
			byte[] buffer = new byte[length];
			in.read(buffer);
			in.close();
			result = EncodingUtils.getString(buffer,"utf-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
		return result;	
    }   
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    } 
    
}
