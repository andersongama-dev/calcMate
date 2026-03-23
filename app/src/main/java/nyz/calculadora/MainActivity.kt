package nyz.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import nyz.calculadora.model.Values
import nyz.calculadora.operations.Calculate
import nyz.calculadora.utils.Validate

class MainActivity : AppCompatActivity() {

    private val calculate = Calculate() //function sum
    private val validate = Validate()

    //result
    private val textViewResult by lazy { findViewById<TextView>(R.id.TextViewResult) }

    //textInput var
    private val textInputNumberOne by lazy { findViewById<TextInputEditText>(R.id.TextInputNumberOne) }
    private val textInputNumberTwo by lazy { findViewById<TextInputEditText>(R.id.TextInputNumbeTwo) }

    private fun getValues(): Values {
        val n1Text = textInputNumberOne.text.toString()
        val n2Text = textInputNumberTwo.text.toString()

        if(!validate.isNull(n1Text, n2Text)) {
            textInputNumberOne.error = getString(R.string.error_required_fild)
            textInputNumberTwo.error = getString(R.string.error_required_fild)
            Toast.makeText(this, getString(R.string.error_required_fild), Toast.LENGTH_SHORT).show()
            return Values(value1 = 0.0, value2 = 0.0)
        }

        val n1 = n1Text.toDouble()
        val n2 = n2Text.toDouble()

        val values = Values(value1 = n1, value2 = n2)

        return values
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //click event sum
        findViewById<Button>(R.id.ButtonSum).setOnClickListener {
            val values = getValues()
            textViewResult.text = String.format("%s", calculate.sum(values.value1, values.value2))
        }//fim event

        //click event sub
        findViewById<Button>(R.id.ButtonSub).setOnClickListener {
            val values = getValues()
            textViewResult.text = String.format("%s", calculate.sub(values.value1, values.value2))
        }//fim event

        //click event sub
        findViewById<Button>(R.id.ButtonSub).setOnClickListener {
            val values = getValues()

            textViewResult.text = String.format("%s", calculate.sub(values.value1, values.value2))
        }//fim event

        //click event mul
        findViewById<Button>(R.id.ButtonMul).setOnClickListener {
            val values = getValues()
            textViewResult.text = String.format("%s", calculate.mul(values.value1, values.value2))
        }//fim event

        //click event div
        findViewById<Button>(R.id.ButtonDiv).setOnClickListener {
            val values = getValues()
            textViewResult.text = String.format("%s", calculate.div(values.value1, values.value2))
        }//fim event
    } //fim do onCreate
} //fim da class