package sample.owellsky.net;

import android.app.*;
import android.os.*;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.*;
import android.support.v7.app.*;

public class LogIn extends Activity 
{

	Button b1,b2;
	EditText ed1,ed2;

	TextView tx1;
	int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);
		b1 = (Button)findViewById(R.id.button);
		ed1 = (EditText)findViewById(R.id.editText);
		ed2 = (EditText)findViewById(R.id.editText2);

		
		tx1 = (TextView)findViewById(R.id.textView3);
		tx1.setVisibility(View.GONE);

		b1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if(ed1.getText().toString().equals("admin") &&
					   ed2.getText().toString().equals("admin")) {
						   
						Intent intent = new Intent(LogIn.this,
												   MainActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						startActivity(intent);
						LogIn.this.finish();
						
						Toast.makeText(getApplicationContext(),"Welcome to infiniteVPN",Toast.LENGTH_SHORT).show();
					}else{
						Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

						tx1.setVisibility(View.VISIBLE);
						
						counter--;
						tx1.setText(Integer.toString(counter));

						if (counter == 0) {
							finish();
							b1.setEnabled(false);
							
							
						}
					}
				}
			});
	}
}
