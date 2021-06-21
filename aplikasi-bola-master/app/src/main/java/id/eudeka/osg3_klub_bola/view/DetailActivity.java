package id.eudeka.osg3_klub_bola.view;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.educa62.osg3_klub_bola.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.detail_tim);
            TextView t = (TextView) findViewById(R.id.tv_NamaTim);
            ImageView iv = (ImageView) findViewById(R.id.imageView);
            TextView d = (TextView) findViewById(R.id.strdeskripsi);

            Bundle bundle=getIntent().getExtras();

            String s=bundle.getString("name");
            String lok=bundle.getString("gambar");
            String desc=bundle.getString("deskripsi");

            d.setText(desc);
            t.setText(s);

            Picasso.get().load(lok).into(iv);
        }

}
