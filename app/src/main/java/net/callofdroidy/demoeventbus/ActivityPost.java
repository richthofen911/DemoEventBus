package net.callofdroidy.demoeventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import de.greenrobot.event.EventBus;

public class ActivityPost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        findViewById(R.id.btn_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("Event posted from ActivityPost"));
            }
        });
    }


}
