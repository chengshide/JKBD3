package com.example.administrator.jkbd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.jkbd.R;
import com.example.administrator.jkbd.bean.Question;
import com.example.administrator.jkbd.bean.item;
import com.example.administrator.jkbd.utils.OkHttpUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test(View view) {
        OkHttpUtils<item> utils=new OkHttpUtils<>(getApplicationContext());
        String uri="http://101.251.196.90:8080/JztkServer/examInfo";
        utils.url(uri)
                .targetClass(item.class)
                .execute(new OkHttpUtils.OnCompleteListener<item>(){

                    @Override
                    public void onSuccess(item result) {
                        Log.e("main","result="+result);

                    }

                    @Override
                    public void onError(String error) {
                        Log.e("main","error="+error);

                    }
                });
        startActivity(new Intent(MainActivity.this,ExamActivity.class));
    }

    public void exit(View view) {
        finish();
    }
}
