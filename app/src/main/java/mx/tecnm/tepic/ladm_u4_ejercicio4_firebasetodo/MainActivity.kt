package mx.tecnm.tepic.ladm_u4_ejercicio4_firebasetodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import mx.tecnm.tepic.ladm_u4_ejercicio4_firebasetodo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.inscribir.setOnClickListener {

            val autenticacion=FirebaseAuth.getInstance()
            autenticacion.createUserWithEmailAndPassword(binding.correo.text.toString(),binding.contrasena.text.toString())
                .addOnCompleteListener{
                    if(it.isSuccessful){
                        binding.correo.text.clear()
                        binding.contrasena.text.clear()
                        Toast.makeText(this,"Se creo",Toast.LENGTH_LONG).show()
                    }else{
                        AlertDialog.Builder(this)
                            .setMessage("Error! No se contstruyo")
                            .setTitle("Atención")
                            .show()
                    }
                }


        }
    }
}