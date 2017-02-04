package lokeshsaini.authenticationsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.accountkit.AccountKit;
import com.digits.sdk.android.Digits;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = String.valueOf(R.string.twitter_key);
    private static final String TWITTER_SECRET = String.valueOf(R.string.twitter_secret);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits.Builder().build());

        AccountKit.initialize(getApplicationContext());

        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.account_kit);
        Button button2 = (Button) findViewById(R.id.digits);
        Button button3 = (Button) findViewById(R.id.firebase_referral);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.account_kit:
                Intent intent1 = new Intent(this, FBAccountKitActivity.class);
                startActivity(intent1);
                break;
            case R.id.digits:
                Intent intent2 = new Intent(this, DigitsActivity.class);
                startActivity(intent2);
                break;
            case R.id.firebase_referral:
                Intent intent3 = new Intent(this, FirebaseReferralActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
