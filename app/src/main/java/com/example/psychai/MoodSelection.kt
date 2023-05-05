package com.example.psychai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MoodSelection : AppCompatActivity() {

    companion object {
        var finalXValue = 0f
        var finalYValue = 0f
        lateinit var tag: String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood_selection)

        val btnMood = findViewById<Button>(R.id.btnConfirm)
        val moodView = findViewById<MoodView>(R.id.moodView)

        moodView?.invalidate()

        btnMood.setOnClickListener {
            finalValues(moodView)
            startActivity(Intent(this@MoodSelection, MusicActivity::class.java))
        }
    }

    private fun finalValues(moodView: MoodView) {
        val moodCanvasWidth = moodView.canvasWidth.toFloat() - moodView.rightPadding
        val moodCanvasHeight = moodView.canvasHeight.toFloat() - moodView.bottomPadding
        val xOriginValue = moodCanvasWidth / 2
        val yOriginValue = moodCanvasHeight / 2

        val x: Float = ((moodView.xCoord - xOriginValue) * 2) / 1000
        val y: Float = (((moodView.yCoord - yOriginValue) * -1.2) / 1000).toFloat()

        val a = String.format("%.2f", x)
        val b = String.format("%.2f", y)

        finalXValue = a.toFloat()
        finalYValue = b.toFloat()

        if (finalXValue > 0 && finalYValue > 0) {
            if (finalYValue < 0.5) {
                tag = "Happy"
            } else if (finalXValue <= 0.5 && finalYValue >= 0.5) {
                tag = "pop"
            } else {
                tag = "rock"
            }
        } else if (finalYValue > 0 && finalXValue < 0) {
            if (finalXValue <= -0.45 && finalYValue >= 0.5) {
                tag = "Angry"
            } else if (finalXValue >= -0.45 && finalYValue <= 0.5) {
                tag = "ballads"
            } else {
                tag = "orchestral"
            }
        } else if (finalXValue < 0 && finalYValue < 0) {
            if (finalYValue <= -0.6) {
                tag = "classical"
            } else if (finalYValue > -0.6 && finalXValue <= -0.5) {
                tag = "sad"
            } else {
                tag = "bored"
            }
        } else if (finalXValue > 0 && finalYValue < 0) {
            if (finalXValue <= 1 && finalYValue > -0.5) {
                tag = "easy listening"
            } else if (finalXValue < 0.5 && finalYValue < -0.5) {
                tag = "reggae"
            } else {
                tag = "calm"
            }
        }

    }
}