package helloworld.demo.com.stockapplication;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //OBJECTS CREATION
    EditText editItemNo,editItem,editVariant,editInventory,editPrice1,editPrice2;
    Button btnAddData;
    DatabaseHelper myDb;
    Button btnViewAll;
    Button btnDelete;
    Button btnViewUpdate;
    Button btnClearAll;
    Button btnRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);


        //REFERENCE ID
        editItemNo = (EditText) findViewById(R.id.edt1);
        editItem = (EditText) findViewById(R.id.edt2);
        editVariant = (EditText) findViewById(R.id.edt3);
        editInventory = (EditText) findViewById(R.id.edt4);
        editPrice1 = (EditText) findViewById(R.id.edt5);
        editPrice2 = (EditText) findViewById(R.id.edt6);
        btnAddData = (Button) findViewById(R.id.submit);
        btnViewAll = (Button) findViewById(R.id.view);
        btnViewUpdate = (Button) findViewById(R.id.update);
        btnDelete = (Button) findViewById(R.id.delete);
        btnClearAll = (Button) findViewById(R.id.clear);
        btnRecyclerview = (Button) findViewById(R.id.list);


        //CALLING METHOD SETONCLICKLISTENER
        btnClearAll.setOnClickListener(this);
        btnAddData.setOnClickListener(this);
        btnViewAll.setOnClickListener(this);
        btnViewUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);


        btnRecyclerview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                android.content.Intent intent = new android.content.Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    //ONCLICK METHOD DECLARATION
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:
                addData();
                break;
            case R.id.view:
                viewAll();
                break;
            case R.id.update:
                updateData();
                break;
            case R.id.delete:
                deleteData();
                break;
            case R.id.clear:
                clearAll();
                break;

        }

    }

    //TO CLEAR EDIT TEXT FIELD
    public void clearAll() {
        editItemNo.setText("");
        editItem.setText("");
        editVariant.setText("");
        editInventory.setText("");
        editPrice1.setText("");
        editPrice2.setText("");
        Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show();
    }

    public void addData() {
        //TOAST OPERATIONS
        if (editItemNo.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter item no", Toast.LENGTH_SHORT).show();
        } else if (editItem.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter item", Toast.LENGTH_SHORT).show();
        } else if (editVariant.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter variant", Toast.LENGTH_SHORT).show();
        } else if (editInventory.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter inventory", Toast.LENGTH_SHORT).show();
        } else if (editPrice1.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter price1", Toast.LENGTH_SHORT).show();
        } else if (editPrice2.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter price2", Toast.LENGTH_SHORT).show();
        }
        else {
            //CALLING METHOD OF DATABASE HELPER CLASS
            String itemNo = myDb.checkItemNo(editItemNo.getText().toString());
            if (itemNo == null) {
                boolean isInserted = myDb.insertData(new Contact(null,
                        editItemNo.getText().toString(),
                        editItem.getText().toString(),
                        editVariant.getText().toString(),
                        editInventory.getText().toString(),
                        editPrice1.getText().toString(),
                        editPrice2.getText().toString()));
                //TOAST OPERATIONS
                if (isInserted)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "ItemNo already Inserted", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void updateData() {
        //TOAST OPERATIONS
        if (editItemNo.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter item no", Toast.LENGTH_SHORT).show();
        } else if (editItem.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter item", Toast.LENGTH_SHORT).show();
        } else if (editVariant.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter variant", Toast.LENGTH_SHORT).show();
        } else if (editInventory.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter inventory", Toast.LENGTH_SHORT).show();
        } else if (editPrice1.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter price1", Toast.LENGTH_SHORT).show();
        } else if (editPrice2.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter price2", Toast.LENGTH_SHORT).show();
        } else {
            //CALLING METHOD OF DATABASE HELPER CLASS
            boolean isUpdate = myDb.updateData(new Contact(null,
                    editItemNo.getText().toString(),
                    editItem.getText().toString(),
                    editVariant.getText().toString(),
                    editInventory.getText().toString(),
                    editPrice1.getText().toString(),
                    editPrice2.getText().toString()));
            //TOAST OPERATIONS
            if (isUpdate)
                Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
        }
    }

    public void deleteData() {
        //TOAST OPERATIONS
        if (editItemNo.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter item no", Toast.LENGTH_SHORT).show();
        } else {
            //CALLING METHOD OF DATABASE HELPER CLASS
            Integer deletedRows = myDb.deleteData(editItemNo.getText().toString());
            //TOAST OPERATIONS
            if (deletedRows > 0)
                Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
        }
    }

    public void viewAll() {
        //TOAST OPERATIONS
        if (editItemNo.getText().toString().length() == 0) {
            Toast.makeText(MainActivity.this, "Enter item no", Toast.LENGTH_SHORT).show();
        } else {
            //CALLING METHOD OF DATABASE HELPER CLASS

            Contact contact = myDb.getContact(editItemNo.getText().toString());
            //TOAST OPERATIONS
            if (contact.getItemNo() != null) {
                editItem.setText(contact.getItem());
                editVariant.setText(contact.getVariant());
                editInventory.setText(contact.getInventory());
                editPrice1.setText(contact.getPrice1());
                editPrice2.setText(contact.getPrice2());
                Toast.makeText(this, "Data retrieved successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }
}





















