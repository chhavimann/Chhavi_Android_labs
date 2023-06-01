package algonquin.cst2335.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import algonquin.cst2335.mann0208.databinding.ActivityMainBinding;
import algonquin.cst2335.data.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel model;
    private ActivityMainBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initialize
        model = new ViewModelProvider(this).get(MainViewModel.class);
        //this has all the ids predefined
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());


        variableBinding.mybutton.setOnClickListener(click ->
        {
            variableBinding.textview.setText("Your edit text has " +variableBinding.myedittext.getText()+"");
        });
        variableBinding.mySwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });
        variableBinding.myradio.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });
        variableBinding.myCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });
        model.isSelected.observe(this, selected -> {
                variableBinding.myCheckbox.setChecked(selected);
                variableBinding.myradio.setChecked(selected);
                variableBinding.mySwitch.setChecked(selected);
                CharSequence text = "\" The value is now: \" " + selected;
                        int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(this /* MyActivity */, text, duration);
                toast.show();
            });
        variableBinding.imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int width = variableBinding.imgbutton.getWidth();
                int height = variableBinding.imgbutton.getHeight();
                String toastMessage = "The width = " + width + " and height = " + height;
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();

            }
        });
    }

    }





