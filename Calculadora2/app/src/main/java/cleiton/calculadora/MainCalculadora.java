package cleiton.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainCalculadora extends Activity {

    private EditText ednum1;
    private EditText ednum2;
    private TextView edsoma;
    private Button btsoma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        ednum1 = (EditText) findViewById(R.id.ednum1);
        ednum2 = (EditText) findViewById(R.id.ednum2);
        edsoma = (TextView) findViewById(R.id.edsoma);
        btsoma = (Button) findViewById(R.id.btsoma);
    }


    public void facaSoma(View v){
        double resultSoma;
        resultSoma = Double.valueOf(ednum1.getText().toString()) + Double.valueOf(ednum2.getText().toString());

        edsoma.setText(String.valueOf(resultSoma));
    }

    public void facaMenos(View v){
        double resultMenos;
        resultMenos = Double.valueOf(ednum1.getText().toString()) - Double.valueOf(ednum2.getText().toString());

        edsoma.setText(String.valueOf(resultMenos));
    }

    public void facaDiv(View v){
        double resultDiv;
        resultDiv = Double.valueOf(ednum1.getText().toString()) / Double.valueOf(ednum2.getText().toString());

        edsoma.setText(String.valueOf(resultDiv));
    }

    public void facaMult(View v){
        double resultMult;
        resultMult = Double.valueOf(ednum1.getText().toString()) * Double.valueOf(ednum2.getText().toString());

        edsoma.setText(String.valueOf(resultMult));
    }
}
