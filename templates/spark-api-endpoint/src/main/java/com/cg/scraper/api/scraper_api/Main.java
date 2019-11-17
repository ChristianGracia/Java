package com.cg.scraper.api.scraper_api;
import static spark.Spark.*;

public class Main {
	public static void main(String[] args) {
         get(new Route("/all") {
            @Override
        public Object handle(Request request, Response response) {
            return  "test";
        }
            });
    }
}
