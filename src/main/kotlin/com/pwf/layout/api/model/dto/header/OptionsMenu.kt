package com.pwf.layout.api.model.dto

import java.util.Objects

class OptionsMenu (
    val title:String?,
    val type:String?,
    val options:Array<ElementsOptionsMenu?>,
    val href:String?
)