package sg.edu.rp.c346.id20019652.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDbs;
    TextView tvOcbc;
    TextView tvUob;
    int textChoice;
    //WebView webView;
    String viewSelected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs = findViewById(R.id.textViewDBS);
        tvOcbc = findViewById(R.id.textViewOCBC);
        tvUob = findViewById(R.id.textViewUOB);
        /*webView = findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);

        webView.loadUrl("http://www.soccernet.com");
        webView.setWebViewClient(new WebViewClient());*/

        registerForContextMenu(tvDbs);
        registerForContextMenu(tvOcbc);
        registerForContextMenu(tvUob);

        tvDbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textChoice = 1;
                openContextMenu(tvDbs);
            }
        });
        tvOcbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textChoice = 2;
                openContextMenu(tvOcbc);
            }
        });
        tvUob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textChoice = 3;
                openContextMenu(tvUob);
            }
        });
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website 网站");
        menu.add(0, 1, 1, "Contact the bank 联系银行");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.englishSelection) {
            tvDbs.setText("DBS");
            tvOcbc.setText("OCBC");
            tvUob.setText("UOB");
            return true;

        } else if (id == R.id.chineseSelection) {
            tvDbs.setText("星展银行");
            tvOcbc.setText("华侨银行");
            tvUob.setText("大华银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (textChoice == 1 && item.getItemId() == 0) {
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
            startActivity(intent);
        } else if (textChoice == 1 && item.getItemId() == 1) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18001111111L));
            startActivity(intentCall);
        } else if (textChoice == 2 && item.getItemId() == 0) {
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
            startActivity(intent);
        } else if (textChoice == 2 && item.getItemId() == 1) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18003633333L));
            startActivity(intentCall);
        } else if (textChoice == 3 && item.getItemId() == 0) {
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.uob.com.sg"));
            startActivity(intent);
        } else if (textChoice == 3 && item.getItemId() == 1) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18002222121L));
            startActivity(intentCall);
        }
        return super.onContextItemSelected(item);
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}