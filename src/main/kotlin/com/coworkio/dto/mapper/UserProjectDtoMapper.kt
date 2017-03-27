package com.coworkio.dto.mapper

import com.coworkio.dto.UserProjectDto
import com.coworkio.entity.domain.UserProject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class UserProjectDtoMapper(
        @Autowired val positionInfoDtoMapper: PositionInfoDtoMapper) : DtoMapper<UserProject, UserProjectDto> {

    override fun toDomain(dto: UserProjectDto)
            = UserProject(
                projectId = dto.projectId,
                isCurrent = dto.isCurrent,
                startDate = dto.startDate,
                endDate = dto.endDate,
                positionInfo = positionInfoDtoMapper.toDomain(dto.positionInfo)
    )

    override fun toDto(domain: UserProject)
            = UserProjectDto(
                projectId = domain.projectId,
                isCurrent = domain.isCurrent,
                startDate = domain.startDate,
                endDate = domain.endDate,
                positionInfo = positionInfoDtoMapper.toDto(domain.positionInfo)
    )
}