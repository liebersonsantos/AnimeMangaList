package br.com.liebersonsantos.animemangalist.util

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewFlipper
import br.com.liebersonsantos.animemangalist.R
import br.com.liebersonsantos.animemangalist.data.model.Slider
import br.com.liebersonsantos.animemangalist.data.model.Top
import com.bumptech.glide.Glide

/**
 * Created by lieberson on 10/19/21.
 * @author lieberson.xsantos@gmail.com
 */
class CustomFlipper(context: Context?, attrs: AttributeSet?) : ViewFlipper(context, attrs) {

    private var list = mutableListOf<Top>()

    fun setList(listTop: MutableList<Top>) {
        this.list = listTop
    }

    fun setLayout() {
        val flipperList = mutableListOf<Slider>()
        list.forEach { top ->
            flipperList.add(Slider(top.imageUrl, top.title))
        }

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        this.setInAnimation(context, android.R.anim.slide_in_left)
        this.setOutAnimation(context, android.R.anim.slide_out_right)

        for (i in flipperList.indices) {
            val view: View = inflater.inflate(R.layout.item_flipper, this, false)

            val tvName = view.findViewById(R.id.topNameFlipper) as TextView
            tvName.text = flipperList[i].name

            val img = view.findViewById(R.id.topImgFlipper) as ImageView

            Glide.with(context).load(flipperList[i].img).into(img)

            this.addView(view, i)
        }
    }
}