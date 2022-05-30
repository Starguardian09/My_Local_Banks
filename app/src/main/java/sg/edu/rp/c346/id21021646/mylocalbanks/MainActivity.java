package sg.edu.rp.c346.id21021646.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView viewbankdetails;
    TextView textViewDBS;
    TextView textViewOCBC;
    TextView textViewUOB;
    String wordClicked="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewbankdetails=findViewById(R.id.viewbankdetails);
        textViewDBS=findViewById(R.id.textViewDBS);
        textViewOCBC=findViewById(R.id.textViewOCBC);
        textViewUOB=findViewById(R.id.textViewUOB);
        registerForContextMenu(textViewDBS);
        registerForContextMenu(textViewOCBC);
        registerForContextMenu(textViewUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == textViewDBS) {
            wordClicked = "DBS";
        } else if (v == textViewOCBC) {
            wordClicked = "OCBC";
        } else if (v == textViewUOB) {
            wordClicked = "UOB";
        }
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");


    }
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        public boolean onContextItemSelected (MenuItem item){
            if (wordClicked.equalsIgnoreCase("DBS")) {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    //code for action
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == 1) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800.1111111));
                    startActivity(intentCall);
                    return true;
                }

            }
            else if (wordClicked.equalsIgnoreCase("OCBC")) {
                    if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                        //code for action
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                        startActivity(intent);
                        return true;
                    } else if (item.getItemId() == 1) {
                        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800.3633333));
                        startActivity(intentCall);
                        return true;
                    }
            }
            else if (wordClicked.equalsIgnoreCase("UOB")) {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    //code for action
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == 1) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800.2222121));
                    startActivity(intentCall);
                    return true;
                }
            }
            return super.onContextItemSelected(item);
        }

        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here.
            int id = item.getItemId();
            // if (wordClicked.equalsIgnoreCase("DBS")) {
            if (id == R.id.EnglishSelection) {
                viewbankdetails.setText("All Banks");
                textViewDBS.setText("DBS");
                textViewOCBC.setText("OCBC");
                textViewUOB.setText("UOB");
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                return true;

            } else if (id == R.id.ChineseSelection) {
                viewbankdetails.setText("全部的银行");
                textViewDBS.setText("星展银行");
                textViewOCBC.setText("华侨银行");
                textViewUOB.setText("大华银行");
                Toast.makeText(MainActivity.this, "Chinese is chosen", Toast.LENGTH_SHORT).show();
                return true;

            }else if (id == R.id.KoreanSelection) {
                viewbankdetails.setText("모든 은행");
                textViewDBS.setText("DBS 은행");
                textViewOCBC.setText("OCBC 은행");
                textViewUOB.setText("UOB 은행");
                Toast.makeText(MainActivity.this, "Korea is chosen", Toast.LENGTH_SHORT).show();
                return true;
            }

            return super.onOptionsItemSelected(item);

        }
    }