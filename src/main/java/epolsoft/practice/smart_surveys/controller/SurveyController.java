package epolsoft.practice.smart_surveys.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;
import java.util.List;
import java.util.Objects;

//@RestController
@RequiredArgsConstructor
@RequestMapping("/survey")
@Tag(name = "Опросник",description = "Все методы для работы с опросником")
@Controller
public class SurveyController
{
    static Connection dbConnection;
    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://localhost:5432/smart_surveys";
        Class.forName("org.postgresql.Driver");
        dbConnection = DriverManager.getConnection(connectionString, "postgres", "322644");
        System.out.println("Hello world!!!");
        return  dbConnection;
    }

    @GetMapping("{id}/submit")
    public String submit_answer(@PathVariable Long id) throws JSONException
    {
        //забираем json (тестовую ссылку заменить на ссылку для получения json проекта)
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/comments")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)//для вывода в консоль
                //.thenAccept(SurveyController::parse)//для запуска распаковки json
                .join();

        return "redirect:/hello";
    }

    public static void parse(String responseBody)
    {
        try
        {
            /*
            //тест получения данных для тестовой ссылки на json
                int id = question.getInt("id");
                String text = question.getString("name");
                System.out.println("id: " + id + " text: " + text);
            */

            //Перебор всего json, разбивая на объекты.
            //Достаем нужные данные(id ответа из списка всех ответов, id юзера, текст ответа)
            JSONArray jsonArray = new JSONArray(responseBody);
            for (int i = 0; i< jsonArray.length(); i++)
            {
                JSONObject question = jsonArray.getJSONObject(i);

                int user_id = question.getInt("user_id");

                JSONArray array = question.getJSONArray("answer");
                for(int j =0; j< array.length(); j++)
                {
                    //строка с текстом ответа
                    String answer_text = array.getString(i);
                    //селект из таблицы ответов, достать айди этого ответа
                    PreparedStatement prSt_answer = getDbConnection().
                            prepareStatement("SELECT * FROM answer_option WHERE option_text = ?");
                    prSt_answer.setString(1, answer_text);
                    int answer_id = prSt_answer.executeQuery().getInt("id");


                    //инсерт в таблицу user_vote (айди ответа, айди юзера, текст ответа)
                    //создаем строку для запроса
                    String insert = "INSERT INTO user_vote (answer_option_id, user_id, text)" + "VALUES(?,?,?)";
                    PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                    //устанавливаем значения в строку запроса
                    prSt.setInt(1, answer_id);
                    prSt.setInt(2, user_id);
                    prSt.setString(3, answer_text);
                    //исполняем запрос
                    prSt.executeUpdate();

                }

            }
        }
        catch (JSONException jsonException) {System.out.println("Exception from parse json");} catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Макет опроса
Текст вопроса_1

ответ 1
ответ 2
ответ 3

Текст вопроса_2

ответ 1
ответ 2
ответ 3

 */
/*
Формат будущего json
"id" - id вопроса
"user_id" - id пороголосовавшего
"question_text" - текст вопроса
"type" - один ответ/много [single/variable]
"checked_id" - выбраный вариант ответа [массив]
"answer" - вариант ответа [массив]

 */