package dennies.anwar.mylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etEdit;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etEdit = findViewById(R.id.etEdit);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        etEdit.setText(getIntent().getStringExtra(MainActivity.Key_Item_Text));
        // When the user is done editing, they click the save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent which will contain the results
                Intent intent = new Intent();
                // Pass the data
                intent.putExtra(MainActivity.Key_Item_Text, etEdit.getText().toString());
                intent.putExtra(MainActivity.Key_Item_Position, getIntent().getExtras().getInt(MainActivity.Key_Item_Position));
                // Set the result of the intent
                setResult(RESULT_OK, intent);
                // Finish the activity, close the screen and go back
                finish();
            }
        });
    }
}