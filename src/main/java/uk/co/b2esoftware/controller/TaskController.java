package uk.co.b2esoftware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uk.co.b2esoftware.exception.TaskNotFoundException;
import uk.co.b2esoftware.service.TaskService;
import uk.co.b2esoftware.vo.TaskDTO;

import java.util.List;

/**
 * Created by Manuel DEQUEKER on 03/02/2014.
 */
@Controller
@RequestMapping("/tasks")
public class TaskController
{
    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<TaskDTO> getTasks()
    {
        return taskService.getTasks();
    }

    @RequestMapping(value = "{taskId}", method = RequestMethod.GET)
    @ResponseBody
    public TaskDTO getTask(@PathVariable final long taskId) throws Exception {
        TaskDTO task = taskService.getTask(taskId);
        if (task == null) throw new TaskNotFoundException(taskId);
        return task;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public TaskDTO addTask(@RequestBody final TaskDTO task)
    {
        taskService.addTask(task);
        return task;
    }

    @RequestMapping(value = "{taskId}", method = RequestMethod.PUT)
    @ResponseBody
    public TaskDTO updateTask(@PathVariable final long taskId, @RequestBody final TaskDTO task)
    {
        taskService.updateTask(taskId, task);
        return task;
    }

    @RequestMapping(value = "{taskId}", method = RequestMethod.DELETE)
    @ResponseBody
    public TaskDTO deleteTask(@PathVariable final long taskId)
    {
        TaskDTO task = taskService.getTask(taskId);
        taskService.removeTask(taskId);
        return task;
    }
}
