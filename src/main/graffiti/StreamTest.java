package main.graffiti;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list.stream().filter(item -> item.equals("d")).collect(Collectors.toList()));

        if (true){

        }



    }
}
