package com.example.firebase.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.firebase.R
import com.example.firebase.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth


class Login : Fragment() {
    val ref = FirebaseAuth.getInstance()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnlog.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_portada)
        }

        /*binding.btnr.setOnClickListener {
            ref.createUserWithEmailAndPassword(
                binding.email.text.toString().trim(),
                binding.passwor.text.toString().trim()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    findNavController().navigate(R.id.action_login_to_portada)
                } else {
                    showAlert()
                }
            }
            Toast.makeText(requireContext(), "Estas registrado¡", Toast.LENGTH_SHORT).show()
        }
        binding.btnlog.setOnClickListener {
            ref.signInWithEmailAndPassword(
                binding.email.text.toString().trim(),
                binding.passwor.text.toString().trim()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    findNavController().navigate(R.id.action_login_to_portada)
                } else {
                    showAlert()
                }
            }
            Toast.makeText(requireContext(), "Autentificado¡", Toast.LENGTH_SHORT).show()
        }






    }
   private fun showAlert(){
       val builder=AlertDialog.Builder(requireContext())
       builder.setTitle("Error")
       builder.setMessage("Se ha producido un error autentificando al usuario")
       builder.setPositiveButton("Aceptar",null)
       val dialog:AlertDialog=builder.create()
       dialog.show()
   }*/


    }
}
