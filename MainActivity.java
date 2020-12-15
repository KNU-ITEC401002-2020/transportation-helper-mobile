package com.example.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final int TYPE_WIFI = 1;
    public static final int TYPE_MOBILE = 2;
    public static final int TYPE_NOT_CONNECTED = 3;

    public static int getConnectivityStatus(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo != null){
            int type = networkInfo.getType();
            if(type == ConnectivityManager.TYPE_MOBILE){
                return TYPE_MOBILE;
            }else if(type == ConnectivityManager.TYPE_WIFI){
                return TYPE_WIFI;
            }
        }
        return TYPE_NOT_CONNECTED;
    }

    int [] ImageId = {R.drawable.graybell, R.drawable.redbell};
    ImageView iv;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView)findViewById(R.id.imageView1);

        iv.setOnClickListener(new MyListener());

        textView = findViewById(R.id.textView);

        Button imageButton = (Button) findViewById(R.id.settings);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), settings.class);
                startActivity(intent);
            }
        }); // end intent

    } // end onCreate

    class MyListener implements View.OnClickListener {
        int i = 0;
        int length = ImageId.length;


        @Override
        public void onClick(View v){
            iv.setImageResource(ImageId[i]);

            i+=1;
            if(i == ImageId.length) i = 0;

            int status = getConnectivityStatus(getApplicationContext());
            if(status == TYPE_MOBILE){
                textView.setText("Wi-Fi에 연결되지 않았습니다.");
            }else if (status == TYPE_WIFI){
                textView.setText("");
            }else {
                textView.setText("Wi-Fi에 연결되지 않았습니다.");
            }


        } // end onClick

    } // end MyListener()

} // end Class
