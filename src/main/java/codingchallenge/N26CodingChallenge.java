package codingchallenge;

import static spark.Spark.*;

import com.google.gson.Gson;

import core.InMemoryTransactionStatisticsManager;
import core.Transaction;

public class N26CodingChallenge {
    public static void main(String[] args) {
        InMemoryTransactionStatisticsManager manager = new InMemoryTransactionStatisticsManager(60000);
        Gson gson = new Gson();
        get("/hello", (req, res) -> "Hello World");
        get("/statistics", (req, res) -> manager.getStatistics(), gson::toJson);
        post("/transactions", (req, res) -> {
            Transaction tx = Transaction.fromJson(req.body());
            if (manager.addTransaction(tx)) {
                res.status(201);
            } else {
                res.status(204);
            }
            return "";
        });
    }
}
