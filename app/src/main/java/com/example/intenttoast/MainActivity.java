package com.example.intenttoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callNumber(View view) {
        Uri uri = Uri.parse("tel:+923001234567");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    public void sendEmail(View view) {
        Intent intent = new Intent();
        intent.setType("text/plain");
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"aa@pucit.edu.pk", "bb@pucit.edu.pk"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
        intent.putExtra(Intent.EXTRA_TEXT, "message");
        startActivity(intent);
    }

    public void openWebsite(View view) {
        String url = "https://github.com/anas1590/";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "Hello! I'm Toast", Toast.LENGTH_LONG);
        toast.show();
    }

    public void showCustomizedToast(View view) {
        setContentView(R.layout.toast_layout);
        view = LayoutInflater.from(MainActivity.this).inflate(R.layout.toast_layout, null);
        Toast toast = new Toast(MainActivity.this);
        TextView tvMessage = view.findViewById(R.id.textView3);
        tvMessage.setText("Toast is Showing");
        toast.setView(view);
        toast.show();
    }

}