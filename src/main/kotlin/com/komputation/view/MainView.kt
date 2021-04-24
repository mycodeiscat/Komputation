package com.komputation.view

import com.komputation.models.Parser.*
import com.komputation.models.Parser.CalculationStrategy
import com.komputation.models.Parser.DifferentationStrategy
import com.komputation.models.Parser.IntegrationStrategy
import com.komputation.models.Parser.Strategy
import com.komputation.models.command.Command
import com.komputation.models.command.CommandManager
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.control.ToggleGroup
import tornadofx.*
import kotlin.system.exitProcess


class MainController : Controller() {
    val AppEngine = AppEngine()
    fun mode(strategy: Strategy) {
        AppEngine.changeStrategy(strategy)
    }

    fun calculate(inputValue: String): String {
        CommandManager.engine = AppEngine
        return CommandManager.Compute(inputValue)
    }

    fun getHistory(number: Int): MutableList<Command> {
        return CommandManager.getLastCommands(number)
    }
    fun MapAdd()
    {

    }
}


class MainView : View("Komputation") {
    val controller: MainController by inject()
    val export_controller: ExportController by inject()
    val tree_controller: TreeController by inject()
    val input = SimpleStringProperty()
    private val toggleGroup = ToggleGroup()
    var result = SimpleStringProperty()
    var variables = FXCollections.observableArrayList<String>()
    var history = listOf(SimpleStringProperty(""), SimpleStringProperty(""), SimpleStringProperty(""))
    override val root =
            vbox {
                menubar {
                    menu("File") {
                        item("Exit").action {
                            exitProcess(1)
                        }
                    }
                    menu("Info") {
                        item("Help").action {
                            find<HelpView>().openModal()
                        }
                    }
                    separator()
                }
                form {
                    fieldset {
                        hbox {
                            field("Input")
                            {
                                textfield(input)
                                style {
                                    maxWidth = 200.px
                                }
                            }
                            button("Tree")
                            {
                                action{
                                    tree_controller.setInput(input.value)
                                    find<TreeView>().openModal()
                                }
                            }
                        }
                        hbox {
                            button("button1") {
                                bind(history[0])
                                action {
                                    input.value = history[0].value
                                }
                            }
                            button("button2") {
                                bind(history[1])
                                action {
                                    input.value = history[1].value
                                }

                            }
                            button("button3") {
                                bind(history[2])
                                action {
                                    input.value = history[2].value
                                }

                            }

                        }
                        button("Calculate") {
                            action {

                                result.value = controller.calculate(input.value)
                                val list = controller.getHistory(3)
                                if (!list.isEmpty()) {
                                    for (i in 0 until list.size) {
                                        if (i == 3) break
                                        history[i].value = list[list.size - i - 1].text
                                    }

                                }
                            }
                        }
                    }
                }

                    hbox {
                        vbox {
                            style {
                                padding = box(5.px)
                            }
                            radiobutton("Calculation", toggleGroup).action { controller.mode(CalculationStrategy()) }
                            radiobutton("Integration", toggleGroup).action { controller.mode(IntegrationStrategy()) }
                            radiobutton("Differentiation", toggleGroup).action { controller.mode(DifferentationStrategy()) }
                        }
                        vbox {
                            style {
                                padding = box(20.px)
                            }
                            children.bind(variables) {
                                label(it)
                            }
                        }
                    }
                    hbox {
                        style {
                            padding = box(5.px)
                        }
                        label("Result: ")
                        {
                            style {
                                fontSize = 20.px
                                padding = box(7.px)
                            }
                        }
                        textfield {
                            isEditable = false
                            style {
                                backgroundColor += c("transparent")
                                fontSize = 20.px
                            }
                            bind(result)
                        }

                        button("Export")
                        {
                            action {
                                export_controller.load(result.value)
                                find<ExportView>().openModal()
                            }
                            style {
                                padding = box(5.px)
                            }
                        }
                    }

            }
}