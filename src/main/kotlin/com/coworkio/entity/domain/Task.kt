package com.coworkio.entity.domain

import com.coworkio.entity.domain.enum.Priority
import com.coworkio.entity.domain.enum.TaskLevel
import com.coworkio.entity.domain.enum.TaskType
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.io.Serializable
import java.util.*

@Document(collection = "task")
data class Task(

        var id: String?,

        @Field(value = "base_info")
        var baseInfo: BaseInfo,

        var title: String,

        @Field(value = "task_level")
        var taskLevel: TaskLevel,

        @Field(value = "task_type")
        var taskType: TaskType,

        var subtasks: List<String>?,

        @Field(value = "parent_task")
        var parentTask: String?,

        @Field(value = "related_tasks")
        var relatedTasks: List<String>?,

        var description: String?,

        @Field(value = "author_id")
        var authorId: String,

        @Field(value = "assignee_id")
        var assigneeId: String?,

        var estimate: Double?,
        var priority: Priority,
        var tags: List<String>?,
        var status: Int,

        @Field(value = "sprint_id")
        var sprintId: String?,

        @Field(value = "project_id")
        var projectId: String,

        var comments: List<Comment>?,

        @Field(value = "due_date")
        var dueDate: Date?
):Serializable