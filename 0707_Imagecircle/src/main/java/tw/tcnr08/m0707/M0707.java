package tw.tcnr08.m0707;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class M0707 extends AppCompatActivity implements View.OnClickListener {

    private TextView t001;
    private ImageView img01;
    private ImageButton img02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0707);
        setupviewcomponent();

    }

    private void setupviewcomponent() {

        t001 = (TextView) findViewById(R.id.m0707_t001);
         img01= (ImageView) findViewById(R.id.Imageview01);
         img02= (ImageButton) findViewById(R.id.circleImgbutton);

         img01.setOnClickListener(this);
         img02.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.Imageview01:
                t001.setText(getString(R.string.m0707_t001)+(getString(R.string.Imageview01)));
                break;
            case R.id.circleImgbutton:
                t001.setText(getString(R.string.m0707_t001)+(getString(R.string.Imagebutton01)));
                break;


        }



    }
}