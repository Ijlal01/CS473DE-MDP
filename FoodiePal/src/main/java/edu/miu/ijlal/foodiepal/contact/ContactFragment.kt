package edu.miu.ijlal.foodiepal.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import edu.miu.ijlal.foodiepal.R

class ContactFragment : Fragment() {

    private lateinit var phoneIcon: ImageView
    private lateinit var emailIcon: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        phoneIcon = view.findViewById(R.id.phoneIcon)
        emailIcon = view.findViewById(R.id.emailIcon)

        setupClickListeners()

        return view
    }

    private fun setupClickListeners() {
        phoneIcon.setOnClickListener {
            dialChefPhoneNumber()
        }

        emailIcon.setOnClickListener {
            sendEmailToChef()
        }
    }

    private fun dialChefPhoneNumber() {
        val phoneNumber = "+1234567890" // Replace with the actual phone number
        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(dialIntent)
    }

    private fun sendEmailToChef() {
        val email = "chef@example.com" // Replace with the actual email address
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
        }

        if (emailIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(emailIntent)
        } else {
            Snackbar.make(requireView(), "No email client installed", Snackbar.LENGTH_SHORT).show()
        }
    }
}
