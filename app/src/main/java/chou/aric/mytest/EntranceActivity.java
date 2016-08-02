package chou.aric.mytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import chou.aric.mytest.view.MoveAbleView;

public class EntranceActivity extends AppCompatActivity {
    private MoveAbleView moveAbleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
        moveAbleView = (MoveAbleView) findViewById(R.id.mv);
    }


}
