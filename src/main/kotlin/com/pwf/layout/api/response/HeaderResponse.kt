package com.pwf.header.api.response

import com.pwf.header.api.model.dto.Icons
import com.pwf.header.api.model.dto.OptionsMenu
import com.pwf.header.api.model.entities.Header

class HeaderResponse (
    val id:String?,
    val logoImg:String?,
    val listMenu:List<OptionsMenu?>,
    val listIcons:List<Icons>?,
    val isDeleted:Boolean?
) {
    companion object{
        fun fromEntity(header: Header):HeaderResponse =
            HeaderResponse(
                id = header.id!!,
                logoImg = header.logoImg,
                listMenu = header.listMenu,
                listIcons = header.listIcons,
                isDeleted = header.isDeleted
            )
    }
}