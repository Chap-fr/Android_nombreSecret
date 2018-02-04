package francois.nombresecret;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btJouer, btGenerer, btMontrer;
    private EditText txtLimite1, txtLimite2, txtNom, txtPrenom, txtEssai;
    private TextView tvTentatives, tvNbSecret;
    private Nombre leNombre;
    private int limite1, limite2, essai, nbTentatives;
    private boolean generer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btMontrer = (Button) findViewById(R.id.idMontrer);
        this.btGenerer = (Button) findViewById(R.id.idGenerer);
        this.btJouer = (Button) findViewById(R.id.idJouer);

        this.txtNom = (EditText) findViewById(R.id.idNom);
        this.txtPrenom = (EditText) findViewById(R.id.idPrenom);
        this.txtLimite1 = (EditText) findViewById(R.id.idLimite1);
        this.txtLimite2 = (EditText) findViewById(R.id.idLimite2);

        this.tvNbSecret = (TextView) findViewById(R.id.idSecret);
        this.tvTentatives = (TextView) findViewById(R.id.idTentatives);

        this.btJouer.setOnClickListener(this);
        this.btGenerer.setOnClickListener(this);
        this.btMontrer.setOnClickListener(this);

        //nombre instanciation
        this.leNombre = new Nombre();
        this.generer = false;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.idMontrer :

                if (this.generer == true){
                    this.tvNbSecret.setText("Nombre secret : "+ this.leNombre.getNombre());
                }else{
                    Toast.makeText(this, "nombre secret non générer !", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.idGenerer :
                try{
                    this.limite1 = Integer.parseInt(this.txtLimite1.getText().toString());
                    this.limite2 = Integer.parseInt(this.txtLimite2.getText().toString());
                }catch(NumberFormatException exp){
                    Toast.makeText(this, "Attention aux limites", Toast.LENGTH_LONG).show();
            }
            this.leNombre.generer(limite1, limite2);


                break;

            case R.id.idJouer :
                if(this.nbTentatives <= 10){
                    this.essai = Integer.parseInt(this.txtEssai.getText().toString());
                    String message = this.leNombre.message(this.essai);
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                    this.tvTentatives.setText("NB tentatives : " + this.nbTentatives);
                }else{
                    this.nbTentatives = 1;
                    this.generer = false;
                    Toast.makeText(this, "Fin de partie",Toast.LENGTH_LONG).show();
                }

                break;
        }

    }
}
