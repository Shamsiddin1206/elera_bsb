package farrukh.example.reasa.SignInSignUp_fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.elera.R
import com.example.elera.database.AppDatabase
import com.example.elera.databinding.FragmentProfileBinding
import com.example.marks.entity.Student

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Fill_ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Student? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable(ARG_PARAM1) as Student
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
        val binding = FragmentProfileBinding.inflate(inflater, container, false)

        var list_students = appDatabase.getUserDao().getAllStudents()

        binding.next.setOnClickListener {
            if (binding.passwordOrg.text.toString()
                    .isNullOrEmpty() && binding.nickOrg.text.toString()
                    .isNullOrEmpty() && binding.dateOrg.text.toString()
                    .isNullOrEmpty() && binding.nameOrg.text.toString().isNullOrEmpty()
            ) {
                Toast.makeText(requireContext(), "fill the blanks", Toast.LENGTH_SHORT).show()
            } else {
                var user: Student
                for (i in list_students) {
                    if (i.id_student == param1!!.id_student) {
                        user = i
                        user.email = param1?.email
                        user.code = binding.passwordOrg.text.toString()
                        user.nickname = binding.nickOrg.text.toString()
                        user.date = binding.dateOrg.text.toString()
                        user.name_student = binding.nameOrg.text.toString()
                        user.password_student = param1?.password_student.toString()
                        appDatabase.getUserDao().updateStudent(user)

                        parentFragmentManager.beginTransaction().replace(R.id.activitymain,PinCode_Fragment.newInstance(param1!!.id_student)).commit()
                    }
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
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Student) =
            Fill_ProfileFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}