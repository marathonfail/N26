package codingchallenge;
import static spark.Spark.*;

public class N26CodingChallenge {
	public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
        get("/statistics", (req, res) -> {
        	return "{}";
        });
        post("/transactions", (req, res) -> {
        	res.status(204);
        	return "";
        });
    }
}
