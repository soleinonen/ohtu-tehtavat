/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.http.client.fluent.Request;
import java.util.*;

/**
 *
 * @author mluukkai
 */
public class Main {
	public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        SimpleDateFormat format = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy\n");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("Players from FIN "+format.format(date));
        
        Arrays.stream(players)
        .filter(player -> player.getNationality().contentEquals("FIN"))
        .sorted()
        .forEach(player->System.out.println(player));
    }
  
}
