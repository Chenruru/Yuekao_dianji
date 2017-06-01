package test.bwie.com.yuekao_dianji;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * date: 2017/5/27
 * author:陈茹
 * 类的用途:
 */

public class Okhttp {


    private String path = "http://news-at.zhihu.com/api/4/themes";

    private String dataa;
    private List<Userbean.OthersBean> others;

    private Context context;
    private RecyclerView reclyview;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                String obj = (String) msg.obj;
                //设置布局管理器
                reclyview.setLayoutManager(new LinearLayoutManager(context));
                //设置适配器
                Myreclerviewadapter myreclerviewadapter=new Myreclerviewadapter(context,others);
                reclyview.setAdapter(myreclerviewadapter);
            }
        }
    };

    public Okhttp(Context context, RecyclerView reclyview){
        this.context=context;
        this.reclyview=reclyview;

    }



    public String getdata() {


        OkHttpClient mOkHttpClient = new OkHttpClient();

        //创建一个request
        Request mRequest = new Request.Builder().url(path).build();
        //new call
        //通过request的对象去构造得到一个call对象
        Call call = mOkHttpClient.newCall(mRequest);
        call.enqueue(new Callback() {



            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response!=null){

                    dataa =  response.body().string();
                    Gson gson = new Gson();
                    Userbean userbean = gson.fromJson(dataa, Userbean.class);
                    others = userbean.getOthers();

                    Log.e("name",dataa);

                    Message message=new Message();
                    message.obj=dataa;
                    message.what=0;

                    handler.sendMessage(message);
                }
            }
        });


      return dataa;
    }




}

