package farrukh.example.reasa.SignInSignUp_fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.elera.R
import com.example.elera.database.AppDatabase
import com.example.elera.databinding.FragmentCreateAccountBinding
import com.example.marks.entity.Student

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Create_Account_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Create_Account_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
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
    ): View? {
        val binding = FragmentCreateAccountBinding.inflate(inflater,container,false)

       var list_students = appDatabase.getUserDao().getAllStudents()

        binding.signIn.setOnClickListener {
            if (binding.emailOrg.text.isNullOrEmpty() || binding.passwordOrg.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "fill the blanks", Toast.LENGTH_SHORT).show()
            }

            else{
                appDatabase.getUserDao().addStudent(Student(name_student = binding.emailOrg.text.toString(), password_student = binding.passwordOrg.text.toString(), email = "", date = "", nickname = ""),)
                Log.d("BNM", "onCreateView: "+list_students.joinToString())
                if (list_students.isEmpty()){
                    Toast.makeText(requireContext(), "can't register user", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(requireContext(), "registered ", Toast.LENGTH_SHORT).show()
                    parentFragmentManager.beginTransaction().replace(R.id.activitymain,LoginFragment()).commit()
                }
            }
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Create_Account_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Create_Account_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}