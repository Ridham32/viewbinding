package com.ridhamsharma.viewbinding

import android.app.Dialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ridhamsharma.viewbinding.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUpdate.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.layout_dialog)
            var name= dialog.findViewById<EditText>(R.id.etFillname)
            var rollno = dialog.findViewById<EditText>(R.id.etFillRollno)
            var update = dialog.findViewById<Button>(R.id.btnCustomUpdate)
            dialog.getWindow()?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


            update.setOnClickListener {
                if(name.text.toString().isNullOrEmpty()){
                    name.error="Enter your name"
                }
                else if(rollno.text.toString().isNullOrEmpty()){
                    rollno.error="Enter your rollno"
                }
                else{
                    binding.tvFilledname.text= name.text
                    binding.tvFilledRollno.text=rollno.text
                    dialog.dismiss()
                }

        }
            dialog.show()

        }
        binding.btnDelete.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Delete")
                .setMessage("Do You Want To Delete The Whole Information")
                .setPositiveButton("Yes"){_,_,->
                    Toast.makeText(this, "clicked Yes", Toast.LENGTH_SHORT).show()
                    binding.tvFilledname.text= " name"
                    binding.tvFilledRollno.text=" rollno."
                }
                .setNegativeButton("No"){_,_,->
                    Toast.makeText(this, "clicked No", Toast.LENGTH_SHORT).show()
                }
                .setCancelable(false)
                .show()

        }
    }
}