package com.example.quiz

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var checkboxOption1: CheckBox
    private lateinit var checkboxOption2: CheckBox
    private lateinit var checkboxOption3: CheckBox
    private lateinit var checkboxOption4: CheckBox
    private lateinit var submitButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        checkboxOption1 = findViewById(R.id.checkboxOption1)
        checkboxOption2 = findViewById(R.id.checkboxOption2)
        checkboxOption3 = findViewById(R.id.checkboxOption3)
        checkboxOption4 = findViewById(R.id.checkboxOption4)

        submitButton = findViewById(R.id.submitButton)
        resetButton = findViewById(R.id.resetButton)

        submitButton.setOnClickListener {
            onSubmission()
        }

        resetButton.setOnClickListener {
            resetQuiz()
        }
    }

    private fun onSubmission() {
        val score = calculateScore()
        val currentDate = getCurrentDate()

        val message = "Congratulations! You submitted on $currentDate, and you achieved $score%"
        showAlertDialog("Quiz Result", message)
    }

    private fun calculateScore(): Int {
        val question1CorrectAnswerId = R.id.option2 // Correct answer for Question 1 is now "val"
        val question1SelectedAnswerId = radioGroup.checkedRadioButtonId

        // All checkboxes are correct answers for Question 2
        val question2CorrectAnswers = setOf(R.id.checkboxOption1, R.id.checkboxOption2, R.id.checkboxOption3, R.id.checkboxOption4)
        val question2SelectedAnswers = getSelectedCheckBoxes()

        val question1Score = if (question1SelectedAnswerId == question1CorrectAnswerId) {
            50 // Question 1 carries 50 points
        } else {
            0
        }

        // For Question 2, since all options are correct, check if the user selected all options
        val question2Score = if (question2SelectedAnswers == question2CorrectAnswers) {
            50 // Question 2 carries 50 points
        } else {
            0
        }

        return question1Score + question2Score
    }

    private fun resetQuiz() {
        radioGroup.clearCheck()
        checkboxOption1.isChecked = false
        checkboxOption2.isChecked = false
        checkboxOption3.isChecked = false
        checkboxOption4.isChecked = false
    }

    private fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return sdf.format(Date())
    }

    private fun getSelectedCheckBoxes(): Set<Int> {
        val selectedCheckBoxes = mutableSetOf<Int>()
        if (checkboxOption1.isChecked) selectedCheckBoxes.add(R.id.checkboxOption1)
        if (checkboxOption2.isChecked) selectedCheckBoxes.add(R.id.checkboxOption2)
        if (checkboxOption3.isChecked) selectedCheckBoxes.add(R.id.checkboxOption3)
        if (checkboxOption4.isChecked) selectedCheckBoxes.add(R.id.checkboxOption4)
        return selectedCheckBoxes
    }

    private fun showAlertDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}
