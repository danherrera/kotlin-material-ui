package materialui

import kotlinext.js.js
import kotlinext.js.jsObject
import materialui.styles.muitheme.MuiTheme

@JsModule("@material-ui/core/useMediaQuery")
private external val useMediaQueryModule: dynamic

private fun rawUseMediaQuery(
    query: dynamic,
    options: dynamic
): Boolean = useMediaQueryModule.default(query, options) as Boolean

external interface SsrMatchMediaResult {
    var matches: Boolean
}

external interface UseMediaQueryOption {
    var defaultMatches: Boolean
    var noSsr: Boolean
    var ssrMatchMedia: ((query: String) -> SsrMatchMediaResult)?
}

fun useMediaQuery(query: String) = rawUseMediaQuery(query, js {})

fun useMediaQuery(
    query: String,
    defaultMatches: Boolean = false,
    noSsr: Boolean = false,
    ssrMatchMedia: ((query: String) -> SsrMatchMediaResult)?
) = rawUseMediaQuery(
    query,
    jsObject<UseMediaQueryOption> {
        this.defaultMatches = defaultMatches
        this.noSsr = noSsr
        this.ssrMatchMedia = ssrMatchMedia
    }
)

fun useMediaQuery(query: (theme: MuiTheme) -> String) = rawUseMediaQuery(query, js {})

fun useMediaQuery(
    query: (theme: MuiTheme) -> String,
    defaultMatches: Boolean = false,
    noSsr: Boolean = false,
    ssrMatchMedia: ((query: String) -> SsrMatchMediaResult)?
) = rawUseMediaQuery(
    query,
    jsObject<UseMediaQueryOption> {
        this.defaultMatches = defaultMatches
        this.noSsr = noSsr
        this.ssrMatchMedia = ssrMatchMedia
    }
)
