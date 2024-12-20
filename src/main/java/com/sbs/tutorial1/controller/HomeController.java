package com.sbs.tutorial1.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    int num;

    public HomeController() {
        num = -1;
    }

    @GetMapping("home/main")
    @ResponseBody
    public String showHome() {
        return "어서오세요.";
    }

    @GetMapping("home/main2")
    @ResponseBody
    public String showHome2() {
        return "환영합니다.";
    }

    @GetMapping("home/main3")
    @ResponseBody
    public String showHome3() {
        return "스프링부트 획기적이다.";
    }

    @GetMapping("home/increase")
    @ResponseBody
    public int showIncrease() {
        num++;
        return num;
    }

    @GetMapping("home/plus")
    @ResponseBody
    public int showPlus(@RequestParam(defaultValue = "0") int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("home/returnBoolean")
    @ResponseBody
    public boolean showReturnBoolean() {
        return true;
    }

    @GetMapping("home/returnDouble")
    @ResponseBody
    public Double showReturnDouble() {
        return Math.PI;
    }

    @GetMapping("home/returnArray")
    @ResponseBody
    public int[] showReturnArray() {
        int[] arr = new int[]{10,20,30};

        return arr;
    }

    @GetMapping("home/returnIntList")
    @ResponseBody
    public List<Integer> showReturnIntList() {
        List<Integer> list = new ArrayList<>(){{
            add(10);
            add(20);
            add(30);
        }};

        return list;
    }

    @GetMapping("home/returnMap")
    @ResponseBody
    public Map<String, Object> showReturnMap() {
        Map<String, Object> map = new LinkedHashMap<>(){{
           put("id", 1);
           put("subject", "제목1");
           put("content", "내용1");
           put("writerName", "김철수");
           put("articleNo", new ArrayList<>() {{
               add(10);
               add(20);
               add(30);

           }});
        }};

        return map;
    }

    @GetMapping("home/returnArticle")
    @ResponseBody
    public Article showReturnArticle() {
       Article article = new Article(1, "제목1", "내용1", "김철수", new ArrayList<>() {{
           add(1);
           add(2);
           add(3);

       }});

       return article;
    }

    @GetMapping("home/returnArticle2")
    @ResponseBody
    public Article2 showReturnArticle2() {
        Article2 article = new Article2(1, "제목1", "내용1", "김철수", new ArrayList<>() {{
            add(1);
            add(2);
            add(3);

        }});

        return article;
    }

    @GetMapping("home/returnArticleMapList")
    @ResponseBody
    public List<Map<String, Object>> showReturnMapList() {
        Map<String, Object> articleMap1 = new LinkedHashMap<>() {{
            put("id", 1);
            put("subject", "제목1");
            put("content", "내용1");
            put("writerName", "김철수");
            put("articleNo", new ArrayList<>() {{
                add(1);
                add(2);
                add(3);
            }});
        }};

        Map<String, Object> articleMap2 = new LinkedHashMap<>() {{
            put("id", 2);
            put("subject", "제목2");
            put("content", "내용2");
            put("writerName", "신짱구");
            put("articleNo", new ArrayList<>() {{
                add(4);
                add(5);
                add(6);
            }});
        }};

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(articleMap1);
        list.add(articleMap2);

        return list;
    }

    @GetMapping("home/returnArticleList")
    @ResponseBody
    public List<Article2> showReturnArticleList() {
        Article2 article1 = new Article2(1, "제목1", "내용1", "김철수", new ArrayList<>() {{
            add(1);
            add(2);
            add(3);

        }});

        Article2 article2 = new Article2(2, "제목2", "내용2", "신짱구", new ArrayList<>() {{
            add(4);
            add(5);
            add(6);
        }});

        List<Article2> list = new ArrayList<>();
        list.add(article1);
        list.add(article2);


        return list;
    }


}

class Article {
    private final int id;
    private final String subject;
    private final String content;
    private final String writerName;
    private final List<Integer> articleNo;

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getWriterName() {
        return writerName;
    }

    public List<Integer> getArticleNo() {
        return articleNo;
    }

    public Article(int id, String subject, String content, String writerName, List<Integer> articleNo) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.writerName = writerName;
        this.articleNo = articleNo;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", writerName='" + writerName + '\'' +
                ", articleNo=" + articleNo +
                '}';
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Article2 {
    int id;
    String subject;
    String content;
    String writerName;
    List<Integer> articleNo;

}