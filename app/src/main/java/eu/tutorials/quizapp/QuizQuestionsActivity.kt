package eu.tutorials.quizapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {

    private var processBar: ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOptionOne:TextView? = null
    private var tvOptionTwo:TextView? = null
    private var tvOptionThree:TextView? = null
    private var tvOptionFour:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        processBar =findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)

        val questionList = Constants.getQuestions()

        for(i in questionList){
            Log.e("Questions", i.question)
        }
        var currentPosition = 1
        val question : Question = questionList[currentPosition - 1]
        ivImage?.setImageResource(question.image)
        processBar?.progress = currentPosition
        tvProgress?.text = "$currentPosition / ${processBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
    }
}