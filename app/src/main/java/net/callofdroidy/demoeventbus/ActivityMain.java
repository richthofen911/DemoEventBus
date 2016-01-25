package net.callofdroidy.demoeventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import de.greenrobot.event.EventBus;

public class ActivityMain extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        findViewById(R.id.btn_to_post_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityMain.this, ActivityPost.class));
            }
        });
    }

    @Override
    public void onDestroy(){
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    // This method will be called when a MessageEvent is posted
    public void onEvent(MessageEvent event){
        Toast.makeText(this, event.message, Toast.LENGTH_SHORT).show();
    }

}