package com.komputation.view

import tornadofx.*

class HelpView : Fragment("Help") {
    override val root = vbox{
        label("Welcome to Komputation!")
        label("This is computational software that can perform simple arithmetical calculations,\n and also integrate and differentiate usign Wolfram API.")
        label("To choose mode press on one of the buttons under the big Calculate button")
        //imageview("images/help1.jpg")
        label("To export your result press Export")
        label("To exit program click on File in the top menu.")
        label("Result supports copying.")
  }
}