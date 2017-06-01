package test.bwie.com.yuekao_dianji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Secondactivity extends AppCompatActivity {
    private TextView text_youxi2;
    private ImageView image_tupian2;
    private RecyclerView reclyview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        text_youxi2 = (TextView) findViewById(R.id.text_youxi2);
        image_tupian2 = (ImageView) findViewById(R.id.image_tupian2);
        reclyview2 = (RecyclerView) findViewById(R.id.reclyview2);
        new Okhttp(Secondactivity.this,reclyview2).getdata();
        image_tupian2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Secondactivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
