package com.example.experiment1;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick1(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("这是一个对话框")
                .setTitle("提示");

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {//确定操作的按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"确认",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {//取消操作的按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {//忽略操作的按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"忽略",Toast.LENGTH_LONG).show();
            }
        });

        builder.show();
    }


    public void onClick2(View view) {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
        final LinearLayout tableLayout=(LinearLayout)getLayoutInflater().inflate(R.layout.login, null) ;
        builder1.setView(tableLayout)
                .setTitle("登录")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText userid =(EditText) tableLayout.findViewById(R.id.EditTextUserID);
                        Log.d("MainActity","id2:"+userid);
                        String name =userid.getText().toString();
                        Log.d("MainActity","name:"+name);
                        EditText pwd =(EditText) tableLayout.findViewById(R.id.EditTextPwd);
                        String pass =pwd.getText().toString();
                        Log.d("MainActity","pass:"+pass);
                        if("abc".equals(name)&&"123".equals(pass))
                            Toast.makeText(MainActivity.this, name +"恭喜您登陆成功!",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, name + "很遗憾您登录失败！",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick (DialogInterface dialog, int id) {
                        //cancel
                        Toast.makeText(MainActivity.this,"取消登录",Toast.LENGTH_SHORT).show();
                    }
                });
        builder1.show();
    }




}


