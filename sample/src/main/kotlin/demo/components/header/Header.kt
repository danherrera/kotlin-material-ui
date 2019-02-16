package demo.components.header

import components.appbar.appBar
import kotlinx.css.CSSBuilder
import kotlinx.css.Display
import kotlinx.css.properties.BoxShadows
import react.RBuilder
import react.RComponent
import react.RState
import react.dom.div
import styles.childWithStyles
import styles.createMuiTheme
import styles.muitheme.get
import styles.muitheme.gutters
import styles.muitheme.minHeight
import styles.muitheme.toolbar

class Header : RComponent<HeaderProps, RState>() {
    override fun RBuilder.render() {

        div(props.rootStyle) {
            appBar {  }
        }
    }

    companion object {
        fun render(rBuilder: RBuilder) = rBuilder.childWithStyles(
            Header::class,
            "root" to root
        ) { }

        private val root = CSSBuilder().apply {
            display = Display.flex
        }

        private val header = CSSBuilder().apply {
            boxShadow = BoxShadows.none
        }

        fun test() {

            createMuiTheme {
                palette {

                }
                mixins {
                    gutters("")[""]
                    toolbar.minHeight
                    toolbar[""]
                }
            }
        }
    }
}