package com.ilhomjon.soddabrowser

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var url = "https://"
    lateinit var progressDialog : ProgressDialog

    var str = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<title>Shunchaki mashg'ulot</title>\n" +
            "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "\t<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" crossorigin=\"anonymous\">\n" +
            "\t<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0\" crossorigin=\"anonymous\"></script>\n" +
            "\t<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js\" integrity=\"sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi\" crossorigin=\"anonymous\"></script>\n" +
            "\t<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js\" integrity=\"sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG\" crossorigin=\"anonymous\"></script>\n" +
            "\t<style type=\"text/css\">\n" +
            "\t\tbody{\n" +
            "\t\t\tbackground-color: #333;\n" +
            "\t\t}\n" +
            "\t</style>\n" +
            "</head>\n" +
            "<body>\n" +
            "\t<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\" style=\"padding-bottom: 30px;\">\n" +
            "  \t<div class=\"container-fluid\">\n" +
            "    <a class=\"navbar-brand\" href=\"#\">Menyular satri</a>\n" +
            "    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarScroll\" aria-controls=\"navbarScroll\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
            "      <span class=\"navbar-toggler-icon\"></span>\n" +
            "    </button>\n" +
            "    <div class=\"collapse navbar-collapse\" id=\"navbarScroll\">\n" +
            "      <ul class=\"navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll\" style=\"--bs-scroll-height: 100px;\">\n" +
            "        <li class=\"nav-item\">\n" +
            "          <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Uy</a>\n" +
            "        </li>\n" +
            "        <li class=\"nav-item\">\n" +
            "          <a class=\"nav-link\" href=\"#qizlar\">Biz haqimizda</a>\n" +
            "        </li>\n" +
            "        <li class=\"nav-item dropdown\">\n" +
            "          <a class=\"nav-link dropdown-toggle\" href=\"#qizlar\" id=\"navbarScrollingDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"true\">\n" +
            "            Qizlar\n" +
            "          </a>\n" +
            "          <ul class=\"dropdown-menu\" aria-labelledby=\"navbarScrollingDropdown\">\n" +
            "            <li><a class=\"dropdown-item\" href=\"#mashinalar\">Mashinalar</a></li>\n" +
            "            <li><a class=\"dropdown-item\" href=\"#uylar\">Uylar</a></li>\n" +
            "            <li><hr class=\"dropdown-divider\"></li>\n" +
            "            <li><a class=\"dropdown-item\" href=\"#\">Telefonlar</a></li>\n" +
            "          </ul>\n" +
            "          <ul class=\"collapse navbar-collapse\" style=\"margin-left:200px;  color: white;list-style-type: none;\">\n" +
            "            <li style=\"margin: 5px;margin-top: 0;\"><h6 onmouseover=\"orqaFon ('red')\">Qizil</h6></li>\n" +
            "            <li style=\"margin: 5px;margin-top: 0\"><h6 onmouseover=\"orqaFon ('blue')\">Ko'k</h6></li>\n" +
            "            <li style=\"margin: 5px;margin-top: 0\"><h6 onmouseover=\"orqaFon ('green')\">Yashil</h6></li>\n" +
            "          </ul>\n" +
            "        </li>\n" +
            "      </ul>\n" +
            "      <form class=\"d-flex\">\n" +
            "        <input class=\"form-control me-2\" type=\"search\" placeholder=\"Qidirish\" aria-label=\"Search\">\n" +
            "        <button class=\"btn btn-outline-success\" type=\"submit\" style=\"color:white;\">Qidirish</button>\n" +
            "      </form>\n" +
            "    </div>\n" +
            "  </div></nav>\n" +
            "  <section id=\"showcase\">\n" +
            "  <div id=\"carouselExampleCaptions\" class=\"carousel slide\" style=\"box-sizing: border-box;max-width:900px;position: relative;margin: auto;\" data-bs-ride=\"carousel\" class=\"container\">\n" +
            "  <div class=\"carousel-indicators\">\n" +
            "    <button type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide-to=\"0\" class=\"active\" aria-current=\"true\" aria-label=\"Slide 1\"></button>\n" +
            "    <button type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide-to=\"1\" aria-label=\"Slide 2\"></button>\n" +
            "    <button type=\"button\" data-bs-target=\"#carouselExampleCaptions\" data-bs-slide-to=\"2\" aria-label=\"Slide 3\"></button>\n" +
            "  </div>\n" +
            "  <div class=\"carousel-inner\">\n" +
            "    <div class=\"carousel-item active\">\n" +
            "      <img src=\"https://www.pixelstalk.net/wp-content/uploads/2016/08/Free-HD-Cute-Girl-Wallpaper.jpg\" class=\"d-block w-100\" class=\"img-fluid\" alt=\"Ajoyib\" style=\"object-fit: cover;\">\n" +
            "      <div class=\"carousel-caption d-none d-md-block\">\n" +
            "        <h5>First slide label</h5>\n" +
            "        <p>Some representative placeholder content for the first slide.</p>\n" +
            "      </div>\n" +
            "    </div>\n" +
            "    <div class=\"carousel-item\">\n" +
            "      <img src=\"https://wallpaperaccess.com/full/255927.jpg\" class=\"d-block w-100\" alt=\"Ajoyib\">\n" +
            "      <div class=\"carousel-caption d-none d-md-block\">\n" +
            "        <h5>Second slide label</h5>\n" +
            "        <p>Some representative placeholder content for the second slide.</p>\n" +
            "      </div>\n" +
            "    </div>\n" +
            "    <div class=\"carousel-item\">\n" +
            "      <img src=\"https://wallpaperaccess.com/full/2492037.jpg\" class=\"d-block w-100\" alt=\"Ajoyib\">\n" +
            "      <div class=\"carousel-caption d-none d-md-block\">\n" +
            "        <h5>Third slide label</h5>\n" +
            "        <p>Some representative placeholder content for the third slide.</p>\n" +
            "      </div>\n" +
            "    </div>\n" +
            "  </div>\n" +
            "  <button class=\"carousel-control-prev\" type=\"button\" data-bs-target=\"#carouselExampleCaptions\"  data-bs-slide=\"prev\">\n" +
            "    <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n" +
            "    <span class=\"visually-hidden\">Previous</span>\n" +
            "  </button>\n" +
            "  <button class=\"carousel-control-next\" type=\"button\" data-bs-target=\"#carouselExampleCaptions\"  data-bs-slide=\"next\">\n" +
            "    <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n" +
            "    <span class=\"visually-hidden\">Next</span>\n" +
            "  </button>\n" +
            "</div>\n" +
            "</div>\n" +
            "</section>\n" +
            "<div class=\"row\" style=\"text-align: center; padding-top: 30px;\">\n" +
            "      <div class=\"col-lg-4\"><img src=\"https://eskipaper.com/images/cute-girl-wallpaper-hd-1.jpg\" style=\"width: 100px; height: 100px; border-radius: 50%; object-fit: cover;\"><title>Qizlar</title><rect width=\"100%\" height=\"100%\" fill=\"#777\"></rect></svg>\n" +
            "\n" +
            "        <h2 style=\"color: white;\" id=\"qizlar\">Qizlar</h2>\n" +
            "        <p style=\"color: white;\">Qizlarni tanlasangiz sizga 16 ta model qizlar taklif qilinadi. Birini tanlang va sizga uning telefon raqamini yuboramiz</p>\n" +
            "        <p><a class=\"btn btn-secondary\" href=\"#\">Qo'shimcha malumotlar uchun »</a></p>\n" +
            "      </div>\n" +
            "      <div class=\"col-lg-4\">\n" +
            "        <img src=\"https://wallpaperaccess.com/full/11207.jpg\" style=\"width: 100px; height: 100px; border-radius: 50%; object-fit: cover;\"><title>Mashinalar</title><rect width=\"100%\" height=\"100%\" fill=\"#777\"></rect></svg>\n" +
            "\n" +
            "        <h2 style=\"color: white;\" id=\"mashinalar\">Mashinalar</h2>\n" +
            "        <p style=\"color: white;\">Siz uchun mahsus 16 hil mashinalarimiz mavjud. Birini tanlang va bizga bog'laning</p>\n" +
            "        <p><a class=\"btn btn-secondary\" href=\"#\">Qo'shimcha malumotlar uchun »</a></p>\n" +
            "      </div>\n" +
            "      <div class=\"col-lg-4\">\n" +
            "        <img src=\"https://wallpaperaccess.com/full/3060213.jpg\" style=\"width: 100px; height: 100px; border-radius: 50%; object-fit: cover;\"><title>Uylar</title><rect width=\"100%\" height=\"100%\" fill=\"#777\"></rect></svg>\n" +
            "\n" +
            "        <h2 style=\"color: white;\" id=\"uylar\">Uylar</h2>\n" +
            "        <p style=\"color: white;\">Siz uchun mahsus 16 hil uylarimiz mavjud. Birini tanlang va bizga bog'laning</p>\n" +
            "        <p><a class=\"btn btn-secondary\" href=\"#\">Qo'shimcha malumotlar uchun »</a></p>\n" +
            "      </div><!-- /.col-lg-4 -->\n" +
            "    </div>\n" +
            "  <script type=\"text/javascript\">\n" +
            "    function orqaFon (rang){\n" +
            "      document.body.style.backgroundColor = rang;\n" +
            "    }\n" +
            "  </script>\n" +
            "</body>\n" +
            "</html>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
        web_view.loadData(header + str, "text/html", "UTF-8");

        val settings: WebSettings = web_view.getSettings()
        settings.defaultTextEncodingName = "utf-8"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            val base64: String = Base64.encodeToString(str.toByteArray(), Base64.DEFAULT)
            web_view.loadData(base64, "text/html; charset=utf-8", "base64")
        } else {
            val header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
            web_view.loadData(header + str, "text/html; charset=UTF-8", null)
        }

//        //searchView
//        edt_url.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                web_view.loadUrl("$url$query")
//                return true
//             }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return true
//            }
//        })

//        //editText uchun
//        edt_url.addTextChangedListener(object : TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                web_view.loadUrl("$url${edt_url.text.toString()}")
//            }
//        })

        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading...")

        web_view.settings.javaScriptEnabled = true

      //  web_view.loadUrl("https://www.google.com/")

        web_view.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
          //      view?.loadUrl("")
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
//                progress_bar.visibility = View.VISIBLE
                progressDialog.show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
//                progress_bar.visibility = View.INVISIBLE
                progressDialog.hide()
            }
        }
    }
}