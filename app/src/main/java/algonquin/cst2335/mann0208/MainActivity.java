package algonquin.cst2335.mann0208;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Main activity Class
 * @author Chhavi mann
 * @version 0.1
 */
public class MainActivity extends AppCompatActivity {
    /**
     * text view holder
     */
    private TextView tv;
    /**
     * edit text holder
     */
    private EditText et;
    /**
     * button widget
     */
    private Button btn;

    /**
     * on create method
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);
        btn.setOnClickListener( clk->{
            String password = et.getText().toString();
            if (checkPasswordComplexity(password) !=true){
                tv.setText("You shall not pass!");
            }else {
                tv.setText("Your password meets the requirements");
            }
        });
    }

    /**
     * method to check password complexity
     * @param pw string parameter containing password
     * @return returns true if password meets the requirements
     */
    Boolean checkPasswordComplexity( String pw){
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (Character.isDigit(c)){
                foundNumber = true;
            } else if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else {
                foundSpecial = true;
            }
        }
        if(!foundUpperCase) {
            Toast.makeText(MainActivity.this,"missing upper case letter",Toast.LENGTH_SHORT).show();
            return false;
        } else if( ! foundLowerCase) {
            Toast.makeText(MainActivity.this,"missing lower case letter",Toast.LENGTH_SHORT).show();
            return false;
        } else if( ! foundNumber) {
            Toast.makeText(MainActivity.this,"missing Number",Toast.LENGTH_SHORT).show();
            return false;
        } else if(! foundSpecial) {
            Toast.makeText(MainActivity.this,"missing Special Character",Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    /**
     * method to check if the given character is a special character
     * @param c character of a complex string
     * @return returns true if the character is a special character
     */
    boolean isSpecialCharacter (char c){
        switch (c){
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '!':
            case '@':
            case '?':
                return true;
            default:
                return false;
        }
    }
}