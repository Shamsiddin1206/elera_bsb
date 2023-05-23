package com.example.elera.Fragments.SignInSignUp_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.elera.R
import com.example.elera.database.AppDatabase
import com.example.elera.databinding.FragmentLoginBinding
import farrukh.example.reasa.SignInSignUp_fragments.Create_Account_Fragment
import farrukh.example.reasa.SignInSignUp_fragments.Fill_ProfileFragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    val appDatabase: AppDatabase by lazy {
        AppDatabase.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        var list_students = appDatabase.getUserDao().getAllStudents()


        binding.singIn.setOnClickListener {
            if (binding.emailOrg.text.isNullOrEmpty() || binding.passwordOrg.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "fill the blanks", Toast.LENGTH_SHORT).show()
            }

            else{
                for (i in list_students){
                    if (binding.emailOrg.text.toString().equals(i.email) && binding.passwordOrg.text.toString().equals(i.password_student)){
                        parentFragmentManager.beginTransaction().replace(R.id.activitymain,
                            Fill_ProfileFragment.newInstance(i)
                        ).commit()
                    }
                }
//                Toast.makeText(requireContext(), "wrong password or email", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signUp.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.activitymain,
                Create_Account_Fragment()
            ).commit()
        }



        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}