package uk.co.b2esoftware.service;

import org.springframework.stereotype.Service;
import uk.co.b2esoftware.vo.TaskDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manuel DEQUEKER on 31/01/2014.
 */
@Service
public class TaskService
{
    private static Map<Long, TaskDTO> tasks = new HashMap<Long, TaskDTO>();
    private static long id;

    static
    {
        TaskDTO task;
        for (int i=0; i<2; i++)
        {
            task = new TaskDTO();
            task.setId(id++);
            task.setName("task" + i);
            tasks.put(task.getId(), task);
        }
    }

    public List<TaskDTO> getTasks()
    {
        return new ArrayList(tasks.values());
    }

    public TaskDTO getTask(final Long taskId)
    {
        return tasks.get(taskId);
    }

    public void addTask(final TaskDTO task)
    {
        task.setId(id++);
        tasks.put(task.getId(), task);
    }

    public void updateTask(final long taskId, final TaskDTO task)
    {
        tasks.put(taskId, task);
    }

    public void removeTask(final Long taskId)
    {
        tasks.remove(taskId);
    }
}
