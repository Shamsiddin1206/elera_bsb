package farrukh.example.reasa.SignInSignUp_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.elera.Fragments.DefaultFragment
import com.example.elera.R
import com.example.elera.database.AppDatabase
import com.example.elera.databinding.FragmentPinCodeBinding
import com.example.marks.entity.Student


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PinCode_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PinCode_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
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
        val binding = FragmentPinCodeBinding.inflate(inflater,container,false)

        var list_students = appDatabase.getUserDao().getAllStudents()

      var user:Student

        binding.verify.setOnClickListener {
            for (i in list_students) {
                if (i.id_student == param1) {
                    user = i
                    if (binding.firstPinView.text.toString().equals(user.code)){
                        parentFragmentManager.beginTransaction().replace(R.id.activitymain,DefaultFragment()).commit()
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
         * @return A new instance of fragment PinCode_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            PinCode_Fragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}