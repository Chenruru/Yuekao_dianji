package test.bwie.com.yuekao_dianji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text_youxi;
    private ImageView image_tupian;
    private RecyclerView reclyview;
    private boolean aBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_youxi = (TextView) findViewById(R.id.text_youxi);
        image_tupian = (ImageView) findViewById(R.id.image_tupian);
        reclyview = (RecyclerView) findViewById(R.id.reclyview);

        new Okhttp(MainActivity.this,reclyview).getdata();

        image_tupian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,Secondactivity.class);
//                startActivity(intent);


                //点击监听定义一个布尔类型的对象  false是默认的，true是改变的
                if (aBoolean){
                    //设置布局管理器
                    reclyview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    aBoolean=false;
                }else {
                    reclyview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                    aBoolean=true;
                }
            }
        });

    }
}
