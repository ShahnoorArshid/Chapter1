package com.example.spinneractivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Dialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        val btn=findViewById<Button>(R.id.btnDialog1)
        val btn1=findViewById<Button>(R.id.btnDialog2)
        val btn2=findViewById<Button>(R.id.btnDialog3)
        val btn3=findViewById<Button>(R.id.btnnxt)
        val addContactDialog=AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do You Want To Add Mr.Zain To Your Contact? ")
            .setIcon(R.drawable.ic_personadd)
            .setPositiveButton("YES"){ _,_ ->
                Toast.makeText(this, "You Added Mr,Zain To Your Contact List", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("NO"){ _,_ ->
                Toast.makeText(this, "You Didn't Add Mr,Zain To Your Contact List", Toast.LENGTH_SHORT).show()
            }.create()
        btn.setOnClickListener {
            addContactDialog.show()
        }
        val options= arrayOf("First Item","Second Item","Third Item")
        val singleChoiceDial0g=AlertDialog.Builder(this)
            .setTitle("Choose One Of These Options")
            .setSingleChoiceItems(options,0) { _, i ->
                Toast.makeText(this, "You Clicked On ${options[i]}", Toast.LENGTH_SHORT).show()
            }
                    .setPositiveButton("Accept"){ _,_ ->
                        Toast.makeText(this, "You Accepted The singlechoicedialog", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("Decline"){ _,_ ->
                        Toast.makeText(this, "You Declined The singlechoicedialog", Toast.LENGTH_SHORT).show()
                    }.create()
                btn1.setOnClickListener {singleChoiceDial0g.show()
                   }
        val MultiChoiceDial0g=AlertDialog.Builder(this)
            .setTitle("Choose One Of These Options")
            .setMultiChoiceItems(options,booleanArrayOf(false,false,false)) { _, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "You Checked On ${options[i]}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You Unchecked On ${options[i]}", Toast.LENGTH_SHORT)
                        .show()

                }
            }
            .setPositiveButton("Accept"){ _,_ ->
                Toast.makeText(this, "You Accepted The multichoicedialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){ _,_ ->
                Toast.makeText(this, "You Declined The multchoicedialog", Toast.LENGTH_SHORT).show()
            }.create()
        btn2.setOnClickListener {MultiChoiceDial0g.show()
        }
        btn3.setOnClickListener {val int=Intent(this,Timepickerdialog::class.java)
            startActivity(int)
            finish()

        }
           


            }


    }
