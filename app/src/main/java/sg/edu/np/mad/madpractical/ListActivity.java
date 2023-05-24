package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    final String title= "List Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(title,"On Resume!");
        ImageView myImage = findViewById(R.id.imageView);
        myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileAlert();
            }
        });
    };
    private void profileAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("MADness").setCancelable(false);
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Log.v(title,"View");
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("randomNumber",randomNo());
                startActivity(intent);
            }
        });
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Log.v(title,"Close");
                finish();
            }
        });
        AlertDialog alert= builder.create();
        alert.setTitle("Profile");
        alert.show();

    }
    public int randomNo() {
        Random ran = new Random();
        int myRandomNumber = ran.nextInt(100000);
        return myRandomNumber;
    }
}