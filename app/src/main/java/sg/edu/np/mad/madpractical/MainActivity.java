package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String title= "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User();
        user.followed = false; //set the variable

        //Button Control
        Button follow = findViewById(R.id.button);
        follow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (user.followed == false) { //on click, when variable is false,
                    follow.setText("UNFOLLOW"); //set text to unfollow
                    user.followed = true; //set variable to true
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_LONG).show();
                }
                else {
                    follow.setText("FOLLOW");
                    user.followed = false;
                    Toast.makeText(getApplicationContext(), "Unfollow", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    protected void onResume(){
        super.onResume();
        Log.v(title,"On Resume!");
        Intent myRecvIntent = getIntent();
        int num = myRecvIntent.getIntExtra("randomNumber",0);
        TextView myMessage = findViewById(R.id.textView);
        myMessage.setText("MAD " + num);
    }
}
