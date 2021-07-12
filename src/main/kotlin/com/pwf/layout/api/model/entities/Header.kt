package com.pwf.header.api.model.entities

import com.pwf.header.api.model.dto.Icons
import com.pwf.header.api.model.dto.OptionsMenu
import org.springframework.data.annotation.Id

data class Header(
    @Id
    var id:String? = null,
    var logoImg:String?,
    var listMenu:List<OptionsMenu?>,
    var listIcons:List<Icons>?,
    var isDeleted:Boolean?
)