package eu.tutorials.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        var nameTxt = findViewById<EditText>(R.id.nameTxt)
        btnStart.setOnClickListener {

            if(nameTxt.text.isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }else{
                val intent:Intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USERNAME, nameTxt.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}