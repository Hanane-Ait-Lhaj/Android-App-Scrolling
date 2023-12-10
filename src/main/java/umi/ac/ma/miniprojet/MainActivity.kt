package umi.ac.ma.miniprojet

import android.content.Intent
import android.content.res.Resources
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var scroll = findViewById<ScrollView>(R.id.scroll)
        var btn_present = findViewById<ImageView>(R.id.btn_present)
        var btn_departement = findViewById<ImageView>(R.id.btn_departement)
        var btn_formation = findViewById<ImageView>(R.id.btn_formation)
        var btn_contact = findViewById<ImageView>(R.id.btn_contact)
        var btn_tel = findViewById<TextView>(R.id.btn_tel)
        var btn_email = findViewById<TextView>(R.id.btn_email)

        var txt_present = findViewById<LinearLayout>(R.id.txt_present)
        var txt_departement = findViewById<LinearLayout>(R.id.txt_departement)
        var txt_formation = findViewById<LinearLayout>(R.id.txt_formation)
        var txt_contact = findViewById<LinearLayout>(R.id.txt_contact)

        var estm_logo = findViewById<ImageView>(R.id.estm_logo)

        estm_logo.setOnClickListener{
                var browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.est-umi.ac.ma"))
                startActivity(browserIntent);
        }


        scroll.viewTreeObserver.addOnScrollChangedListener(
            object : ViewTreeObserver.OnScrollChangedListener {
                override fun onScrollChanged() {
                    // Get the current scroll position
                    val pos = scroll.scrollY

                    // change icon color
                    if(pos>=txt_present.y){
                        btn_present.setColorFilter(btn_present.getContext().getResources().getColor(R.color.orange), PorterDuff.Mode.SRC_ATOP);
                        btn_departement.setColorFilter(btn_departement.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                        btn_formation.setColorFilter(btn_formation.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                        btn_contact.setColorFilter(btn_contact.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                    }
                    if(pos>=txt_departement.y){
                        btn_present.setColorFilter(btn_present.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                        btn_departement.setColorFilter(btn_departement.getContext().getResources().getColor(R.color.orange), PorterDuff.Mode.SRC_ATOP);
                        btn_formation.setColorFilter(btn_formation.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                        btn_contact.setColorFilter(btn_contact.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                    }
                    if(pos>=txt_formation.y){
                        btn_present.setColorFilter(btn_present.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                        btn_departement.setColorFilter(btn_departement.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                        btn_formation.setColorFilter(btn_formation.getContext().getResources().getColor(R.color.orange), PorterDuff.Mode.SRC_ATOP);
                        btn_contact.setColorFilter(btn_contact.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                    }
                    //get the scroll height
                    val scrollViewHeight = scroll.height
                    //get the child layout height
                    val scrollViewChildHeight = scroll.getChildAt(0).height

                    // Check if the scroll position is at the bottom
                    if(pos + scrollViewHeight >= scrollViewChildHeight || pos >= txt_contact.y){
                        btn_present.setColorFilter(btn_present.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                        btn_departement.setColorFilter(btn_departement.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                        btn_formation.setColorFilter(btn_formation.getContext().getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                        btn_contact.setColorFilter(btn_contact.getContext().getResources().getColor(R.color.orange), PorterDuff.Mode.SRC_ATOP);
                    }

                }
            }
        )




        btn_present.setOnClickListener {
            scroll.scrollTo(txt_present.x.toInt(),txt_present.y.toInt())
        }
        btn_formation.setOnClickListener {
            scroll.scrollTo(txt_formation.x.toInt(),txt_formation.y.toInt())
        }
        btn_departement.setOnClickListener {
            scroll.scrollTo(txt_departement.x.toInt(),txt_departement.y.toInt())
        }
        btn_contact.setOnClickListener {
            scroll.scrollTo(txt_contact.x.toInt(),txt_contact.y.toInt())
        }
        btn_tel.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:+212535467084"))
            startActivity(intent)
        }
        //Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=Higher School of Technology Km 5, Rue d'Agouray, N6, Meknes 50040, Morocco"))
        var btn_fb = findViewById<ImageView>(R.id.btn_fb)
        var btn_ig = findViewById<ImageView>(R.id.btn_ig)
        var btn_yt = findViewById<ImageView>(R.id.btn_yt)
        var btn_tw = findViewById<ImageView>(R.id.btn_tw)

        btn_fb.setOnClickListener {
            var browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/EstmOfficielle"))
            startActivity(browserIntent);
        }
        btn_ig.setOnClickListener {
            var browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/EstmOfficielle"))
            startActivity(browserIntent);
        }
        btn_yt.setOnClickListener {
            var browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/@estmofficielle"))
            startActivity(browserIntent);
        }
        btn_tw.setOnClickListener {
            var browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/estmofficielle"))
            startActivity(browserIntent);
        }


    }
}