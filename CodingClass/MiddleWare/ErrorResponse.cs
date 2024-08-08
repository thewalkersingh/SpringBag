namespace CodingClass.MiddleWare;

public class ErrorResponse
{
    public string Message { get; set; }
    public List<string> Details { get; set; } = new List<string>();
}
