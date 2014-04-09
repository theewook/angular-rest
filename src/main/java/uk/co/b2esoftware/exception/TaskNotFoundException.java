package uk.co.b2esoftware.exception;

/**
 * Created by TheEwook on 09/04/2014.
 */
public class TaskNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = -2859292084648724403L;
    private final long taskId;

    public TaskNotFoundException(long id)
    {
        taskId = id;
    }

    public long getTaskId()
    {
        return taskId;
    }
}
