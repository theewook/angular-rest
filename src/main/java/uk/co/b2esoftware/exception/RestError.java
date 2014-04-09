package uk.co.b2esoftware.exception;

/**
 * Created by TheEwook on 09/04/2014.
 */
public class RestError
{
    private final String url;
    private final String message;

    public RestError(String url, String message)
    {
        this.url = url;
        this.message = message;
    }

    public String getUrl()
    {
        return url;
    }

    public String getMessage()
    {
        return message;
    }
}
