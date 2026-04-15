package au.edu.swin.sdmd.w03_calculations

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val opGroup = findViewById<RadioGroup>(R.id.OperatorChoice)
        val operationLabel = findViewById<TextView>(R.id.Op_Label)
        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
// This triggers every time a different radio button is clicked
        opGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.Radio_Subt -> operationLabel.text = "-"
                R.id.Radio_Mult -> operationLabel.text = "×"
                else -> operationLabel.text = "+"
            }
        }
        val equals = findViewById<Button>(R.id.equals)
            equals.setOnClickListener {
                val val1 = number1.text.toString().toIntOrNull() ?: 0
                val val2 = number2.text.toString().toIntOrNull() ?: 0

                // Look at the RadioGroup to see which ID is currently checked
                val result = when (opGroup.checkedRadioButtonId) {
                    R.id.Radio_Subt -> subtract(val1, val2)
                    R.id.Radio_Mult -> multiply(val1, val2)
                    else -> add(val1, val2) // Defaults to add if radioAdd is selected
                }

                // Task 3: It's better to show the result in a TextView than on the button itself!
                val answerText = findViewById<TextView>(R.id.answer)
                answerText.text = result.toString()
            }
    }

    // math functions
    private fun add(a: Int, b: Int) = a + b
    private fun subtract(a: Int, b: Int) = a - b
    private fun multiply(a: Int, b: Int) = a * b

}