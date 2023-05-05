package com.example.psychai

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class MoodView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    var xCoord = 0f
    var yCoord = 0f
    var canvasWidth = 0
    var canvasHeight = 0
    val rightPadding = 50f
    val bottomPadding = 250f

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        canvasWidth = w
        canvasHeight = h
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                xCoord = event.x
                yCoord = event.y
                invalidate()
            }
        }
        return true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.WHITE
        paint.strokeWidth = 5f

        val canvasWidth = width
        val canvasHeight = height
        val topPadding = 50f
        val leftPadding = 50f
        val rightPadding = 50f
        val bottomPadding = 250f

        val rect = RectF(
            leftPadding,
            topPadding,
            canvasWidth - rightPadding,
            canvasHeight - bottomPadding
        )

        canvas?.drawRect(rect, paint)

        // Draw the 4 quadrants
        val quadrantWidth = (canvasWidth - leftPadding - rightPadding) / 2
        val quadrantHeight = (canvasHeight - topPadding - bottomPadding) / 2


        val q2 = Paint()
        q2.color = Color.parseColor("#d45162")
        val tl1 = Paint()
        tl1.color = Color.parseColor("#d96171")

        val tl2 = Paint()
        tl2.color = Color.parseColor("#de7c8b")

        val tl3 = Paint()
        tl3.color = Color.parseColor("#ebaeb6")

        // Top left quadrant
        val tlRect = RectF(
            50f,
            50f,
            leftPadding + quadrantWidth,
            topPadding + quadrantHeight
        )
        val tl1Rect = RectF(
            leftPadding,
            topPadding,
            leftPadding + quadrantWidth / 2,
            topPadding + quadrantHeight / 2
        )

        val tl2Rect = RectF(
            leftPadding + quadrantWidth / 2,
            topPadding,
            leftPadding + quadrantWidth,
            topPadding + quadrantHeight / 2
        )

        val tl3Rect = RectF(
            leftPadding,
            topPadding + quadrantHeight / 2,
            leftPadding + quadrantWidth / 2,
            topPadding + quadrantHeight
        )

        val tl4Rect = RectF(
            leftPadding + quadrantWidth / 2,
            topPadding + quadrantHeight / 2,
            leftPadding + quadrantWidth,
            topPadding + quadrantHeight
        )

        canvas?.drawRect(tlRect, q2)
        canvas?.drawRect(tl1Rect, q2)
        canvas?.drawRect(tl2Rect, tl1)
        canvas?.drawRect(tl3Rect, tl2)
        canvas?.drawRect(tl4Rect, tl3)

        //tr colors
        val q1 = Paint()
        q1.color = Color.parseColor("#5eb87c")

        val tr1 = Paint()
        tr1.color = Color.parseColor("#6cc188")

        val tr2 = Paint()
        tr2.color = Color.parseColor("#89cf9f")

        val tr3 = Paint()
        tr3.color = Color.parseColor("#b5e1c2")

        // Top right quadrant
        val trRect = RectF(
            canvasWidth - rightPadding - quadrantWidth,
            topPadding,
            canvasWidth - rightPadding,
            topPadding + quadrantHeight
        )
        canvas?.drawRect(trRect, q1)
        val trQ1Rect = RectF(
            canvasWidth - rightPadding - quadrantWidth,
            topPadding,
            canvasWidth - rightPadding - (quadrantWidth / 2),
            topPadding + (quadrantHeight / 2)
        )
        canvas?.drawRect(trQ1Rect, tr1)

        val trQ2Rect = RectF(
            canvasWidth - rightPadding - (quadrantWidth / 2),
            topPadding,
            canvasWidth - rightPadding,
            topPadding + (quadrantHeight / 2)
        )
        canvas?.drawRect(trQ2Rect, tr2)

        val trQ3Rect = RectF(
            canvasWidth - rightPadding - quadrantWidth,
            topPadding + (quadrantHeight / 2),
            canvasWidth - rightPadding - (quadrantWidth / 2),
            topPadding + quadrantHeight
        )
        canvas?.drawRect(trQ3Rect, tr3)

        val trQ4Rect = RectF(
            canvasWidth - rightPadding - (quadrantWidth / 2),
            topPadding + (quadrantHeight / 2),
            canvasWidth - rightPadding,
            topPadding + quadrantHeight
        )
        canvas?.drawRect(trQ4Rect, q1)


        val q3 = Paint()
        q3.color = Color.parseColor("#884686")
        val bl1 = Paint()
        bl1.color = Color.parseColor("#945793")

        val bl2 = Paint()
        bl2.color = Color.parseColor("#a975a6")

        val bl3 = Paint()
        bl3.color = Color.parseColor("#cba9c8")

        // Bottom left quadrant
        val blRect = RectF(
            leftPadding,
            canvasHeight - bottomPadding - quadrantHeight,
            leftPadding + quadrantWidth,
            canvasHeight - bottomPadding
        )
        canvas?.drawRect(blRect, q3)
        val bl1Rect = RectF(
            leftPadding,
            canvasHeight - bottomPadding - quadrantHeight,
            leftPadding + quadrantWidth / 2,
            canvasHeight - bottomPadding - quadrantHeight / 2
        )
        canvas?.drawRect(bl1Rect, bl1)

        val bl2Rect = RectF(
            leftPadding + quadrantWidth / 2,
            canvasHeight - bottomPadding - quadrantHeight,
            leftPadding + quadrantWidth,
            canvasHeight - bottomPadding - quadrantHeight / 2
        )
        canvas?.drawRect(bl2Rect, bl2)

        val bl3Rect = RectF(
            leftPadding,
            canvasHeight - bottomPadding - quadrantHeight / 2,
            leftPadding + quadrantWidth / 2,
            canvasHeight - bottomPadding
        )
        canvas?.drawRect(bl3Rect, bl3)

        val bl4Rect = RectF(
            leftPadding + quadrantWidth / 2,
            canvasHeight - bottomPadding - quadrantHeight / 2,
            leftPadding + quadrantWidth,
            canvasHeight - bottomPadding
        )
        canvas?.drawRect(bl4Rect, q3)

        //br colors
        val q4 = Paint()
        q4.color = Color.parseColor("#4881b2")
        val br1 = Paint()
        br1.color = Color.parseColor("#578cba")
        val br2 = Paint()
        br2.color = Color.parseColor("#75a0c6")
        val br3 = Paint()
        br3.color = Color.parseColor("#a8c5dd")

        // Bottom right quadrant
        val brRect = RectF(
            canvasWidth - rightPadding - quadrantWidth,
            canvasHeight - bottomPadding - quadrantHeight,
            canvasWidth - rightPadding,
            canvasHeight - bottomPadding
        )
        canvas?.drawRect(brRect, q4)
        val brRect1 = RectF(
            canvasWidth - rightPadding - quadrantWidth,
            canvasHeight - bottomPadding - quadrantHeight,
            canvasWidth - rightPadding - quadrantWidth / 2,
            canvasHeight - bottomPadding - quadrantHeight / 2
        )
        canvas?.drawRect(brRect1, br1)

        val brRect2 = RectF(
            canvasWidth - rightPadding - quadrantWidth / 2,
            canvasHeight - bottomPadding - quadrantHeight,
            canvasWidth - rightPadding,
            canvasHeight - bottomPadding - quadrantHeight / 2
        )
        canvas?.drawRect(brRect2, br2)

        val brRect3 = RectF(
            canvasWidth - rightPadding - quadrantWidth,
            canvasHeight - bottomPadding - quadrantHeight / 2,
            canvasWidth - rightPadding - quadrantWidth / 2,
            canvasHeight - bottomPadding
        )
        canvas?.drawRect(brRect3, br3)

        val brRect4 = RectF(
            canvasWidth - rightPadding - quadrantWidth / 2,
            canvasHeight - bottomPadding - quadrantHeight / 2,
            canvasWidth - rightPadding,
            canvasHeight - bottomPadding
        )
        canvas?.drawRect(brRect4, q4)

        val circlePaint = Paint()
        circlePaint.color = Color.WHITE

        canvas?.drawCircle(xCoord, yCoord, 20f, circlePaint)

        val hap = Paint()
        hap.color = Color.parseColor("#b5e1c2")
        hap.textSize = 50f
        canvas?.drawText("Happy", 600f, 200f, hap)
        val exc = Paint()
        exc.color = Color.parseColor("#9dd8b1")
        exc.textSize = 50f
        canvas?.drawText("Excited", 830f, 800f, exc)
        val alr = Paint()
        alr.color = Color.parseColor("#488c5f")
        alr.textSize = 50f
        canvas?.drawText("Alert", 630f, 800f, alr)

        //quadrant 3
        val sad = Paint()
        sad.color = Color.parseColor("#60325e")
        sad.textSize = 50f
        canvas?.drawText("Sad", 150f, 1700f, sad)
        val dep = Paint()
        dep.color = Color.parseColor("#663464")
        dep.textSize = 50f
        canvas?.drawText("Depressed", 150f, 1200f, dep)
        val bor = Paint()
        bor.color = Color.parseColor("#cba9c8")
        bor.textSize = 50f
        canvas?.drawText("Bored", 350f, 1700f, bor)

        //quadrant 1
        val ang = Paint()
        ang.color = Color.parseColor("#ebafb6")
        ang.textSize = 50f
        canvas?.drawText("Angry", 120f, 200f, ang)
        val ups = Paint()
        ups.color = Color.parseColor("#a13e4c")
        ups.textSize = 50f
        canvas?.drawText("Upset", 350f, 200f, ups)
        val nervous = Paint()
        nervous.color = Color.parseColor("#b44555")
        nervous.textSize = 50f
        canvas?.drawText("Nervous", 150f, 700f, nervous)

        //quadrant 4
        val rel = Paint()
        rel.color = Color.parseColor("#3a6892")
        rel.textSize = 50f
        canvas?.drawText("Relaxed", 600f, 1700f, rel)
        val calm = Paint()
        calm.color = Color.parseColor("#7fb2df")
        calm.textSize = 50f
        canvas?.drawText("Calm", 850f, 1700f, calm)
        val content = Paint()
        content.color = Color.parseColor("#3b6990")
        content.textSize = 50f
        canvas?.drawText("Contended", 720f, 1200f, content)

//        if (xCoord < 50f || xCoord > 1000f || yCoord < 50f || yCoord > 2000f) {
//            Toast.makeText(
//                context,
//                "Please tap on the inside of the mood meter.",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
    }
}