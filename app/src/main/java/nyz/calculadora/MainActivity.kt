package nyz.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import nyz.calculadora.operations.Sum

class MainActivity : AppCompatActivity() {

    private val sum = Sum()
    private lateinit var textInputNumberOne : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //buttons (Sum, Sub, Mult, Div)
        val buttonSum = findViewById<Button>(R.id.ButtonSum)
        val buttonSub = findViewById<Button>(R.id.ButtonSub)
        val buttonMul = findViewById<Button>(R.id.ButtonMul)
        val buttonDiv = findViewById<Button>(R.id.ButtonDiv)

        //textInput
        val textInputNumberOne = findViewById<TextInputEditText>(R.id.TextInputNumberOne)
        val textInputNumbeTwo = findViewById<TextInputEditText>(R.id.TextInputNumbeTwo)

        //result
        val textViewResult = findViewById<TextView>(R.id.TextViewResult)

        //values
        var n1: Double
        var n2: Double

        //click event
        buttonSum.setOnClickListener {
            n1 = textInputNumberOne.text.toString().toDouble()
            n2 = textInputNumbeTwo.text.toString().toDouble()
            textViewResult.text = sum.operation(n1, n2).toString()
        }//fim event
    } //fim do onCreate
} //fim da class