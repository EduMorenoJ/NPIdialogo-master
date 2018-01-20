package ai.api.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ConectarsePantalla extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conectarse_pantalla);
    }

    public void Escanear(View v){
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
        scannerView.setResultHandler(this);
        scannerView.startCamera();

    }

    public void LeerNfc(View v){}

    @Override
    protected void onPause(){
        super.onPause();
        scannerView.stopCamera();
    }


    @Override
    public void handleResult(Result result) {

        Log.e("RESULTADO",result.getText());
        /*AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Resultado del escaneo");
        b.setMessage(result.getText());
        AlertDialog alertDialog = b.create();
        alertDialog.show();*/

        scannerView.removeAllViews(); //<- here remove all the views, it will make an Activity having no View
        scannerView.stopCamera(); //<- then stop the camera
        setContentView(R.layout.activity_conectarse_pantalla);
        //resultado.setText(result.getText());

        //Aqui nos conectamos con la interfaz y iniciamos el activity que navega por esa interfaz
        Intent i = new Intent(this, swipe.class);
        //i.putExtra("user", usuarioNuevo);
        startActivity(i);



        //scannerView.resumeCameraPreview(this);
    }

}
