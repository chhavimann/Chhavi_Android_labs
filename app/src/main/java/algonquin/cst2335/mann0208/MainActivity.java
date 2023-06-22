package algonquin.cst2335.mann0208;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The MainActivity class extending AppCompatActivity Class
 * @author Chhavi Mann
 * @version 1/0
 */
public class MainActivity extends AppCompatActivity {

    private TextView tv = null;
    private EditText et = null;
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();
            checkPasswordComplexity(password);
        });
    }

    /**
     * This function checks the requirements of a password
     *
     * @param pw The String object that we are checking
     * @return Returns true if the password qualifies the requirements
     */
    boolean checkPasswordComplexity(String pw) {
        boolean foundUpperCase = false;
        boolean foundLowerCase = false;
        boolean foundNumber = false;
        boolean foundSpecial = false;

        for (char c : pw.toCharArray()) {
            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }

        if (!foundUpperCase) {
            Toast.makeText(MainActivity.this, "Missing an uppercase letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(MainActivity.this, "Missing a lowercase letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(MainActivity.this, "Missing a number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(MainActivity.this, "Missing a special character", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    boolean isSpecialCharacter(char c) {
        switch (c) {
            case '#':
            case '?':
            case '*':
                return true;
            default:
                return false;
        }
    }
}
