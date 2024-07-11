package com.restrictedmodecontext.simplemvvmrestrictedmodecontext.views.changecolor

import com.restrictedmodecontext.simplemvvmrestrictedmodecontext.model.colors.NamedColor

/**
 * Represents list item for the color; it may be selected or not
 */
data class NamedColorListItem(
    val namedColor: NamedColor,
    val selected: Boolean
)