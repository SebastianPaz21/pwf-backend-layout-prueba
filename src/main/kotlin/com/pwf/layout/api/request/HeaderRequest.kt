package com.pwf.header.api.request

import com.pwf.header.api.model.dto.Icons
import com.pwf.header.api.model.dto.OptionsMenu

class HeaderRequest (
    val id:String?,
    val logoImg:String?,
    val listMenu:List<OptionsMenu?>,
    val listIcons:List<Icons>?,
    val isDeleted:Boolean?
)